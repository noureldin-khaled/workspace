package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TrayBien {
	static boolean valid[][];
	static int n;
	static long dp[][];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();

		valid = new boolean[3][n+5];
		dp = new long[30][10];
		for (int i = 0; i < 30; i++)
			Arrays.fill(dp[i], -1);
		
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < n; j++)
				valid[i][j] = true;
		for (int i = 0; i < m; i++) {
			double x = sc.nextDouble(), y = sc.nextDouble();
			valid[(int)y][(int)x] = false;
		}
		
		System.out.println(rec(0, getmsk(0, 0)));
	}

	static long rec(int i, int msk) {
		if (i >= n)
			return 1;
		if (dp[i][msk] != -1)
			return dp[i][msk];
		
		long ans = 0;
		if (msk == 0) {
			ans += rec(i+1, getmsk(0, i+1))*3;
			if (valid[2][i+1])
				ans += rec(i+1, getmsk(4, i+1))*2;
			if (valid[0][i+1])
				ans += rec(i+1, getmsk(1, i+1))*2;
			if (valid[0][i+1] && valid[1][i+1] && valid[2][i+1])
				ans += rec(i+1, getmsk(7, i+1));
			if (valid[1][i+1])
				ans += rec(i+1, getmsk(2, i+1));
			if (valid[1][i+1] && valid[2][i+1])
				ans += rec(i+1, getmsk(6, i+1));
			if (valid[0][i+1] && valid[2][i+1])
				ans += rec(i+1, getmsk(5, i+1));
			if (valid[0][i+1] && valid[1][i+1])
				ans += rec(i+1, getmsk(3, i+1));
		}
		else if (msk == 1) {
			ans += rec(i+1, getmsk(0, i+1))*2;
			if (valid[2][i+1])
				ans += rec(i+1, getmsk(4, i+1));
//			if (valid[0][i+1])
//			ans += rec(i+1, getmsk(1, i+1))*2;
			if (valid[1][i+1] && valid[2][i+1])
				ans += rec(i+1, getmsk(6, i+1));
			if (valid[1][i+1])
				ans += rec(i+1, getmsk(2, i+1));
//			if (valid[1][i+1] && valid[2][i+1])
//				ans += rec(i+1, 6);
//			if (valid[2][i+1])
//				ans += rec(i+1, 4);
//			if (valid[1][i+1])
//				ans += rec(i+1, 2);
		}
		else if (msk == 2) {
			ans += rec(i+1, getmsk(0, i+1));
			if (valid[2][i+1])
				ans += rec(i+1, getmsk(4, i+1));
			if (valid[0][i+1])
				ans += rec(i+1, getmsk(1, i+1));
			if (valid[0][i+1] && valid[2][i+1])
				ans += rec(i+1, getmsk(5, i+1));
//			if (valid[1][i+1])
//				ans += rec(i+1, 2);
//			if (valid[2][i+1])
//				ans += rec(i+1, 4);
//			if (valid[0][i+1] && valid[2][i+1])
//				ans += rec(i+1, 5);
//			if (valid[0][i+1])
//				ans += rec(i+1, 1);
		}
		else if (msk == 3) {
			ans += rec(i+1, getmsk(0, i+1));
			if (valid[2][i+1])
				ans += rec(i+1, getmsk(4, i+1));
//			if (valid[0][i+1])
//				ans += rec(i+1, 1)*2;
//			if (valid[0][i+1] && valid[1][i+1] && valid[2][i+1])
//				ans += rec(i+1, 7);
//			if (valid[1][i+1])
//				ans += rec(i+1, 2);
//			if (valid[1][i+1] && valid[2][i+1])
//				ans += rec(i+1, 6);
//			if (valid[0][i+1] && valid[2][i+1])
//				ans += rec(i+1, 5);
//			if (valid[0][i+1] && valid[1][i+1])
//				ans += rec(i+1, 3);
		}
		else if (msk == 4) {
			ans += rec(i+1, getmsk(0, i+1))*2;
//			if (valid[2][i+1])
//				ans += rec(i+1, 4)*2;
			if (valid[0][i+1])
				ans += rec(i+1, getmsk(1, i+1));
			if (valid[0][i+1] && valid[1][i+1])
				ans += rec(i+1, getmsk(3, i+1));
			if (valid[1][i+1])
				ans += rec(i+1, getmsk(2, i+1));
//			if (valid[1][i+1])
//				ans += rec(i+1, 6);
//			if (valid[0][i+1])
//				ans += rec(i+1, 5);
//			if (valid[0][i+1] && valid[1][i+1])
//				ans += rec(i+1, 3);
		}
		else if (msk == 5) {
			ans += rec(i+1, getmsk(0, i+1));
//			if (valid[2][i+1])
//				ans += rec(i+1, 4)*2;
//			if (valid[0][i+1])
//				ans += rec(i+1, 1)*2;
//			if (valid[0][i+1] && valid[1][i+1] && valid[2][i+1])
//				ans += rec(i+1, 7);
			if (valid[1][i+1])
				ans += rec(i+1, getmsk(2, i+1));
//			if (valid[1][i+1] && valid[2][i+1])
//				ans += rec(i+1, 6);
//			if (valid[0][i+1] && valid[2][i+1])
//				ans += rec(i+1, 5);
//			if (valid[0][i+1] && valid[1][i+1])
//				ans += rec(i+1, 3);
		}
		else if (msk == 6) {
			ans += rec(i+1, getmsk(0, i+1));
//			if (valid[2][i+1])
//				ans += rec(i+1, 4)*2;
			if (valid[0][i+1])
				ans += rec(i+1, getmsk(1, i+1));
//			if (valid[0][i+1] && valid[1][i+1] && valid[2][i+1])
//				ans += rec(i+1, 7);
//			if (valid[1][i+1])
//				ans += rec(i+1, 2);
//			if (valid[1][i+1] && valid[2][i+1])
//				ans += rec(i+1, 6);
//			if (valid[0][i+1] && valid[2][i+1])
//				ans += rec(i+1, 5);
//			if (valid[0][i+1] && valid[1][i+1])
//				ans += rec(i+1, 3);
		}
		else if (msk == 7) {
			ans += rec(i+1, getmsk(0, i+1));
		}
		
		return dp[i][msk] = ans;
	}
	
	static int getmsk(int cur, int idx) {
		if (!valid[0][idx])
			cur |= (1 << 0);
		if (!valid[1][idx])
			cur |= (1 << 1);
		if (!valid[2][idx])
			cur |= (1 << 2);
		return cur;
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