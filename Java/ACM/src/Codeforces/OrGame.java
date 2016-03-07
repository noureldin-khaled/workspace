package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class OrGame {
	static int arr[];
	static long dp[][];
	static int n;
	static long power[];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		n = sc.nextInt();
		int k = sc.nextInt();
		int x = sc.nextInt();
		
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
			
		dp = new long[n+5][k+5];
		for (int i = 0; i < n+5; i++)
			Arrays.fill(dp[i], -1);
		
		power = new long[k+2];
		power[0] = 1;
		for (int i = 1; i < k+2; i++)
			power[i] = power[i-1]*x;
		
		long ans1 = rec(0, k);
		
		for (int i = 0; i < n/2; i++) {
			int temp = arr[i];
			arr[i] = arr[n-1-i];
			arr[n-1-i] = temp;
		}
		
		dp = new long[n+5][k+5];
		for (int i = 0; i < n+5; i++)
			Arrays.fill(dp[i], -1);
		long ans2 = rec(0, k);
		
		out.println(Math.max(ans1, ans2));
		
		out.flush();
		out.close();
	}
	
	public static long rec(int index, int remMoves) {
		if (index == n)
			return 0;
		
		if (dp[index][remMoves] != -1)
			return dp[index][remMoves];
		
		long take = 0;
		for (int i = 1; i <= remMoves; i++) 
			take = Math.max(rec(index+1, remMoves-i) | arr[index]*power[i], take);
		long leave = rec(index+1, remMoves) | arr[index];
		
		return dp[index][remMoves] = Math.max(take, leave);
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