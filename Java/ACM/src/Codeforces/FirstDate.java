package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FirstDate {

	static int first(int y, int m, int d) {
		int sum = (y - 1582) * 365 + ((y - 1) / 4 - 1582 / 4);

		int a[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (y % 4 == 0)
			a[1]++;
		for (int i = 1; i <= m - 1; i++) {
			sum += a[i - 1];
		}

		sum += d;
		return (sum);
	}

	static int second(int y, int m, int d) {
		int sum = 0;

		for (int i = 1582; i <= y - 1; i++)
			if (i % 4 == 0 && !(i % 100 == 0 && i % 400 != 0))
				sum += 366;
			else
				sum += 365;
		int a[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (y % 4 == 0 && !(y % 100 == 0 && y % 400 != 0))
			a[1]++;
		for (int i = 1; i <= m - 1; i++) {
			sum += a[i - 1];
		}

		sum += d;
		return sum;
	}

	static StringBuilder outp(int diff, int y, int m, int d) {
		int a[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		d += diff;

		while (true) {
			int k = 365;
			if (y % 4 == 0 && !(y % 100 == 0 && y % 400 != 0))
				k++;
			if (d > k) {
				d -= k;
				y++;
			} else
				break;
		}

		if (y % 4 == 0 && !(y % 100 == 0 && y % 400 != 0))
			a[1]++;
		while (d > a[m]) {
			d -= a[m];
			m++;
			if (m > 11) {
				y++;
				if (y % 4 == 0 && !(y % 100 == 0 && y % 400 != 0))
					a[1] = 29;
				else
					a[1] = 28;
				m = 0;
			}
		}

		StringBuilder sb = new StringBuilder("");
		sb.append("" + y + "-");
		m++;
		if (m < 10)
			sb.append(0);
		sb.append(m + "-");
		if (d < 10)
			sb.append(0);
		sb.append(d);
		return sb;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (sc.Ready()) {
			String s = sc.next();

			int y = Integer.parseInt(s.substring(0, 4));
			int m = Integer.parseInt(s.substring(5, 7));
			int d = Integer.parseInt(s.substring(8, 10));

			out.println(outp(first(y, m, d) - second(y, m, d) + 11, y, m - 1, d));
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

		public Scanner(FileReader f) {
			br = new BufferedReader(f);
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