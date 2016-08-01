package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ContemplationAlgebra {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true) {
			String[] s = sc.nextLine().split(" ");
			int p = Integer.parseInt(s[0]), q = Integer.parseInt(s[1]);
			if (s.length == 2 && p+q == 0) break;
			int n = Integer.parseInt(s[2]);
			
			long[][] a = new long[2][2];
			a[0][0] = p;
			a[0][1] = -q;
			a[1][0] = 1;
			a[1][1] = 0;
			long[][] b = new long[2][1];
			b[0][0] = p;
			b[1][0] = 2;
			
			long[][] res = matPow(a, n, 2);
			res = matMul(res, b, 2, 1);
			out.println(res[1][0]);
		}
		
		out.flush();
		out.close();
	}
	
	static long[][] matMul(long[][] a, long[][] b, int r, int c) {	// O(n^3)
		long ans[][] = new long[r][c];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				for (int k = 0; k < r; k++) 
					ans[i][j] += a[i][k] * b[k][j];		// If the number is big take the MOD
		return ans;
	}

	static long[][] matPow(long[][] base, int p, int n) {		// O(n^3 log p)
		long[][] ans = new long[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				ans[i][j] = (i == j ? 1 : 0); 	// Identity matrix

		while(p > 0) {
			if ((p & 1) == 1)	// if P is Odd
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
			while(System.currentTimeMillis() - ct < time) {};
		}

	}

}
