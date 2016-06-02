package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ShoppingTrip {
	static double save[];
	static int p;
	static int arr[];
	static double dist[][];
	static double dp[][];
	static final double INF = 1e9;
	static final double EPS = 1e-15;
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();

		while(t-->0) {
			int n = sc.nextInt()+1, m = sc.nextInt();

			dist = new double[n][n];
			for (int i = 0; i < n; i++)
				Arrays.fill(dist[i], INF);
			
			for (int i = 0; i < n; i++)
				dist[i][i] = 0;

			for (int i = 0; i < m; i++) {
				int u = sc.nextInt(), v = sc.nextInt();
				double cost = sc.nextDouble();
				
				dist[u][v] = Math.min(dist[u][v], cost);
				dist[v][u] = Math.min(dist[v][u], cost);
			}

			p = sc.nextInt();
			save = new double[p];
			arr = new int[p];

			for (int i = 0; i < p; i++) {
				int node = sc.nextInt();
				double dis = sc.nextDouble();
				arr[i] = node;
				save[i] = dis;
			}
			
			
			for(int k = 0; k < n; k++)
				for(int i = 0; i < n; i++)
					for(int j = 0; j < n; j++)
						if(dist[i][j] > dist[i][k] + dist[k][j]) 
							dist[i][j] = dist[i][k] + dist[k][j];
			
			dp = new double[n+10][(1 << p) + 10];
			for (int i = 0; i < n+10; i++)
				Arrays.fill(dp[i], -1);
			
			double ans = rec(0, 0);
			if (ans < EPS)
				out.println("Don\'t leave the house");
			else
				out.printf("Daniel can save $%.2f\n", ans);
		}

		out.flush();
		out.close();
	}

	public static double rec(int node, int mask) {
		if (dp[node][mask] != -1)
			return dp[node][mask];
		
		double ans = -dist[node][0];
		for (int i = 0; i < p; i++) {
			if (((1 << i) & mask) == 0) {
				double pay = dist[node][arr[i]];
				double profit = save[i] - pay;
				
				ans = Math.max(ans, rec(arr[i], mask | (1 << i)) + profit);
			}
		}

		return dp[node][mask] = ans;
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
