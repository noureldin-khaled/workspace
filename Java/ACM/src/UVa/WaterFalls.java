package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WaterFalls {
	static final double EPS = 1e-9;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();

			LineSegment lines[] = new LineSegment[n];
			for (int i = 0; i < n; i++) {
				int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
				Point p = new Point((double) x1, (double) y1);
				Point q = new Point((double) x2, (double) y2);

				lines[i] = new LineSegment(p, q);
			}

			Pair arr[] = new Pair[n];
			for (int i = 0; i < n; i++) {
				Point low = lines[i].lower();
				
				Pair max = new Pair(-1, null);
				for (int j = 0; j < n; j++) {
					if (i == j) continue;
					
					Line vert = new Line(low, new Point(low.x, 0));
					Point c = lines[j].intersects(vert);
					if (c == null || c.y > low.y) continue;
					
					if (max.line == null || lines[j].lower().y > max.line.lower().y) 
						max = new Pair(j, new LineSegment(lines[j].p, lines[j].q));
				}
				
				if (max.line != null)
					arr[i] = new Pair(max.index, max.line);
			}
			
			int points = sc.nextInt();
			while(points-->0) {
				int x = sc.nextInt(), y = sc.nextInt();
				Point p = new Point((double)x, (double)y);
				
				Pair max = new Pair(-1, null);
				for (int j = 0; j < n; j++) {					
					Line vert = new Line(p, new Point(p.x, 0));
					Point c = lines[j].intersects(vert);
					if (c == null || c.y > p.y + EPS) continue;
					
					if (max.line == null || lines[j].lower().y > max.line.lower().y) 
						max = new Pair(j, new LineSegment(lines[j].p, lines[j].q));
					
				}
				
				if (max.line == null)
					out.println((int)p.x);
				else {
					while(true) {
						Pair newMax = arr[max.index];
						if (newMax == null) {
							out.println((int)max.line.lower().x);
							break;
						}
						max = newMax;
					}
				}
			}
			
			if (t > 0)
				out.println();
		}

		out.flush();
		out.close();
	}
	
	static class Pair {
		int index;
		LineSegment line;
		
		public Pair(int i, LineSegment l) {
			index = i;
			line = l;
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

		public boolean insideCircle(Point c, double r) { // true if on borders too.
			double dist = distance(c);
			return dist < r + EPS;
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
		
		@Override
		public String toString() {
			return p.x + ", " + p.y + "\n" + q.x + ", " + q.y; 
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
