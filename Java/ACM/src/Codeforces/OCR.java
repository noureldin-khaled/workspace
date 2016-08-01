package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OCR {
	static char grid[][];
	static boolean visited[][];
	static int n, m;
	static final int dx[] = {-1,0,1, 0};
	static final int dy[] = { 0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		int cases = 1;
		while(t-->0) {
			n = sc.nextInt();
			m = sc.nextInt();
			grid = new char[n][m];
			
			for (int i = 0; i < n; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < m; j++)
					grid[i][j] = line.charAt(j);
			}
			
			visited = new boolean[n][m];
			int c = 0;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					if (!visited[i][j] && grid[i][j] == '.') {
						dfs(i, j);
						c++;
					}
			
			out.printf("Case %d: ", cases++);
			out.println(c == 3 ? "Eight" : "Zero");
		}
		
		out.flush();
		out.close();
	}
	
	public static void dfs(int i, int j) {
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int newI = i + dx[k];
			int newJ = j + dy[k];

			if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && grid[newI][newJ] == grid[i][j] && !visited[newI][newJ])
				dfs(newI, newJ);
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