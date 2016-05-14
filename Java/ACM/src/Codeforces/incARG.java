package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class incARG {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String line = rev(sc.nextLine());
		BigInteger b1 = new BigInteger(line, 2);

		BigInteger b2 = b1.add(BigInteger.valueOf(1));
		BigInteger b = b1.xor(b2);
		String s = b.toString(2);
		
		int index = 0;
		int len = s.length();
		if (len > n)
			index++;
		
		int ans = 0;
		for (; index < len; index++)
			if (s.charAt(index) == '1')
				ans++;
		
		System.out.println(ans);
	}

	public static String rev(String s) {
		String res = "";
		for (int i = s.length() - 1; i >= 0; i--) 
			res += s.charAt(i);
		return res;

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
