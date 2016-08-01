package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AgainPalindrome {
	static char[] c;
	static long dp[][];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		dp = new long[65][65];
		while(t-->0) {
			c = sc.nextLine().toCharArray();
			for (int i = 0; i < 65; i++)
				Arrays.fill(dp[i], -1);
			out.println(rec(0, c.length-1));
		}

		out.flush();
		out.close();
	}

	static long rec(int i, int j) {
		if (i == j)
			return 1;
		if (i > j)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];
		long same = 0;
		if (c[i] == c[j])
			same = 1 + rec(i+1, j-1);
		return dp[i][j] = same + rec(i+1, j)+ rec(i, j-1) - rec(i+1, j-1);
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
