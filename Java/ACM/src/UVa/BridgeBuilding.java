package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BridgeBuilding {
	static final int INF = (int)1e9;
	static int k, n, m;
	static char grid[][];
	static boolean visited[][];
	static int a1[];
	static int a2[];
	static final int dx[] = {-1,0,1, 0};
	static final int dy[] = { 0,1,0,-1};
	static int c[];
	static int dp[][];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		sc.waitForInput(1500);
		while(sc.Ready()) {
			n = sc.nextInt();
			m = sc.nextInt();
			int b = sc.nextInt();
			k = sc.nextInt();
			grid = new char[n][m];
			
			for (int i = 0; i < n; i++) {
				String s = sc.nextLine();
				for (int j = 0; j < m; j++)
					grid[i][j] = s.charAt(j);
			}
			
			a1 = new int[m];
			a2 = new int[m];
			Arrays.fill(a2, n-1);
			
			visited = new boolean[n][m];
			dfs1(0, 0);
			dfs2(n-1, 0);
			
			c = new int[m];
			for (int i = 0; i < m; i++)
				c[i] = a2[i] - (a1[i] + 1);
			
			dp = new int[m+3][b+3];
			for (int i = 0; i < m+3; i++)
				Arrays.fill(dp[i], -1);
			out.println(rec(0, b));
		}
		
		out.flush();
		out.close();
	}
	
	static int rec(int idx, int remB) {
		if (remB == 0)
			return 0;
		if (idx >= m)
			return INF;
		if (dp[idx][remB] != -1)
			return dp[idx][remB];
		
		int take = INF;
		if ((m-1-idx) >= (k+1)*(remB-1))
			take = rec(idx+k+1, remB-1) + c[idx];
		int leave = rec(idx+1, remB);
		
		return dp[idx][remB] = Math.min(take, leave);
	}
	
	static void dfs1(int i, int j) {
		visited[i][j] = true;
		
		for (int k = 0; k < 4; k++) {
			int newI = i + dx[k];
			int newJ = j + dy[k];
			
			if (valid(newI, newJ) && !visited[newI][newJ] && grid[newI][newJ] == '#')
				dfs1(newI, newJ);
			
			if (valid(newI, newJ) && grid[newI][newJ] == '.' && k == 2)
				a1[j] = Math.max(a1[j], i);
		}
	}

	static void dfs2(int i, int j) {
		visited[i][j] = true;
		
		for (int k = 0; k < 4; k++) {
			int newI = i + dx[k];
			int newJ = j + dy[k];
			
			if (valid(newI, newJ) && !visited[newI][newJ] && grid[newI][newJ] == '#')
				dfs2(newI, newJ);
			
			if (valid(newI, newJ) && grid[newI][newJ] == '.' && k == 0)
				a2[j] = Math.min(a2[j], i);
		}
	}
	
	static boolean valid(int i, int j) {
		return i >= 0 && i < n && j >= 0 && j < m;
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
