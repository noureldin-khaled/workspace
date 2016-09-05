package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MagicBox {
	static final double EPS = 1e-9;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		Point s = new Point(sc.nextDouble(), sc.nextDouble(), sc.nextDouble()), o = new Point(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		
		Plain a[] = new Plain[6];
		int b[] = new int[6];
		for (int i = 0; i < 6; i++)
			b[i] = sc.nextInt();
		
		a[0] = new Plain(new Point(0, 0, 0), new Point(o.x, 0, 0), new Point(0, 0, o.z));
		a[1] = new Plain(new Point(0, o.y, 0), new Point(o.x, o.y, 0), new Point(0, o.y, o.z));
		a[2] = new Plain(new Point(0, 0, 0), new Point(o.x, 0, 0), new Point(0, o.y, 0));
		a[3] = new Plain(new Point(0, 0, o.z), new Point(o.x, 0, o.z), new Point(0, o.y, o.z));
		a[4] = new Plain(new Point(0, 0, 0), new Point(0, o.y, 0), new Point(0, o.y, o.z));
		a[5] = new Plain(new Point(o.x, 0, 0), new Point(o.x, o.y, 0), new Point(o.x, o.y, o.z));
		
		Point c[] = new Point[6];
		c[0] = new Point(o.x/2.0, 0, o.z/2.0);
		c[1] = new Point(o.x/2.0, o.y, o.z/2.0);
		c[2] = new Point(o.x/2.0, o.y/2.0, 0);
		c[3] = new Point(o.x/2.0, o.y/2.0, o.z);
		c[4] = new Point(0, o.y/2.0, o.z/2.0);
		c[5] = new Point(o.x, o.y/2.0, o.z/2.0);
		
		Rectangle r[] = new Rectangle[6];
		r[0] = new Rectangle(new Point(0, 0, 0), new Point(o.x, 0, 0), new Point(o.x, 0, o.z), new Point(0, 0, o.z));
		r[1] = new Rectangle(new Point(0, o.y, 0), new Point(o.x, o.y, 0), new Point(o.x, o.y, o.z), new Point(0, o.y, o.z));
		r[2] = new Rectangle(new Point(0, 0, 0), new Point(0, o.y, 0), new Point(o.x, o.y, 0), new Point(o.x, 0, 0));
		r[3] = new Rectangle(new Point(0, 0, o.z), new Point(0, o.y, o.z), new Point(o.x, o.y, o.z), new Point(o.x, 0, o.z));
		r[4] = new Rectangle(new Point(0, 0, 0), new Point(0, o.y, 0), new Point(0, o.y, o.z), new Point(0, 0, o.z));
		r[5] = new Rectangle(new Point(o.x, 0, 0), new Point(o.x, o.y, 0), new Point(o.x, o.y, o.z), new Point(o.x, 0, o.z));
		
		int ans = 0;
		for (int i = 0; i < 6; i++) {
			Line l = new Line(s, c[i]);
			double d = s.distance(c[i]);
			boolean take = true;
			for (int j = 0; j < 6 && take; j++) {
				if (i == j) continue;
				Point p = l.intersects(a[j]);
				if (r[j].in(p) && s.distance(p) + EPS < d)
					take = false;
			}
			
			if (take)
				ans += b[i];
		}
		
		System.out.println(ans);
	}
	
	static class Plain {
		Vector v;
		Point a;
		
		public Plain(Point p, Point q, Point r) {
			a = p;
			
			Vector pq = new Vector(p, q);
			Vector pr = new Vector(p, r);
			
			v = pq.cross(pr);
		}
	}
	
	static class Rectangle {
		Point a, b, c, d;
		
		public Rectangle(Point a, Point b, Point c, Point d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
		
		public boolean in(Point p) {
			return p.x + EPS > minX() && p.x < maxX() + EPS && p.y + EPS > minY() && p.y < maxY() + EPS && p.z + EPS > minZ() && p.z < maxZ() + EPS;
		}
		
		public double minY() {
			return Math.min(Math.min(a.y, b.y), Math.min(c.y, d.y));
		}
		
		public double maxY() {
			return Math.max(Math.max(a.y, b.y), Math.max(c.y, d.y));
		}
		
		public double minX() {
			return Math.min(Math.min(a.x, b.x), Math.min(c.x, d.x));
		}
		
		public double maxX() {
			return Math.max(Math.max(a.x, b.x), Math.max(c.x, d.x));
		}
		
		public double minZ() {
			return Math.min(Math.min(a.z, b.z), Math.min(c.z, d.z));
		}
		
		public double maxZ() {
			return Math.max(Math.max(a.z, b.z), Math.max(c.z, d.z));
		}
		
		@Override
		public String toString() {
			return "<" + a.toString() + " | " + b.toString() + " | " + c.toString() + " | " + d.toString() + ">";
		}
	}
	
	static class Line {
		Vector v1, v2;
		
		public Line(Point p, Point q) {
			v1 = new Vector(p.x, p.y, p.z);
			v2 = new Vector(q.x-p.x, q.y-p.y, q.z-p.z);
		}
		
		public Point intersects(Plain p) {
			double t = (p.v.x*p.a.x + p.v.y*p.a.y + p.v.z*p.a.z - p.v.x*v1.x - p.v.y*v1.y - p.v.z*v1.z) / (p.v.x*v2.x + p.v.y*v2.y + p.v.z*v2.z);
			return new Point(v1.x+v2.x*t, v1.y+v2.y*t, v1.z+v2.z*t);
		}
	}
	
	static class Vector {
		double x, y, z;
		
		public Vector(double a, double b, double c) {
			x = a;
			y = b;
			z = c;
		}
		
		public Vector(Point p1, Point p2) {
			x = p1.x - p2.x;
			y = p1.y - p2.y;
			z = p1.z - p2.z;
		}
		
		public Vector cross(Vector v) {
			return new Vector(y*v.z - z*v.y, -(x*v.z - z*v.x), x*v.y - y*v.x);
		}
	}
	
	static class Point {
		double x, y, z;
		
		public Point(double a, double b, double c) {
			x = a;
			y = b;
			z = c;
		}
		
		public double distance(Point p) {
			return sq(x-p.x) + sq(y-p.y) + sq(z-p.z);
		}
		
		public double sq(double n) {
			return n*n;
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ", " + z + ")";
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
