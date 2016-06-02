package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheOtherTwoTrees {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		sc.waitForInput(3000);
		while(sc.Ready()) {
			double x1 = sc.nextDouble(), y1 = sc.nextDouble(), x2 = sc.nextDouble(), y2 = sc.nextDouble();
			Point p = new Point(x1, y1);
			Point q = new Point(x2, y2);
			
			Point m = Point.midPoint(p, q);
			Vector v1 = new Vector(m, q);
			v1.rotate90degrees();
			Vector v2 = new Vector(m, q);
			v2.rotateneg90degrees();
			
			Point newP = m.translate(v1);
			Point newQ = m.translate(v2);
			
			out.printf("%.10f %.10f %.10f %.10f\n", newP.x, newP.y, newQ.x, newQ.y);
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
		
		public Point translate(Vector v) {
			return new Point(v.x + x, v.y + y);
		}
		
		public static Point midPoint(Point p, Point q) {
			return new Point((p.x + q.x)/2.0, (p.y + q.y)/2.0);
		}
	}

	static class Vector {
		double x, y;
		
		public Vector(double a, double b) {
			x = a;
			y = b;
		}
		
		public Vector(Point a, Point b) {
			this(b.x - a.x, b.y - a.y);
		}
		
		public Vector scale(double s) {
			return new Vector(x*s, y*s);
		}
		
		public void rotate90degrees() {
			double temp = x;
			x = -y;
			y = temp;
		}
		
		public void rotateneg90degrees() {
			double temp = y;
			y = -x;
			x = temp;
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
