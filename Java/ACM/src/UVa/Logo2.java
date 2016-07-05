package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Logo2 {
	static final double EPS = 1e-2;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			Point p = new Point(0.0, 0.0);
			Point a = null;
			String command = "";
			double acc = 0.0;
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				String tmp = sc.next();
				if (tmp.equals("?")) {
					command = s;
					a = new Point(p.x, p.y);
					continue;
				}

				int v = Integer.parseInt(tmp);
				if (s.equals("fd")) {
					Point newP = new Point(p.x, p.y+v);
					p = newP.rotate(degToRad(acc), p);
				}
				else if (s.equals("bk")) {
					Point newP = new Point(p.x, p.y-v);
					p = newP.rotate(degToRad(acc), p);
				}
				else if (s.equals("lt")) 
					acc += v;
				else 
					acc -= v;
			}

			if (command.equals("fd") || command.equals("bk")) 
				out.println(Math.round(p.distance(new Point(0.0, 0.0))));
			else {
				int angle = (int) Math.round(radToDeg(Point.angle(p, a, new Point(0.0, 0.0))));
				boolean ccw = Point.ccw(new Point(0.0, 0.0), p, a);
				if (!((ccw && command.equals("rt")) || (!ccw && command.equals("lt"))))
					angle = 360 - angle;
				angle %= 360;
				out.println(angle);
			}
		}

		out.flush();
		out.close();
	}

	public static double radToDeg(double r) { return r * 180.0 / Math.PI; }

	public static double degToRad(double d) { return d * Math.PI / 180.0; }

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

		public Point rotate(double theta, Point around) {
			Vector v = new Vector(around, new Point(0.0, 0.0));
			return translate(v).rotate(theta).translate(v.reverse());
		}

		public Point translate(Vector v) {
			return new Point(v.x + x, v.y + y);
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

		public static boolean ccw(Point p, Point q, Point r) {
			return new Vector(p, q).cross(new Vector(p, r)) > EPS;
		}

		public static double angle(Point a, Point o, Point b) {
			Vector oa = new Vector(o, a), ob = new Vector(o, b);

			return Math.acos((oa.dot(ob) / Math.sqrt(oa.norm_sq() * ob.norm_sq())));
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

		public Vector reverse() {
			return new Vector(x*-1, y*-1);
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

		public double distToLine(Point p, Point a, Point b) {
			Vector ap = new Vector(a, p), ab = new Vector(a, b);

			double u = ap.dot(ab) / ab.norm_sq();
			Point c = a.translate(ab.scale(u));

			return p.distance(c);
		}

		public Point closestPoint(Point p, Point a, Point b) {
			Vector ap = new Vector(a, p), ab = new Vector(a, b);

			double u = ap.dot(ab) / ab.norm_sq();
			return ab.scale(u).translate(a);		
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
