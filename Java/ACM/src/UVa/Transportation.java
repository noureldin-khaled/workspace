package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Transportation {
    static int n;
    static int o;
    static Order arr[];
    
    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	
	while(true) {
	    n = sc.nextInt();
	    int b = sc.nextInt();
	    o = sc.nextInt();

	    if (n == 0 && b == 0 && o == 0)
		break;

	    arr = new Order[o];
	    for (int i = 0; i < o; i++) 
		arr[i] = new Order(sc.nextInt(), sc.nextInt(), sc.nextInt());
	    
	    int people[] = new int[b];
	    int ans = rec(0, people);
	    out.println(ans);
	}

	out.flush();
	out.close();
    }
    
    public static int rec(int index, int[] people) {
	if (index == o)
	    return 0;
	
	boolean valid = true;
	int peopleClone[] = people.clone();
	for (int i = arr[index].start; i < arr[index].destintation && valid; i++) {
	    people[i] += arr[index].passengers;
	    if (people[i] > n)
		valid = false;
	}
	
	int take = 0;
	if (valid)
	    take = rec(index+1, people.clone()) + arr[index].price();
	
	int leave = rec(index+1, peopleClone);
	
	return Math.max(take, leave);
    }
   
    
    private static class Order {
	int start;
	int destintation;
	int passengers;

	public Order(int start, int destintation, int passengers) {
	    this.start = start;
	    this.destintation = destintation;
	    this.passengers = passengers;
	}

	public int price() {
	    return passengers * (destintation-start);
	}
	
	@Override
	public String toString() {
	    return "((" + start + "," + destintation + ") | " + passengers + ")";
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

    }

}
