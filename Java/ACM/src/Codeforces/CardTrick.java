package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CardTrick {
	static double memo[];
	static int known[];
	static int tarpos;

	static double dp(int pos) {
		if (pos > tarpos)
			return 0;
		if (pos == tarpos) 
			return 1;

		if (memo[pos] != -1)
			return memo[pos];

		double ans = 0;
		if (known[pos] != -1)
			ans = dp(pos + getAdd(known[pos]));
		else {
			for (int i = 2; i < 15; i++) 
				ans += (1 / 13.0) * dp(pos + getAdd(i));
		}

		return memo[pos] = ans;
	}

	static int getAdd(int i) {
		int add = 0;
		if (i >= 2 && i <= 9)
			add = i;
		else if (i >= 10 && i <= 13)
			add = 10;
		else
			add = 11; 

		return add;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (sc.Ready()) {
			int n = sc.nextInt();
			int pos = sc.nextInt();
			known = new int[n * 11 + 10];
			Arrays.fill(known, -1);
			memo = new double[n * 11 + 11];
			Arrays.fill(memo, -1);
			for (int i = 0; i < n; i++) {
				String num = sc.next();
				if (i == n - 1)
					tarpos = pos;
				if (num.length() == 1) {
					char c = num.charAt(0);
					if (c <= '9' && c >= '2') {
						known[pos] = c - '0';
						pos += c - '0';
					}
					else if (c == 'A') {
						known[pos] = 14;
						pos += 11;
					} else {
						if (c == 'J')
							known[pos] = 11;
						else if (c == 'Q') 
							known[pos] = 12;
						else if (c == 'K')
							known[pos] = 13;

						pos += 10;
					}
				} else {
					known[pos] = 10;
					pos += 10;
				}	
			}

			double ans = 0;
			for (int i = 1; i <= 10; i++)
				ans += (1 / 10.0) * dp(i);
			out.printf("%.26f\n", ans);
		}

		out.flush();
		out.close();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		public String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws Exception {
			return Integer.parseInt(next());
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