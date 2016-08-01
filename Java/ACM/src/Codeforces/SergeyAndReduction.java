package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SergeyAndReduction {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt(), m = sc.nextInt();
		long a[] = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextLong();
		
		while(m-->0) {
			int t = sc.nextInt();
			int l = sc.nextInt()-1, r = sc.nextInt()-1;
			if (t == 0) {
				long e = sc.nextLong();
				for (; l <= r; l++)
					a[l] -= e;
			}
			else {
				long ans = 0;
				for (; l <= r; l++)
					if (a[l] <= 0)
						ans++;
				out.println(ans);
			}
		}

		out.flush();
		out.close();
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
