package Testing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class t {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(power(BigInteger.valueOf(2), BigInteger.valueOf(1000000)).toString().length());
	}
	
	public static BigInteger power(BigInteger base, BigInteger e) {
		if (e.compareTo(BigInteger.valueOf(0)) == 0)
			return BigInteger.ONE;
		if (e.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0) {
			BigInteger ans = power(base, e.divide(BigInteger.valueOf(2)));
			return ans.multiply(ans);
		}
		else {
			return power(base, e.subtract(BigInteger.ONE)).multiply(base);
		}
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
