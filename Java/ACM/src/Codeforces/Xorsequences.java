package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Xorsequences {
	static final int MOD = (int) 1e9 + 7;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long k = sc.nextLong();

		long a[] = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextLong();

		int adjmatrix[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (Long.bitCount(a[i] ^ a[j]) % 3 == 0)
					adjmatrix[i][j] = 1;

		int res[][] = matPow(adjmatrix, k - 1, n);
		long ans = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				ans = ((ans + res[i][j]) % MOD);
		System.out.println(ans);
	}

	static int[][] matMul(int[][] a, int[][] b, int r, int c) {
		int ans[][] = new int[r][c];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				for (int k = 0; k < r; k++)
					ans[i][j] = (int) ((ans[i][j] + ((long)a[i][k] * b[k][j])) % MOD);
		return ans;
	}

	static int[][] matPow(int[][] base, long p, int n) {
		int[][] ans = new int[n][n];
		for (int i = 0; i < n; i++)
			ans[i][i] = 1;

		while (p > 0) {
			if ((p & 1) == 1)
				ans = matMul(ans, base, n, n);
			base = matMul(base, base, n, n);
			p >>= 1;
		}

		return ans;
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
			while (System.currentTimeMillis() - ct < time) {
			}
			;
		}

	}

}
