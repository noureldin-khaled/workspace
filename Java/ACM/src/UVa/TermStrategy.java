package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TermStrategy {
	static int n, m;
	static int table[][];
	static final int INF = (int)2e9;
	static final double EPS = 1e-9;
	static int dp[][];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-->0) {
			n = sc.nextInt();
			m = sc.nextInt();
			table = new int[n][m];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					table[i][j] = sc.nextInt();
			
			dp = new int[n+5][m+5];
			for (int i = 0; i < n+5; i++)
				Arrays.fill(dp[i], -1);
			double ans = rec(0, m);
			if (ans + EPS < 0)
				out.println("Peter, you shouldn't have played billiard that much.");
			else
				out.printf("Maximal possible average mark - %.2f.\n",(double)ans/n);
		}
		
		out.flush();
		out.close();
	}
	
	static int rec(int idx, int remH) {
		if (remH < 0)
			return -INF;
		if (idx == n)
			return 0;
		
		if (dp[idx][remH] != -1)
			return dp[idx][remH];
		int ans = -INF;
		for (int i = 0; i < m; i++)
			if (table[idx][i] >= 5)
				ans = Math.max(ans, table[idx][i] + rec(idx+1, remH - (i+1)));
			
		return dp[idx][remH] = ans;
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
