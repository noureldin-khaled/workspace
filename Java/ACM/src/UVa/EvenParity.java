package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EvenParity {
	static int grid[][];
	static int n;
	static final int INF = (int)1e9;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		for (int c = 1; c <= t; c++) {
			n = sc.nextInt();
			grid = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					grid[i][j] = sc.nextInt();

			int ans = rec(0, 0);
			out.printf("Case %d: ", c);
			if (ans >= INF)
				out.println(-1);
			else
				out.println(ans);
		}

		out.flush();
		out.close();
	}

	static int rec(int c, int moves) {
		if (c == n) 
			return moves + cont();
		if (grid[0][c] == 1)
			return rec(c+1, moves);
		
		grid[0][c] = 1;
		int change = rec(c+1, moves+1);
		grid[0][c] = 0;
		int leave = rec(c+1, moves);
		
		return Math.min(change, leave);
	}
	
	static int cont() {
		int tmp[][] = grid.clone();
		int moves = 0;
		for (int i = 0; i < n-1; i++) {
			int a[] = new int[n];
			for (int j = 0; j < n; j++) {
				int p = parity(i, j, tmp);
				if (p%2 != 0) {
					moves++;
					a[j] = 1 - tmp[i+1][j];
				}
				else
					a[j] = tmp[i+1][j];
			}
			
			for (int j = 0; j < n; j++)
				if ((a[j] | tmp[i+1][j]) != a[j])
					return INF;
			tmp[i+1] = a; 
		}
		
		return moves;
	}
	
	static int parity(int i, int j, int[][] grid) {
		int res = 0;
		if (valid(i+1, j) && grid[i+1][j] == 1)
			res++;
		if (valid(i-1, j) && grid[i-1][j] == 1)
			res++;
		if (valid(i, j+1) && grid[i][j+1] == 1)
			res++;
		if (valid(i, j-1) && grid[i][j-1] == 1)
			res++;
		return res;
	}

	static boolean valid(int i, int j) {
		return i >= 0 && i < n && j >= 0 && j < n;
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
