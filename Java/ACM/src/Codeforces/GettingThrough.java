package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GettingThrough {
	static ArrayList<Integer> adjlist[];
	static boolean visited[];
	static int w, n;
	static Sensor a[];
	static final double EPS = 1e-9;
	static double s[];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-->0) {
			w = sc.nextInt();
			n = sc.nextInt();
			a = new Sensor[n];
			for (int i = 0; i < n; i++) 
				a[i] = new Sensor(new Point(sc.nextDouble(), sc.nextDouble()), sc.nextInt());
			
			double low = 0.0;
			double high = w/2.0;
			
			for (int i = 0; i < 50; i++) {
				double mid = low + (high-low)/2.0;
				
				if (valid(2*mid)) 
					low = mid;
				else
					high = mid;
			}
			
			out.printf("%.6f\n", low);
		}
		
		out.flush();
		out.close();
	}
	
	static boolean valid(double ans) {
		DisjointSets ds = new DisjointSets(n+2);
		
		for (int i = 0; i < n; i++) {
			Sensor cur = a[i];
			if (cur.center.x - cur.radius + EPS < ans) 
				ds.union(0, i+2);
			
			if (w - cur.center.x - cur.radius + EPS < ans) 
				ds.union(1, i+2);
				
			
			for (int j = i+1; j < n; j++) {
				Sensor other = a[j];
				double d = cur.distance(other);
				
				if (d + EPS < ans) 
					ds.union(i+2, j+2);
			}
		}
		
		return !ds.inSameSet(0, 1);
		
	}
	
	static class Sensor {
		Point center;
		int radius;
		
		public Sensor(Point p, int r) {
			center = p;
			radius = r;
		}
		
		public double distance(Sensor s) {
			return center.distance(s.center) - radius - s.radius;
		}
	}
	
	static class Point {
		double x, y;
		
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public double distance(Point p) {
			return Math.sqrt(sq(x-p.x) + sq(y-p.y));
		}
		
		public double sq(double x) {
			return x * x;
		}
	}
	static class DisjointSets {
		int representative[];
		int rank[];

		public DisjointSets(int n) {
			representative = new int[n];
			rank = new int[n];
			for (int i = 0; i < representative.length; i++)
				representative[i] = i;
			Arrays.fill(rank, 1);
		}

		int findSet(int x) {
			if (x == representative[x])
				return x;
			return representative[x] = findSet(representative[x]);
		}

		boolean inSameSet(int x,int y){
			return (findSet(x) == findSet(y));
		}

		void union(int x, int y) {
			int x1 = findSet(x);
			int y1 = findSet(y);
			if (x1 != y1)
				if (rank[x1] > rank[y1]) {
					representative[y1] = x1;
				} else if (rank[x1] < rank[y1]) {
					representative[x1] = y1;
				} else {
					representative[x1] = y1;
					rank[y1]++;
				}
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
