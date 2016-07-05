package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GuardTheLand {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		
		for (int c = 1; c <= t; c++) {
			Point[] minPoints = new Point[2];
			Point[] maxPoints = new Point[2];
			
			
			minPoints[0] = new Point(sc.nextDouble(), sc.nextDouble());
			maxPoints[0] = new Point(sc.nextDouble(), sc.nextDouble());
			minPoints[1] = new Point(sc.nextDouble(), sc.nextDouble());
			maxPoints[1] = new Point(sc.nextDouble(), sc.nextDouble());
		
			double maxX = Math.max(minPoints[0].x, minPoints[1].x);
			double maxY = Math.max(minPoints[0].y, minPoints[1].y);
			double minX = Math.min(maxPoints[0].x, maxPoints[1].x);
			double minY = Math.min(maxPoints[0].y, maxPoints[1].y);
			
			double strongSecure = maxX > minX && maxY > minY ? 0 : Math.max(0, (maxX - minX) * (maxY - minY));
			double weakSecure = (maxPoints[0].x - minPoints[0].x) * (maxPoints[0].y - minPoints[0].y) + (maxPoints[1].x - minPoints[1].x) * (maxPoints[1].y - minPoints[1].y) - 2*strongSecure;
			double noSecure = 100 * 100 - weakSecure - strongSecure;
			
			out.printf("Night %d: %d %d %d\n", c, (long)strongSecure, (long)weakSecure, (long)noSecure);
		}
		
		out.flush();
		out.close();
	}
	
	static class Point {
		double x, y;
		
		static final double EPS = 1e-9;
		
		public Point(double a, double b) {
			x = a;
			y = b;
		}
		
		public double distance(Point p) {
			return Math.sqrt(sq(x - p.x) + sq(y - p.y));
		}
		
		public double sq(double x) {
			return x * x;
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
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
