package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SweetChildMakesTrouble {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		BigInteger a[] = new BigInteger[801];
		a[1] = BigInteger.ZERO;
		a[2] = BigInteger.ONE;
		BigInteger c = BigInteger.valueOf(2);
		for (int i = 3; i < 801; i++) {
			a[i] = a[i-1].add(a[i-2]);
			a[i] = a[i].multiply(c);
			c = c.add(BigInteger.ONE);
		}
		
		while(true) {
			int n = sc.nextInt();
			if (n == -1) break;
			out.println(a[n]);
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
