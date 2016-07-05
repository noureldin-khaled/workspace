package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SCUDBusters {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		ArrayList<Polygon> arr = new ArrayList<>();
		while(true) {
			int n = sc.nextInt();
			if (n == -1) break;
			
			Point p[] = new Point[n];
			for (int i = 0; i < n; i++)
				p[i] = new Point(sc.nextDouble(), sc.nextDouble());
			
			arr.add(Polygon.convexHull(p));
		}
		
		double ans = 0.0;
		int s = arr.size();
		boolean done[] = new boolean[s];
		while(sc.Ready()) {
			double x = sc.nextDouble(), y = sc.nextDouble();
			Point p = new Point(x, y);
			for (int i = 0; i < s; i++) {
				Polygon cur = arr.get(i);
				if (!done[i] && cur.inPolygon(p)) {
					ans += cur.area();
					done[i] = true;
				}
			}
		}
		
		out.printf("%.2f\n", ans);
		
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
		
		public boolean between(Point p, Point q) {
			return x + EPS > Math.min(p.x, q.x) && x < Math.max(p.x, q.x) + EPS && y + EPS > Math.min(p.y, q.y) && y < Math.max(p.y, q.y) + EPS;
		}

		public static double angle(Point a, Point o, Point b) {
			Vector oa = new Vector(o, a), ob = new Vector(o, b);

			return Math.acos((oa.dot(ob) / Math.sqrt(oa.norm_sq() * ob.norm_sq())));
		}
		
		public static boolean ccw(Point p, Point q, Point r) {
			return new Vector(p, q).cross(new Vector(p, r)) > EPS;
		}
		
		public static boolean collinear(Point p, Point q, Point r) {
			return Math.abs(new Vector(p, q).cross(new Vector(p, r))) < EPS;
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
		
		public Point closestPoint(Point p, Point a, Point b) {
			Vector ap = new Vector(a, p), ab = new Vector(a, b);
			
			double u = ap.dot(ab) / ab.norm_sq();
			return ab.scale(u).translate(a);		
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
		
		public boolean inPolygon(Point p) { // works for both convex and concave polygons
			double sum = 0.0;
			
			for (int i = 0; i < g.length-1; i++) {
				double angle = Point.angle(g[i], p, g[i+1]);
				if ((Math.abs(angle) < EPS || Math.abs(angle - Math.PI) < EPS) && p.between(g[i], g[i+1]))
					return true; // point is on boundary line
				
				if (Point.ccw(p, g[i], g[i+1]))
					sum += angle;
				else
					sum -= angle;
			}
			
			return Math.abs(Math.abs(sum) - 2* Math.PI) < EPS;
		}
		
		public static Polygon convexHull(Point[] p) {
			int n = p.length;
			ArrayList<Point> al = new ArrayList<Point>(Arrays.asList(p));
			Point res[];
			
			if (n <= 3) {
				if (!(p[0] == p[n-1])) al.add(new Point(al.get(0).x, al.get(0).y));
				res = new Point[al.size()];
				res = al.toArray(res);
				return new Polygon(res, true);
			}
			
			int idx = 0;
			for (int i = 1; i < n; i++)
				if (p[i].y < p[idx].y || (p[i].y == p[idx].y && p[i].x > p[idx].x))
					idx = i;
			
			Point temp = new Point(p[0].x, p[0].y);
			p[0] = new Point(p[idx].x, p[idx].y);
			p[idx] = new Point(temp.x, temp.y);
			
			
			final Point pivot = p[0];
			Comparator<Point> angleCmp = new Comparator<Point>() {
				
				@Override
				public int compare(Point a, Point b) {
					if (Point.collinear(pivot, a, b))
						return pivot.distance(a) < pivot.distance(b) ? -1 : 1;
					
					double d1x = a.x - pivot.x, d1y = a.y - pivot.y;
					double d2x = b.x - pivot.x, d2y = b.y - pivot.y;
					
					return (Math.atan2(d1y, d1x) - Math.atan2(d2y, d2x)) < 0 ? -1 : 1;
				}
			};
			
			Arrays.sort(p, 1, n, angleCmp);
			
			ArrayList<Point> s = new ArrayList<Point>();
			s.add(new Point(p[n-1].x, p[n-1].y)); s.add(new Point(p[0].x, p[0].y)); s.add(new Point(p[1].x, p[1].y));
			int i = 2;
			while(i < n) {
				int sz = s.size();
				int j = sz-1;
				if (Point.ccw(s.get(j-1), s.get(j), p[i])) {s.add(new Point(p[i].x, p[i].y)); i++;}
				else s.remove(sz-1);
			}
			
			res = new Point[s.size()];
			res = s.toArray(res);
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
