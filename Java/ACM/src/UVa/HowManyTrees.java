package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class HowManyTrees {
	static BigInteger comb[][];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		sc.waitForInput(3000);
		nCr(2005);
		while(sc.Ready()) 
			out.println(Cat(sc.nextInt()));
		
		
		out.flush();
		out.close();
	}
	
	public static BigInteger Cat(int n) {
		return comb[n << 1][n].divide(BigInteger.valueOf(n+1));
	}
	
	public static void nCr(int n) {
		comb = new BigInteger[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				comb[i][j] = BigInteger.ZERO;
		
		comb[0][0] = BigInteger.ONE;

		for (int i = 1; i < n; i++) {
			comb[i][0] = BigInteger.ONE;
			for (int j = 1; j <= i; j++)
				comb[i][j] = comb[i-1][j-1].add(comb[i-1][j]);
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
