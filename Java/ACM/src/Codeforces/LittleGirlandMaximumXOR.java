package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class LittleGirlandMaximumXOR {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		long l = sc.nextLong(), r = sc.nextLong();
		char c[] = Long.toBinaryString(r).toCharArray();
		int len = c.length;
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < len; i++) {
			s.append(c[i]);
			if (c[i] == '1') {
				StringBuilder sb = new StringBuilder(s.toString());
				sb.setCharAt(i, '0');
				for (int j = i+1; j < len; j++)
					sb.append('1');
				BigInteger b = new BigInteger(sb.toString(), 2);
				if (b.compareTo(BigInteger.valueOf(l)) >= 0 && b.compareTo(BigInteger.valueOf(r)) <= 0) {
					sb.setCharAt(i, '1');
					i--;
					for (; i >= 0; i--)
						sb.setCharAt(i, '0');
					
					b = new BigInteger(sb.toString(), 2);
					System.out.println(b);
					return;
				}
			}
		}
		System.out.println(0);
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
