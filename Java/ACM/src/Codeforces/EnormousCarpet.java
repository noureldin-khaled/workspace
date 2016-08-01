package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EnormousCarpet {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = 1;
		while(true) {
			long n = sc.nextLong(), k = sc.nextLong(), A = sc.nextLong();
			if (n+k+A == 0) break;
			int c = sc.nextInt();
			long p[] = new long[c];
			for (int i = 0; i < c; i++)
				p[i] = sc.nextLong();

			out.printf("Case %d:\n", t++);
			for (int i = 0; i < c; i++) {
				if (i > 0)
					out.print(" ");
				out.print((A%p[i] * powerMod(k, n, p[i]))%p[i]);
			}
			out.println();
		}
		out.flush();
		out.close();
	}
	
	static long powerMod(long b, long e, long mod) {
		if (e == 0)
			return 1;
		if (e == 1)
			return b%mod;
		long x = powerMod(b, e/2, mod);
		if (e%2 == 0)
			return (x%mod * x%mod)%mod;
		return (b%mod * x%mod * x%mod)%mod;
	}
	
	static long MOD(long a, long m) {
		return (a%m + m)%m;
	}

	static double log2(long a) {
		return Math.log(a) / Math.log(2);
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