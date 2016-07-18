package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chopsticks {
	static int n;
	static int a[];
	static long dp[][];
	static final long INF = (long)6e12;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-->0) {
			int k = sc.nextInt()+8;
			n = sc.nextInt();
			a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			
			dp = new long[n+5][k+10];
			for (int i = 0; i < n+5; i++)
				Arrays.fill(dp[i], -1);
			out.println(rec(0, k));
		}
		
		out.flush();
		out.close();
	}
	
	static long rec(int idx, int remK) {
		if (remK == 0)
			return 0;
		if (idx >= n-1)
			return INF;
		if (dp[idx][remK] != -1)
			return dp[idx][remK];
		
		long take = INF;
		if (n-idx-3 >= 3*(remK-1))
			take = rec(idx+2, remK-1) + badness(a[idx+1]-a[idx]);
		long leave = rec(idx+1, remK);
		
		return dp[idx][remK] = Math.min(take, leave);
	}
	
	static long badness(int f) {
		return (long)f*f;
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
