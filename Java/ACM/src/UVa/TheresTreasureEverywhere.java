package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheresTreasureEverywhere {
	
	static final double STEP = Math.sin((45*Math.PI)/180.0);	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = 1;
		while(true) {
			String line = sc.nextLine();
			if (line.equals("END")) break;

			String[] path = line.split(",");
			int len = path.length;
			char[] temp = path[len-1].toCharArray();
			path[len-1] = new String(Arrays.copyOf(temp, temp.length-1));

			Point cur = new Point(0, 0);
			for (int i = 0; i < len; i++) {
				String num = "";
				String dir = "";
				for (int j = 0; j < path[i].length(); j++) {
					if (path[i].charAt(j) >= '0' && path[i].charAt(j) <= '9')
						num += path[i].charAt(j);
					else
						dir += path[i].charAt(j);
				}

				int steps = Integer.parseInt(num);
				cur = getNewPoint(cur, steps, dir);
			}

			double dist = cur.dist(new Point(0, 0));

			out.printf("Map #%d\nThe treasure is located at (%.3f,%.3f).\nThe distance to the treasure is %.3f.\n\n", t++, cur.x, cur.y, dist);
		}

		out.flush();
		out.close();
	}

	private static Point getNewPoint(Point cur, int steps, String dir) {
		switch(dir) {
		case "N": return new Point(cur.x, cur.y + steps);
		case "S": return new Point(cur.x, cur.y - steps);
		case "E": return new Point(cur.x + steps, cur.y);
		case "W": return new Point(cur.x - steps, cur.y);
		case "NE": return new Point(cur.x + STEP*steps, cur.y + STEP*steps);
		case "NW": return new Point(cur.x - STEP*steps, cur.y + STEP*steps);
		case "SE": return new Point(cur.x + STEP*steps, cur.y - STEP*steps);
		case "SW": return new Point(cur.x - STEP*steps, cur.y - STEP*steps);
		}
		
		return null;
	}

	static class Point {
		double x, y;

		public Point(double a, double b) {
			x = a;
			y = b;
		}

		public double dist(Point p) {
			return Math.sqrt(sq(x - p.x) + sq(y - p.y));
		}

		public double sq(double x) {
			return x * x;
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

}
