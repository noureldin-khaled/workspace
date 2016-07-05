package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class YetAnotherNumberSequence {
	static BigInteger f[];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		f = new BigInteger[15001];
		f[0] = BigInteger.ZERO;
		f[1] = BigInteger.ONE;
		for (int i = 2; i <= 15000; i++)
			f[i] = f[i-1].add(f[i-2]);
		
		int t = sc.nextInt();
		while(t-->0) {
			int a = sc.nextInt(), b = sc.nextInt(), n = sc.nextInt(), m = sc.nextInt();
			out.println(fib(a, b, n, m));
		}
		
		out.flush();
		out.close();
	}
	
	public static BigInteger fib(int a, int b, int n, int m) {
		int p = getlen(m);
		BigInteger term = BigInteger.ONE;
		if (n > 0)
			term = f[(n-1)%p];
		return term.multiply(BigInteger.valueOf(a)).add(f[n%p].multiply(BigInteger.valueOf(b))).mod(BigInteger.valueOf(rev(m)));
	}
	
	public static int rev(int num) {
		switch(num) {
		case 1 : return 10;
		case 2 : return 100;
		case 3 : return 1000;
		case 4 : return 10000;
		}
		return 0;
	}
	
	public static int getlen(int m) {
		switch(m) {
		case 1 : return 60;
		case 2 : return 300;
		case 3 : return 1500;
		case 4 : return 15000;
		}
		return 0;
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
