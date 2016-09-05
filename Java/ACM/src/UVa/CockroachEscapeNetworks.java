package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CockroachEscapeNetworks {
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		for (int c = 1; c <= t; c++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] adjmatrix = new int[n][n];
			Edge edgelist[] = new Edge[m];
			
			for (int i = 0; i < n; i++)
				Arrays.fill(adjmatrix[i], INF);
			for (int i = 0; i < n; i++)
				adjmatrix[i][i] = 0;
			for (int i = 0; i < m; i++) {
				int u = sc.nextInt(), v = sc.nextInt();
				adjmatrix[u][v] = adjmatrix[v][u] = 1;
				edgelist[i] = new Edge(u, v);
			}
			
			for(int k = 0; k < n; k++)
				for(int i = 0; i < n; i++)
					for(int j = 0; j < n; j++)
						if(adjmatrix[i][j] > adjmatrix[i][k] + adjmatrix[k][j]) 
							adjmatrix[i][j] = adjmatrix[i][k] + adjmatrix[k][j];
			
			int ans = INF;
			for (int i = 0; i < n; i++) {
				int max = 0;
				for (int j = 0; j < n; j++)
					max = Math.max(max, adjmatrix[i][j]);
				ans = Math.min(ans, 2*max);
			}
			
			for (int i = 0; i < m; i++) {
				int max = 0;
				for (int j = 0; j < n; j++)
					max = Math.max(max, Math.min(adjmatrix[edgelist[i].from][j], adjmatrix[edgelist[i].to][j]));
				ans = Math.min(ans, 2*max + 1);
			}
			
			out.printf("Case #%d:\n%d\n\n", c, ans);
		}
		
		out.flush();
		out.close();
	}
	
	static class Edge {
		int from, to;
		
		public Edge(int f, int t) {
			from = f;
			to = t;
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
