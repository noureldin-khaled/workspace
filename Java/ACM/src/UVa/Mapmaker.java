package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Mapmaker {

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	
	int n = sc.nextInt();
	int r = sc.nextInt();
	
	Array arr[] = new Array[n];
	TreeMap<String, Integer> tm = new TreeMap<>();
	for (int i = 0; i < n; i++) {
	    String name = sc.Next();
	    int base = sc.nextInt();
	    int cd = sc.nextInt();
	    int d = sc.nextInt();
	    
	    Bound bounds[] = new Bound[d+1];
	    for (int j = 1; j <= d; j++) 
		bounds[j] = new Bound(sc.nextInt(), sc.nextInt());
	        
	    long constants[] = new long[d+1];
	    constants[d] = cd;
	    
	    for (int j = d-1; j > 0; j--) 
		constants[j] = (long)constants[j+1] * (bounds[j+1].upper - bounds[j+1].lower + 1);
	    
	    constants[0] = base;
	    for (int j = 1; j <= d; j++) 
		constants[0] -= (constants[j]*bounds[j].lower);
	    
	    System.out.println(Arrays.toString(constants));
	    
	    tm.put(name, i);
	    arr[i] = new Array(name, base, cd, d, constants);
	}
	
	for (int i = 0; i < r; i++) {
	    String name = sc.Next();
	    int array_index = tm.get(name);
	    int d = arr[array_index].d;
	    
	    int indices[] = new int[d+1];
	    for (int j = 1; j <= d; j++) 
		indices[j] = sc.nextInt();
	    
	    long address = arr[array_index].constants[0];
	    
	    for (int j = 1; j <= d ; j++) 
		address += (indices[j] * arr[array_index].constants[j]);
	    
	    out.print(name + "[");
	    for (int j = 1; j <= d; j++) {
		out.print(indices[j]);
		if (j != d)
		    out.print(", "); 
	    }
	   
	    out.print("] = ");
	    out.println(address);
	}
	
	out.flush();
	out.close();
    }
    
    private static class Array {
	String name;
	int base;
	int cd;
	int d;
	long constants[];
	
	public Array(String name, int base, int cd, int d, long constants[]) {
	    this.name = name;
	    this.base = base;
	    this.cd = cd;
	    this.d = d;
	    this.constants = constants;
	}
	
    }
    
    private static class Bound {
	int lower;
	int upper;
	public Bound(int l, int u) {
	    lower = l;
	    upper = u;
	}
	
    }
    
    private static class Scanner {
	    BufferedReader br;
	    StringTokenizer st;

	    public Scanner(FileReader f) {
	        br = new BufferedReader(f);
	    }

	    public Scanner(InputStream in) {
	        br = new BufferedReader(new InputStreamReader(in));
	    }

	    public String Next() throws IOException {
	        if (st == null || !st.hasMoreTokens())
	        st = new StringTokenizer(br.readLine());
	        return st.nextToken();
	    }

	    public String nextLine() throws IOException {
	        return br.readLine();
	    }

	    public int nextInt() throws IOException {
	        return Integer.parseInt(Next());
	    }

	    public long nextLong() throws IOException {
	        return Long.parseLong(Next());
	    }

	    public double nextDouble() throws IOException {
	        return Double.parseDouble(Next());
	    }

	    public boolean Ready() throws IOException {
	        return br.ready();
	    }

	    public void waitForInput(long time) {
	        long ct = System.currentTimeMillis();
	        while(System.currentTimeMillis() - ct < time) {};
	    }

	    }

}
