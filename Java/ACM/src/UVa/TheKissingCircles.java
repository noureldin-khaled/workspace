package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheKissingCircles {
	static final double EPS = 1e-9;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		sc.waitForInput(2000);
		while(sc.Ready()) {
			double R = sc.nextDouble(), n = sc.nextDouble();
			if (Math.abs(n-1) < EPS) {
				out.printf("%.10f %.10f %.10f\n", R, 0.0, 0.0);
				continue;
			}
			double t = degToRad(360.0/n);
			double c = Math.sqrt(2 - 2*Math.cos(t));
			double r = (R*c)/(2+c);
			double pArea = n*triangleArea(2*r, R-r, R-r);
			double theta = regularPolygonAngle(n);
			double sArea = sectorArea(theta, r);
			double b = pArea - n*sArea;
			double g = circleArea(R) - n*circleArea(r) - b;
			out.printf("%.10f %.10f %.10f\n", r, b, g);
		}
		
		out.flush();
		out.close();
	}
	
	public static double sectorArea(double theta, double r) { return (theta / 360.0) * circleArea(r); }
	
	public static double circleArea(double r) { return Math.PI * r * r; }
	
	public static double regularPolygonAngle(double n) { return 180 * (n-2) / n; }
	
	public static double triangleArea(double a, double b, double c) { double s = 0.5 * trianglePerimeter(a, b, c); return Math.sqrt(s * (s - a) * (s - b) * (s - c)); }
	
	public static double trianglePerimeter(double a, double b, double c) { return a + b + c; }
	
	public static double degToRad(double d) { return d * Math.PI / 180.0; }
	
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
