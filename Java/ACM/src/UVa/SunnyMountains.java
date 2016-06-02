package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SunnyMountains {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();

			Point[] arr = new Point[n];
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt(), y = sc.nextInt();
				arr[i] = new Point((double)x, (double)y);
			}

			double ans = 0.0;
			Arrays.sort(arr);
			Point max = new Point(arr[0].x, arr[0].y);
			for (int i = 0; i < n-1; i++) {
				Point p = arr[i];
				Point q = arr[i+1];

				if (q.y > max.y) {
					if (p.y == max.y) 
						ans += p.distance(q);
					else if (p.y < max.y){
						Line l1 = new Line(p, q);
						Line l2 = new Line(max, new Point(9, max.y));
						Point c = l1.intersects(l2);
						
						ans += c.distance(q);
					}
					
					max = new Point(q.x, q.y);
				}
			}

			out.printf("%.2f\n", ans);
		}

		out.flush();
		out.close();
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

		public String Next() throws IOException {
			if (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(Next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(Next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(Next());
		}

		public boolean Ready() throws IOException {
			return br.ready();
		}

		public void waitForInput(long time) {
			long ct = System.currentTimeMillis();
			while(System.currentTimeMillis() - ct < time) {};
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
				y = (-c - a*x) / b;
			else 
				y = (-l.c - l.a*x) / l.b;

			return new Point(x, y);
		}
	}

	static class 
	Point implements Comparable<Point> {
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

		public Point rotate(double theta) { // must be in rads
			return new Point(x * Math.cos(theta) - y * Math.sin(theta), x * Math.sin(theta) + y * Math.cos(theta));
		}

		@Override
		public int compareTo(Point o) {
			if (Double.compare(o.x, x) != 0)
				return Double.compare(o.x, x);
			return Double.compare(y, o.y);
		}
	}
}
