package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class LightAndTransparencies {
	static final double EPS = 1e-9;
	static final double INF = 1e9;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();

			TreeMap<Point, Double> start = new TreeMap<Point, Double>();
			TreeMap<Point, Double> end = new TreeMap<Point, Double>();
			
			ArrayList<Point> points = new ArrayList<Point>();
			for (int i = 0; i < n; i++) {
				Point p = new Point(sc.nextDouble(), sc.nextDouble());
				Point q = new Point(sc.nextDouble(), sc.nextDouble());
				double v = sc.nextDouble();
				
				start.put(p.x < q.x ? p : q, v);
				end.put(p.x > q.x ? p : q, v);
				points.add(p);
				points.add(q);
			}
			
			Collections.sort(points);
			ArrayList<Region> res = new ArrayList<>();
			res.add(new Region(-INF, points.get(0).x, 1.0));
			int prev = 0;
			int size = points.size();
			for (int i = 0; i < size-1; i++) {
				Point cur = points.get(i);
				Point nxt = points.get(i+1);
				
				if (start.containsKey(cur)) {
					double val = start.get(cur);
					double curValue = res.get(prev).val;
										
					res.add(new Region(cur.x, nxt.x, curValue * val));
					prev++; 
				}
				else {
					double val = end.get(cur);
					double curValue = res.get(prev).val;
					
					res.add(new Region(cur.x, nxt.x, curValue / val));
					prev++; 
				}
			}
			
			res.add(new Region(points.get(size - 1).x, INF, 1.0));
			
			int rSize = res.size();
			out.println(rSize);
			for (int i = 0; i < rSize; i++) {
				if (i == 0) {
					out.print("-inf ");
					out.printf("%.3f %.3f\n", res.get(i).e, res.get(i).val);
				}
				else if (i == rSize - 1) {
					out.printf("%.3f", res.get(i).s);
					out.print(" +inf ");
					out.printf("%.3f\n", res.get(i).val);
				}
				else {
					out.printf("%.3f %.3f %.3f\n", res.get(i).s, res.get(i).e, res.get(i).val);
				}
			}
			
			if (t > 0)
				out.println();
		}

		out.flush();
		out.close();
	}

	static class Region {
		double s, e, val;

		public Region(double st, double en, double v) {
			s = st;
			e = en;
			val = v;
		}
		
		@Override
		public String toString() {
			return "(" + s + ", " + e + ", " + val + ")";
		}
	}

	static class LineSegment {
		Point p, q;
		double trans;

		static final double EPS = 1e-9;

		public LineSegment(Point a, Point b, double t) {
			p = a;
			q = b;
			trans = t;
		}
	}

	static class Point implements Comparable<Point> {
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

		@Override
		public int compareTo(Point o) {
			if (Double.compare(x, o.x) != 0)
				return Double.compare(x, o.x);
			return Double.compare(y, o.y);
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
