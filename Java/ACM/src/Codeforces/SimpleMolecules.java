package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SimpleMolecules {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
		if (b > a+c || a > b+c || c > a+b || (a+b+c)%2 != 0)
			out.println("Impossible");
		else
			out.println((b+a-c)/2 + " " + (c+b-a)/2 + " " + (c+a-b)/2);
		
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

	    public String next() throws IOException {
	        while (st == null || !st.hasMoreTokens())
	            st = new StringTokenizer(br.readLine());
	        return st.nextToken();
	    }

	    public String nextLine() throws IOException {
	        return br.readLine();
	    }

	    public int nextInt() throws IOException {
	        return Integer.parseInt(next());
	    }

	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }

	    public double nextDouble() throws IOException {
	        return Double.parseDouble(next());
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
