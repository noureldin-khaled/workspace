package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TheSultansProblem {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		sc.waitForInput(3000);
		int t = 1;
		while(sc.Ready()) {
			int n = sc.nextInt();
			double w = sc.nextDouble(), h = sc.nextDouble(), x = sc.nextDouble(), y = sc.nextDouble();
			
			Point r = new Point(x, y);
			Point[] arr = new Point[4];
			arr[0] = new Point(0, 0);
			arr[1] = new Point(w, 0);
			arr[2] = new Point(w, h);
			arr[3] = new Point(0, h);
			
			Polygon p = new Polygon(arr, false);
			for (int i = 0; i < n; i++) {
				Point a = new Point(sc.nextDouble(), sc.nextDouble()), b = new Point(sc.nextDouble(), sc.nextDouble());
				
				if (Point.ccw(a, b, r)) 
					p = p.cutPolygon(a, b);
				else 
					p = p.cutPolygon(b, a);
			}
			
			out.printf("Case #%d: %.3f\n", t++, p.area());
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
		
		public static boolean ccw(Point p, Point q, Point r) {
			return new Vector(p, q).cross(new Vector(p, r)) > EPS;
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
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
		
		public Point translate(Point p) { // translate point p according to this vector
			return new Point(p.x + x, p.y + y);
		}
		
		public double dot(Vector b) {
			return x*b.x + y*b.y;
		}
		
		public double cross(Vector b) {
			return x*b.y - y*b.x;
		}
		
		public double norm_sq() {
			return x*x + y*y;
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
	
	static class Polygon {
		Point[] g;
		
		static final double EPS = 1e-9;
		
		public Polygon(Point[] b, boolean isAdded) {
			int len = b.length;
			g = new Point[isAdded ? len : len+1];
			
			for (int i = 0; i < len; i++)
				g[i] = new Point(b[i].x, b[i].y);
			
			if (!isAdded)
				g[len] = new Point(g[0].x, g[0].y);
		}
		
		public double area() {
			double res = 0.0;
			
			for (int i = 0; i < g.length-1; i++) {
				double x1 = g[i].x, x2 = g[i+1].x;
				double y1 = g[i].y, y2 = g[i+1].y;
				
				res += (x1*y2 - x2*y1);
			}
			
			return Math.abs(res)/2.0;
		}
		
		public Polygon cutPolygon(Point a, Point b) { // returns the left side polygon
			int len = g.length;
			ArrayList<Point> al = new ArrayList<Point>();
			
			for (int i = 0; i < len; i++) {
				double left1 = new Vector(a, b).cross(new Vector(a, g[i]));
				double left2  = 0;
				
				if (i != len-1) left2 = new Vector(a, b).cross(new Vector(a, g[i+1]));
				if (left1 > -EPS) al.add(new Point(g[i].x, g[i].y));
				if (left1 * left2 < -EPS) {
					Line l1 = new Line(a, b);
					Line l2 = new Line(g[i], g[i+1]);
					
					al.add(l1.intersects(l2));
				}
				
			}
			int size = al.size();
			if (!al.isEmpty() && !(al.get(0) == al.get(size-1)))
				al.add(new Point(al.get(0).x, al.get(0).y));
			
			Point res[] = new Point[size];
			res = al.toArray(res);
			return new Polygon(res, true);
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
