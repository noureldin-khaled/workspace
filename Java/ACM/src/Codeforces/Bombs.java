package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bombs {
	static StringBuilder sb;
	static int total;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		Point o = new Point(0, 0);
		Point a[] = new Point[n];
		total = 0;
		sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt(), y = sc.nextInt();
			a[i] = new Point(x, y);
		}
		
		Arrays.sort(a);
		for (int i = 0; i < n; i++) {
			Point cur = a[i];
			go(o, new Point(cur.x, cur.y));
			sb.append(2 + "\n");
			total++;
			go(new Point(cur.x, cur.y), o);
			sb.append(3 + "\n");
			total++;
		}
		
		out.println(total);
		out.println(sb);
		
		out.flush();
		out.close();
	}
	
	static void go(Point p, Point q) {
		if (p.x < q.x) {
			sb.append(1 + " " + (q.x-p.x) + " " + "R\n");
			total++;
		}
		else if (p.x > q.x) {
			sb.append(1 + " " + (p.x-q.x) + " " + "L\n");
			total++;
		}
		
		if (p.y < q.y) {
			sb.append(1 + " " + (q.y-p.y) + " " + "U\n");
			total++;
		}
		else if (p.y > q.y) {
			sb.append(1 + " " + (p.y-q.y) + " " + "D\n");
			total++;
		}
	}
	
	static long distance(Point p, Point q) {
		return sq(p.x-q.x) + sq(p.y-q.y);
	}
	
	static long sq(long n) {
		return n*n;
	}
	
	static class Point implements Comparable<Point> {
		int x, y;
		long dist;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
			dist = sq(x) + sq(y);
		}
		
		@Override
		public int compareTo(Point o) {
			if (dist != o.dist)
				return dist > o.dist ? 1 : -1;
			if (x != o.x)
				return x > o.x ? 1 : -1;
			return y > o.y ? 1 : -1;
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
