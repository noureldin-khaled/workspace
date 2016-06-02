package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PointsinFigures_478 {
	static final double EPS = 1e-9;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		ArrayList<Polygon> arr = new ArrayList<Polygon>();

		while(true) {
			char type = sc.next().charAt(0);
			if (type == '*') break;

			if (type == 'r') {
				Point p = new Point(sc.nextDouble(), sc.nextDouble());
				Point q = new Point(sc.nextDouble(), sc.nextDouble());
				
				arr.add(new Rectangle(p, q));
			}
			else if (type == 'c') {
				Point c = new Point(sc.nextDouble(), sc.nextDouble());
				double r = sc.nextDouble();
				
				arr.add(new Circle(c, r));
			}
			else {
				Point a = new Point(sc.nextDouble(), sc.nextDouble());
				Point b = new Point(sc.nextDouble(), sc.nextDouble());
				Point c = new Point(sc.nextDouble(), sc.nextDouble());
				
				arr.add(new Triangle(a, b, c));
			}
		}

		int len = arr.size();

		int index = 1;
		while(true) {
			double x = sc.nextDouble(), y = sc.nextDouble();
			if (Math.abs(x - 9999.9) < EPS && Math.abs(y - 9999.9) < EPS) break;

			Point p = new Point(x, y);
			boolean found = false;

			for (int i = 0; i < len; i++) {
				Polygon cur = arr.get(i);
				if (cur.inside(p)) {
					found = true;
					out.printf("Point %d is contained in figure %d\n", index, i+1);
				}
			}

			if (!found)
				out.printf("Point %d is not contained in any figure\n", index);

			index++;
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

		public static double angle(Point a, Point o, Point b) {
			Vector oa = new Vector(o, a), ob = new Vector(o, b);

			return Math.acos((oa.dot(ob) / Math.sqrt(oa.norm_sq() * ob.norm_sq())));
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

		public double norm() {
			return Math.sqrt(x*x + y*y);
		}

		public double norm_sq() {
			return x*x + y*y;
		}

	}

	static abstract class Polygon {

		public abstract boolean inside(Point p);
	}

	static class Circle extends Polygon {
		Point c;
		double r;

		static final double EPS = 1e-9;

		public Circle(Point p, double f) {
			c = p;
			r = f;
		}

		@Override
		public boolean inside(Point p) {
			return p.distance(c) + EPS < r;
		}
	}

	static class Rectangle extends Polygon {
		Point p, q;

		static final double EPS = 1e-9;

		public Rectangle(Point a, Point b) {
			p = a;
			q = b;
		}

		@Override
		public boolean inside(Point c) {
			return c.x > p.x + EPS && c.x + EPS < q.x && c.y > q.y + EPS && c.y + EPS< p.y;
		}
	}

	static class Triangle extends Polygon {
		Point a, b, c;

		static final double EPS = 1e-9;

		public Triangle(Point p, Point q, Point r) {
			a = p;
			b = q;
			c = r;
		}

		@Override
		public boolean inside(Point p) {
			double sum = 0.0;
			
			double angle = Point.angle(a, p, b);
			if (angle == 0 || angle == Math.PI)
				return false;
			sum += angle;
			angle = Point.angle(b, p, c);
			if (angle == 0 || angle == Math.PI)
				return false;
			sum += angle;
			angle = Point.angle(c, p, a);
			if (angle == 0 || angle == Math.PI)
				return false;
			sum += angle;
			
			return Math.abs(Math.abs(sum) - 2* Math.PI) < EPS;
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
