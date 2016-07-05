package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Bee {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		Pair[] arr = new Pair[40000];
		arr[0] = new Pair(BigInteger.ZERO, BigInteger.ONE);
		arr[1] = new Pair(BigInteger.ONE, BigInteger.ONE);
		
		for (int i = 2; i < 40000; i++) {
			Pair p1 = arr[i-1];
			Pair p2 = arr[i-2];
			
			arr[i] = new Pair(p1.male.add(p1.female), p1.female.add(p2.female));
		}
		
		while(true) {
			int n = sc.nextInt();
			if (n == -1) break;
			
			out.println(arr[n].male + " " + arr[n].male.add(arr[n].female));
		}
		
		out.flush();
		out.close();
	}
	
	static class Pair {
		BigInteger male, female;
		public Pair(BigInteger m, BigInteger f) {
			male = m;
			female = f;
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
