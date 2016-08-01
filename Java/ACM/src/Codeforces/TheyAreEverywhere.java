package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class TheyAreEverywhere {
	static char[] c;
	static int a[][];
	static int n;
	static TreeSet<Character> distinct;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		n = sc.nextInt();
		c = sc.nextLine().toCharArray();
		
		distinct = new TreeSet<>();
		
		for (int i = 0; i<  n; i++)
			if (!distinct.contains(c[i]))
				distinct.add(c[i]);
		
		
		a = new int[100][n];
		for (Character ch : distinct) {
			int idx = ch-'A';
			a[idx][0] = 0;
			if (c[0] == ch)
				a[idx][0]++;
			
			for (int i = 1; i < n; i++) {
				a[idx][i] = a[idx][i-1];
				if (c[i] == ch)
					a[idx][i]++;
			}
		}
		
		int low = 1;
		int high = n;
		int ans = -1;
		
		while(low <= high) {
			int mid = low + (high-low)/2;
			
			if (valid(mid)) {
				ans = mid;
				high = mid-1;
			}
			else
				low = mid+1;
		}
		
		out.println(ans);
		
		out.flush();
		out.close();
	}
	
	static boolean valid(int mid) {
		for (int i = 0; i < n; i++) {
			int j = i+mid-1;
			if (j >= n) break;
			boolean v = true;
			for (Character ch : distinct) {
				int idx = ch-'A';
				int term = a[idx][j];
				if (i > 0)
					term -= a[idx][i-1];
				if (term == 0)
					v = false;
			}
			
			if (v)
				return true;
		}
		
		return false;
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
