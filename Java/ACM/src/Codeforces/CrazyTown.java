package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CrazyTown {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		Point p = new Point(sc.nextDouble(), sc.nextDouble());
		Point q = new Point(sc.nextDouble(), sc.nextDouble());
		LineSegment l = new LineSegment(p, q);
		int n = sc.nextInt();
		
		long ans = 0;
		for (int i = 0; i < n; i++) {
			Line t = new Line(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
			if (l.intersects(t) != null)
				ans++;
		}
		
		System.out.println(ans);
	}
	
	static class LineSegment {
		Point p, q;

		static final double EPS = 1e-9;

		public LineSegment(Point a, Point b) {
			p = a;
			q = b;
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
			
			public Line(double a, double b, double c) {
				this.a = a;
				this.b = b;
				this.c = c;
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
