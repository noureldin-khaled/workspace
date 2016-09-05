package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HardProblem {
	static long c[];
	static String a[][];
	static int n;
	static final long INF = (long)1e18;
	static long dp[][][];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		n = sc.nextInt();
		c = new long[n];
		for (int i = 0; i < n; i++)
			c[i] = sc.nextLong();
		
		a = new String[n][2];
		for (int i = 0; i < n; i++)
		{
			StringBuilder sb = new StringBuilder(sc.next());
			a[i][0] = sb.toString();
			StringBuilder sr = sb.reverse();
			a[i][1] = sr.toString();
		}
		
		dp = new long[n+2][3][3];
		for (int i = 0; i < n+2; i++)
			for (int j = 0; j < 3; j++)
				Arrays.fill(dp[i][j], -1);
		
		long ans = rec(0, 0, 0);
		if (ans >= INF)
			out.println(-1);
		else
			out.println(ans);
		
		out.flush();
		out.close();
	}
	
	static long rec(int idx, int rev, int locked)
	{
		if (idx == n-1)
			return 0;
		
		if (dp[idx][rev][locked] != -1)
			return dp[idx][rev][locked];
		
		String s1 = a[idx][rev];
		String s1Rev = a[idx][1-rev];
		String s2 = a[idx+1][0];
		String s2Rev = a[idx+1][1];
		int c2 = s1.compareTo(s2Rev);
		int c4 = s1.compareTo(s2);
		
		if (locked == 1)
		{
			long choice1 = INF;
			if (c2 <= 0)
			{
				if (c4 <= 0)
					choice1 = rec(idx+1, 1, 0) + c[idx+1];
				else
					choice1 = rec(idx+1, 1, 1) + c[idx+1];
			}
			
			long choice2 = INF;
			if (c4 <= 0)
			{
				if (c2 <= 0)
					choice2 = rec(idx+1, 0, 0);
				else
					choice2 = rec(idx+1, 0, 1);
			}
			
			return dp[idx][rev][locked] = Math.min(choice1, choice2);
		}
		else
		{
			int c1 = s1Rev.compareTo(s2);
			int c3 = s1Rev.compareTo(s2Rev);
			
			long choice1 = INF;
			if (c1 <= 0)
			{
				if (c3 <= 0)
					choice1 = rec(idx+1, 0, 0) + c[idx];
				else
					choice1 = rec(idx+1, 0, 1) + c[idx];
			}
			
			long choice2 = INF;
			if (c2 <= 0)
			{
				if (c4 <= 0)
					choice2 = rec(idx+1, 1, 0) + c[idx+1];
				else
					choice2 = rec(idx+1, 1, 1) + c[idx+1];
			}
				
			long choice3 = INF;
			if (c3 <= 0)
			{
				if (c1 <= 0)
					choice3 = rec(idx+1, 1, 0) + c[idx] + c[idx+1];
				else
					choice3 = rec(idx+1, 1, 1) + c[idx] + c[idx+1];
			}
			
			long choice4 = INF;
			if (c4 <= 0)
			{
				if (c2 <= 0)
					choice4 = rec(idx+1, 0, 0);
				else
					choice4 = rec(idx+1, 0, 1);
			}
			
			return dp[idx][rev][locked] = Math.min(Math.min(choice1, choice2), Math.min(choice3, choice4));
		}
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
