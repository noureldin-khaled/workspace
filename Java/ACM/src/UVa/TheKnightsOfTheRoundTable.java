package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheKnightsOfTheRoundTable {
	static final double EPS = 1e-9;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		sc.waitForInput(3000);
		while(sc.Ready()) 
			out.printf("The radius of the round table is: %.3f\n", radius(sc.nextDouble(), sc.nextDouble(), sc.nextDouble()));
		
		out.flush();
		out.close();
	}
	
	public static double area(double a, double b, double c) {
		double s = perimeter(a, b, c)/2;
		return Math.sqrt(Math.max(0.0, s * (s-a) * (s-b) * (s-c)));
	}
	
	public static double perimeter(double a, double b, double c) {
		return a + b + c;
	}
	
	public static double radius(double a, double b, double c) {
		if (Math.abs(perimeter(a, b, c)) < EPS) return 0.0;
		return area(a, b, c) / (0.5 * perimeter(a, b, c));
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
