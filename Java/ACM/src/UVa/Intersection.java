package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Intersection {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t= sc.nextInt();
		while(t-->0) {
			LineSegment l = new LineSegment(new Point(sc.nextDouble(), sc.nextDouble()), new Point(sc.nextDouble(), sc.nextDouble()));
			Rectangle r = new Rectangle(new Point(sc.nextDouble(), sc.nextDouble()), new Point(sc.nextDouble(), sc.nextDouble()));
			
			out.println(r.intersects(l) ? "T" : "F");
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
		
		public Point rotate(double theta) { // must be in rads. rotate around origin only.
			return new Point(x * Math.cos(theta) - y * Math.sin(theta), x * Math.sin(theta) + y * Math.cos(theta));
		}
		
		public boolean insideCircle(Point c, double r) { // true if on borders too.
			double dist = distance(c);
			return dist < r + EPS;
		}
		
		public boolean between(Point p, Point q) {
			return x + EPS > Math.min(p.x, q.x) && x < Math.max(p.x, q.x) + EPS && y + EPS > Math.min(p.y, q.y) && y < Math.max(p.y, q.y) + EPS;
		}
		
		public static Point midPoint(Point p, Point q) {
			return new Point((p.x + q.x)/2.0, (p.y + q.y)/2.0);
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
		
	}
	
	static class Rectangle {
		Point lt, rb;
		
		public Rectangle(Point a, Point b) {
			lt = a;
			rb = b;
		}
		
		public boolean intersects(LineSegment l) {
			LineSegment l1 = new LineSegment(lt, new Point(rb.x, lt.y));
			LineSegment l2 = new LineSegment(new Point(lt.x, rb.y), rb);
			LineSegment l3 = new LineSegment(lt, new Point(lt.x, rb.y));
			LineSegment l4 = new LineSegment(new Point(rb.x, lt.y), rb);
			
			return l.intersects(l1) != null || l.intersects(l2) != null || l.intersects(l3) != null || l.intersects(l4) != null || inside(l);
		}
		
		public boolean inside(LineSegment l) {
			return l.p.between(lt, rb) && l.q.between(lt, rb);
		}
	}
	
	static class LineSegment {
		Point p, q;

		static final double EPS = 1e-9;

		public LineSegment(Point a, Point b) {
			p = a;
			q = b;
		}

		public Point intersects(LineSegment l) {
			Line l1 = new Line(p, q);
			Line l2 = new Line(l.p, l.q);
			if (l1.isParallel(l2)) return null;

			Point c = l1.intersects(l2);

			return c.between(p, q) && c.between(l.p, l.q) ? c : null;
		}

		public Point intersects(Line l) {
			Line temp = new Line(p, q);
			if (temp.isParallel(l)) return null;

			Point c = temp.intersects(l);

			if ( ((c.x + EPS > p.x && c.x < q.x + EPS) || (c.x + EPS > q.x && c.x < p.x + EPS)) && ((c.y + EPS > p.y && c.y < q.y + EPS) || (c.y + EPS > q.y && c.y < p.y + EPS)))
				return c;
			else
				return null;
		}

		public Point lower() {
			return p.y < q.y ? p : q;
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
