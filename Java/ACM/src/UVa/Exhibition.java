package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exhibition {

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	
	int t = sc.nextInt();
	for (int c = 1; c <= t; c++) {
	    int n = sc.nextInt();
	    TreeSet<Integer> ts = new TreeSet<>();
	    int friends[] = new int[n];
	    boolean stamps[] = new boolean[10005];
	    ArrayList<Integer>[] input = new ArrayList[n];
	    for (int i = 0; i < n; i++) 
		input[i] = new ArrayList<>();
	    
	    for (int i = 0; i < n; i++) {
		int m = sc.nextInt();
		TreeSet<Integer> tempTs = new TreeSet<>();
		
		for (int j = 0; j < m; j++) {
		    int stamp = sc.nextInt();
		    if (!ts.contains(stamp)) {
			ts.add(stamp);
			tempTs.add(stamp);
			input[i].add(stamp);
			
		    }
		    else if (!tempTs.contains(stamp)) 
			    stamps[stamp] = true;
		}
	    }
	    
	    int total = 0;
	    for (int i = 0; i < n; i++) 
		for (int s : input[i]) 
		    if (!stamps[s]) {
			friends[i]++;
			total++;
		    }
	    
	    
	    double[] res = new double[n];
	    boolean all_zeros = true;
	    out.printf("Case %d: ",c);
	    for (int i = 0; i < n; i++) {
		double percent = (friends[i] * 1.0) / total;
		if (percent > 0)
		    all_zeros = false;
		res[i] = percent*100;
	    }
	    
	    if (!all_zeros) 
		for (int i = 0; i < n; i++)  {
		    out.printf("%.6f",res[i]);
		    out.print("%");
		    if (i != n-1)
			out.print(" ");
		}
	    out.println();
	}
	
	out.flush();
	out.close();
    }


    static class Scanner {
	BufferedReader br;
	StringTokenizer st;

	public Scanner(FileReader f) {
	    br = new BufferedReader(f);
	}

	public Scanner(InputStream in) {
	    br = new BufferedReader(new InputStreamReader(in));
	}

	public String Next() throws IOException {
	    while (st == null || !st.hasMoreTokens())
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
