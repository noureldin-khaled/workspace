package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2DNim {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		while(t-->0) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			int n = sc.nextInt();

			boolean[][] grid = new boolean[w][h];
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				grid[x][y] = true;
			}

			int a1[] = calculate(grid, w, h);

			grid = new boolean[w][h];
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				grid[x][y] = true;
			}

			int a2[] = calculate(grid, w, h);

			Arrays.sort(a1);
			Arrays.sort(a2);
			if (eq(a1, a2))
				out.println("YES");
			else
				out.println("NO");
		}

		out.flush();
		out.close();
	}

	public static int[] calculate(boolean[][] grid, int w, int h) {
		int[][] left = new int[w][h];
		int[][] right = new int[w][h];
		int[][] up = new int[w][h];
		int[][] down = new int[w][h];

		int r[] = new int[w*h];

		for (int i = 0; i < w; i++)
			for (int j = 0, count = 0; j < h; j++)
				if (grid[i][j])
					left[i][j] = count++;
				else
					count = 0;
		
		for (int i = 0; i < w; i++)
			for (int j = h-1, count = 0; j >= 0; j--)
				if (grid[i][j])
					right[i][j] = count++;
				else
					count = 0;

		for (int j = 0; j < h; j++)
			for (int i = 0, count = 0; i < w; i++)
				if (grid[i][j])
					down[i][j] = count++;
				else
					count = 0;

		for (int j = 0; j < h; j++)
			for (int i = w-1, count = 0; i >= 0; i--)
				if (grid[i][j])
					up[i][j] = count++;
				else
					count = 0;

		int count = 0;
		for (int i = 0; i < w; i++)
			for (int j = 0; j < h; j++)
				r[count++] = left[i][j] + right[i][j] + up[i][j] + down[i][j];

		return r;
	}

	public static boolean eq(int[] a1, int[] a2) {

		for (int i = 0; i < a1.length; i++)
			if (a1[i] != a2[i])
				return false;
		return true;
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
