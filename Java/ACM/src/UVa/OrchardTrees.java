package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class OrchardTrees {
	static final double EPS = 1e-9;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while(true) {
			double x1 = sc.nextDouble(), y1 = sc.nextDouble(), x2 = sc.nextDouble(), y2 = sc.nextDouble(), x3 = sc.nextDouble(), y3 = sc.nextDouble();
			if (Math.abs(x1) < EPS && Math.abs(y1) < EPS && Math.abs(x2) < EPS && Math.abs(y2) < EPS && Math.abs(x3) < EPS && Math.abs(y3) < EPS)
				break;
			Point p = new Point(x1, y1);
			Point q = new Point(x2, y2);
			Point r = new Point(x3, y3);
			
			boolean c = Point.collinear(p, q, r);
			Triangle t = new Triangle(p, q, r);
			int ans = 0;
			for (int i = 1; i <= 99; i++)
				for (int j = 1; j <= 99; j++) {
					Point d = new Point((double)i, (double)j);
					if (c) {
						if (Point.collinear(d, p, q) && (d.between(p, q) || d.between(q, r) || d.between(p, r)))
							ans++;
					}
					else {
						if (t.inside(d)) 
							ans++;
					}
				}
			
			String s = ans+"";
			for (int i = 0; i < 4-s.length(); i++)
				out.print(" ");
			out.println(s);
		}

		out.flush();
		out.close();
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

		public double norm() {
			return Math.sqrt(x*x + y*y);
		}

		public double norm_sq() {
			return x*x + y*y;
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
		
		public boolean between(Point p, Point q) {
			return x + EPS > Math.min(p.x, q.x) && x < Math.max(p.x, q.x) + EPS && y + EPS > Math.min(p.y, q.y) && y < Math.max(p.y, q.y) + EPS;
		}
		

		public static double angle(Point a, Point o, Point b) {
			Vector oa = new Vector(o, a), ob = new Vector(o, b);
			
			if (Math.abs(oa.norm_sq()) < EPS || Math.abs(ob.norm_sq()) < EPS) 
				return 0.0;
			return Math.acos((oa.dot(ob) / Math.sqrt(oa.norm_sq() * ob.norm_sq())));
		}

		public static Boolean ccw(Point p, Point q, Point r) {
			double n = new Vector(p, q).cross(new Vector(p, r));
			return Math.abs(n) < EPS ? null : n > EPS;
		}
		
		public static boolean collinear(Point p, Point q, Point r) {
			 return Math.abs(new Vector(p, q).cross(new Vector(p, r))) < EPS;
		}

		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
		
		@Override
		public boolean equals(Object obj) {
			Point o = (Point) obj;
			return Math.abs(x-o.x) < EPS && Math.abs(y-o.y) < EPS;
		}

	}

	static class Triangle{
		Point a, b, c;

		static final double EPS = 1e-9;

		public Triangle(Point p, Point q, Point r) {
			a = p;
			b = q;
			c = r;
		}

		public boolean inside(Point p) {
			if (p.equals(a) || p.equals(b) || p.equals(c))
				return true;
			Boolean c1 = Point.ccw(p, a, b);
			Boolean c2 = Point.ccw(p, b, c);
			Boolean c3 = Point.ccw(p, c, a);
			
			ArrayList<Boolean> tmp = new ArrayList<Boolean>();
			if (c1 != null)
				tmp.add(c1);
			if (c2 != null)
				tmp.add(c2);
			if (c3 != null)
				tmp.add(c3);
			
			boolean t = tmp.get(0);
			for (int i = 0; i < tmp.size(); i++)
				if (tmp.get(i) != t)
					return false;
			
			return true;
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
