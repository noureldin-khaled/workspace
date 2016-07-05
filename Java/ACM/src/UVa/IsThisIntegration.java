package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IsThisIntegration {
	static final double EPS = 1e-9;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		sc.waitForInput(3000);
		while(sc.Ready()) {
			double a = sc.nextDouble();
			double sqArea = a * a;
			double secArea = sectorArea(90.0, a);
			double reg = secArea - (sqArea - secArea);
			
			double triArea = sectorArea(30.0, a);
			double restArea = segmentArea(60.0, a);
			
			double dottedArea = reg - (triArea + 2 * restArea);
			double strippedArea = reg - 2*dottedArea;
			double restOfshapeArea = ((sqArea - secArea) - dottedArea) / 2.0;
			
			out.printf("%.3f %.3f %.3f\n", strippedArea, 4 * dottedArea, 4 * restOfshapeArea);
		}

		out.flush();
		out.close();
	}

	public static double sectorArea(double theta, double r) {
		return (theta / 360.0) * area(r);
	}

	public static double segmentArea(double theta, double r) {
		return sectorArea(theta, r) - triangleArea(r, theta);
	}
	
	public static double area(double r) {
		return Math.PI * r * r;
	}
	
	public static double triangleArea(double b, double theta) {
		return 0.5 * b * b * Math.sin(degToRad(theta));
	}

	static double degToRad(double d) { return d * Math.PI / 180.0; }

	static double radToDeg(double r) { return r * 180.0 / Math.PI; }


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
