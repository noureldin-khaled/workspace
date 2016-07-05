package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SolveIt {
	static final double EPS = 1e-9;
	static int p, q, r, s, t, u;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		sc.waitForInput(3000);
		while(sc.Ready()) {
			p = sc.nextInt();
			q = sc.nextInt();
			r = sc.nextInt();
			s = sc.nextInt();
			t = sc.nextInt();
			u = sc.nextInt();
			
			if (f(0) * f(1) > EPS)
				out.println("No solution");
			else 
				out.printf("%.4f\n", binarySearch());
		}

		out.flush();
		out.close();
	}

	public static double f(double x) {
		return p*Math.exp(-x) + q*Math.sin(x) + r*Math.cos(x) + s*Math.tan(x) + t*x*x + u; 
	}
	
	public static double binarySearch() {
		double low = 0.0, high = 1.0;
		while(low + EPS < high) {
			double mid = (high+low)/2.0;

			if (f(mid) > EPS) 
				low = mid;
			else
				high = mid;
		}
		
		return (low+high)/2.0;
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
