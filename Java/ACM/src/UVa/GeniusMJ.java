package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GeniusMJ {
	static int n;
	static Point tr1;
	static final int OFF = 1000;
	static boolean hasSocket[][];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-->0) { 
			n = sc.nextInt();
			Point arr1[] = new Point[n];
			Point arr2[] = new Point[n];
			
			for (int i = 0; i < n; i++)
				arr1[i] = new Point(sc.nextInt(), sc.nextInt());
			
			hasSocket = new boolean[2005][2005];
			Point tr2 = new Point(-1000, -1000);
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt(), y = sc.nextInt();
				arr2[i] = new Point(x, y);
				if (arr2[i].compareTo(tr2) > 0)
					tr2 = arr2[i];
				hasSocket[x+OFF][y+OFF] = true;
			}
			
			boolean eq = false;
			for (int i = 0; i < 4 && !eq; i++) { 
				tr1 = new Point(-1000, -1000);
				rotate(arr1);
				if (equal(arr1, new Vector(tr1, tr2))) 
					eq = true;
			}
			
			out.println(eq ? "MATCHED" : "NOT MATCHED");
		}
		
		out.flush();
		out.close();
	}
	
	public static boolean equal(Point[] a1, Vector v) {
		for (int i = 0; i < n; i++) {
			Point c = a1[i].translate(v);
			if (c.x+OFF > 2000 || c.x+OFF < 0 || c.y+OFF > 2000 || c.y+OFF < 0 || !hasSocket[c.x+OFF][c.y+OFF])
				return false;
		}
		
		return true;
	}
	
	public static void rotate(Point[] arr) {
		for (int i = 0; i < n; i++) {
			arr[i].rotate90();
			if (arr[i].compareTo(tr1) > 0)
				tr1 = arr[i];
		}
	}
		
	static class Point implements Comparable<Point> {
		int x, y;
		
		static final double EPS = 1e-9;
		
		public Point(int a, int b) {
			x = a;
			y = b;
		}
		
		public double distance(Point p) {
			return Math.sqrt(sq(x - p.x) + sq(y - p.y));
		}
		
		public double sq(double x) {
			return x * x;
		}
		
		public Point translate(Vector v) {
			return new Point(v.x + x, v.y + y);
		}
		
		public void rotate90() {
			int tmp = x;
			x = y;
			y = tmp;
			x = -x;
		}

		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}

		@Override
		public int compareTo(Point o) {
			if(x != o.x)
				return x > o.x ? 1 : -1;
			if(y != o.y)
				return y > o.y ? 1 : -1;
			return 0;
		}
	
	}
	
	static class Vector {
		int x, y;
		
		public Vector(int a, int b) {
			x = a;
			y = b;
		}
		
		public Vector(Point a, Point b) {
			this(b.x - a.x, b.y - a.y);
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
