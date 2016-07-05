package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GleamingTheCubes {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true) {
			int n = sc.nextInt();
			if (n == 0) break;
			
			Point[] maxPoints = new Point[n];
			Point[] minPoints = new Point[n];
			
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt(), d = sc.nextInt();
				
				minPoints[i] = new Point(x, y, z);
				maxPoints[i] = new Point(x+d, y+d, z+d);
			}
			
			int maxX = minPoints[0].x;
			int maxY = minPoints[0].y;
			int maxZ = minPoints[0].z;
			
			for (int i = 1; i < n; i++) {
				maxX = Math.max(maxX, minPoints[i].x);
				maxY = Math.max(maxY, minPoints[i].y);
				maxZ = Math.max(maxZ, minPoints[i].z);
			}
			
			int minX = maxPoints[0].x;
			int minY = maxPoints[0].y;
			int minZ = maxPoints[0].z;
			
			for (int i = 1; i < n; i++) {
				minX = Math.min(minX, maxPoints[i].x);
				minY = Math.min(minY, maxPoints[i].y);
				minZ = Math.min(minZ, maxPoints[i].z);
			}
			
			out.println(Math.max(0, (minX - maxX) * (minY - maxY) * (minZ - maxZ)));
		}
		
		out.flush();
		out.close();
	}
	
	static class Point {
		int x, y, z;
		public Point(int a, int b, int c) {
			x = a;
			y = b;
			z = c;
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
