package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PickUpSticks {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while(true) {
			int n = sc.nextInt();
			if (n == 0) break;
			
			ArrayList<Pair> curTop = new ArrayList<Pair>();
			int s = 0;
			
			for (int i = 0; i < n; i++) {
				Point p = new Point(sc.nextDouble(), sc.nextDouble());
				Point q = new Point(sc.nextDouble(), sc.nextDouble());
				
				LineSegment l = new LineSegment(p, q);
				ArrayList<Pair> tmp = new ArrayList<Pair>();
				int ts = s;
				s = 0;

				for (int j = 0; j < ts; j++) {
					LineSegment cur = curTop.get(j).l;
					int index = curTop.get(j).i;
					if (l.intersects(cur) == null) {
						tmp.add(new Pair(cur, index));
						s++;
					}
				}
				
				tmp.add(new Pair(l, i));
				s++;
				
				curTop = tmp;
			}
			

			out.print("Top sticks: ");
			for (int i = 0; i < curTop.size(); i++) {
				if (i > 0)
					out.print(", ");
				out.print(curTop.get(i).i + 1);
			}
			
			out.println(".");
		}

		out.flush();
		out.close();
	}
	
	static class Pair {
		LineSegment l;
		int i;
		
		public Pair(LineSegment l, int i) {
			this.l = l;
			this.i = i;
		}
		
		@Override
		public String toString() {
			return l.toString() + ", " + i;
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

		public Point lower() {
			return p.y < q.y ? p : q;
		}
		
		@Override
		public String toString() {
			return "(" + p + " " + q + ")";
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
