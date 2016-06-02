package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BoundingBox {
	static final double EPS = 1e-9;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = 1;
		while(true) {
			int n = sc.nextInt();
			if (n == 0) break;

			Point p1 = new Point(sc.nextDouble(), sc.nextDouble());
			Point p2 = new Point(sc.nextDouble(), sc.nextDouble());
			Point p3 = new Point(sc.nextDouble(), sc.nextDouble());

			Point c = circumCircle(p1, p2, p3);

			double angle = 2 * Math.PI/n;
			double maxX = p1.x, maxY = p1.y;
			double minX = p1.x, minY = p1.y;

			for (int i = 0; i < n-1; i++) {
				p1 = p1.rotate(angle, c);

				maxX = Math.max(maxX, p1.x);
				maxY = Math.max(maxY, p1.y);
				minX = Math.min(minX, p1.x);
				minY = Math.min(minY, p1.y);
			}

			out.printf("Polygon %d: %.3f\n", t++, (maxX - minX) * (maxY - minY));
		}

		out.flush();
		out.close();
	}

	public static Point circumCircle(Point a, Point b, Point c) {
		Point abm = Point.midPoint(a, b);
		Point acm = Point.midPoint(a, c);
				
		Vector v1 = new Vector(abm, b);
		Vector v2 = new Vector(acm, c);
		
		v1.rotate90degrees();
		v2.rotate90degrees();
		Point c1 = v1.translate(abm);
		Point c2 = v2.translate(acm);
		
		Line l1 = new Line(abm, c1);
		Line l2 = new Line(acm, c2);
		
		return l1.intersects(l2);
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

		public Point translate(Point p) { // translate point p according to this vector
			return new Point(p.x + x, p.y + y);
		}

		public Vector reverse() {
			return new Vector(x*-1, y*-1);
		}
		
		public void rotate90degrees() {
			double temp = x;
			x = -y;
			y = temp;
		}
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

		public Point rotate(double theta) { // must be in rads.
			return new Point(x * Math.cos(theta) - y * Math.sin(theta), x * Math.sin(theta) + y * Math.cos(theta));
		}

		public Point rotate(double theta, Point p) { // must be in rads.
			Vector v = new Vector(p, new Point(0.0,0.0));
			Point c = v.translate(this).rotate(theta);
			v = v.reverse();
			return v.translate(c);
		}
		
		public static Point midPoint(Point p, Point q) {
			return new Point((p.x + q.x)/2.0, (p.y + q.y)/2.0);
		}

		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}

	}
	
	static class Line {
		double a, b, c;
		
		static final double EPS = 1e-9;
		
		public Line(Point p, Point q) {
			if (Math.abs(p.x - q.x) < EPS) {
				a = 1.0;
				b = 0.0;
				c = -p.x;
			}
			else {
				a = (p.y - q.y)/(q.x - p.x);
				b = 1.0;
				c = -(a * p.x) - p.y;
			}
		}
		
		public boolean isParallel(Line l) {
			return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS;
		}
		
		public boolean isSame(Line l) {
			return isParallel(l) && Math.abs(c - l.c) < EPS;
		}
		
		public Point intersects(Line l) {
			if (isParallel(l)) return null;

			double x = (l.b * c - l.c * b) / (b * l.a - a * l.b);
			double y;
			
			if (Math.abs(b) < EPS)
				y = (-l.c - l.a*x) / l.b;
			else 
				y = (-c - a*x) / b;

			return new Point(x, y);
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

		public String Next() throws IOException {
			if (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(Next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(Next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(Next());
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
