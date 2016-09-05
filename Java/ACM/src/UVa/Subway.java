package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Subway {
	static final double WALKING = 10.0 * (1000.0 / 60.0);
	static final double SUBWAY = 40.0 * (1000.0 / 60.0);
	static ArrayList<Node> adjlist[];
	static final double EPS = 1e-9;
	static final double INF = 1e16;
	static int V;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		while(t-->0) {
			int c = 0;
			Location home = new Location(c++, new Point(sc.nextInt(), sc.nextInt())), school = new Location(c++, new Point(sc.nextInt(), sc.nextInt()));

			ArrayList<ArrayList<Location>> a = new ArrayList<>();
			while(sc.Ready()) {
				String s = sc.nextLine();
				if (s.isEmpty()) break;

				StringTokenizer st = new StringTokenizer(s);
				ArrayList<Location> tmp = new ArrayList<>();
				while(true) {
					int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
					if (x == -1 && y == -1)
						break;

					tmp.add(new Location(c++, new Point(x, y)));
				}

				a.add(tmp);
			}

			adjlist = new ArrayList[c];
			for (int i = 0; i < c; i++)
				adjlist[i] = new ArrayList<>();

			int size = a.size();

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < a.get(i).size(); j++) {
					Location v = a.get(i).get(j);
					double w1 = Location.time(home, v, 0);
					adjlist[home.name].add(new Node(v.name, w1));
					adjlist[v.name].add(new Node(home.name, w1));

					double w2 = Location.time(v, school, 0);
					adjlist[v.name].add(new Node(school.name, w2));
					adjlist[school.name].add(new Node(v.name, w2));
				}
			}

			adjlist[home.name].add(new Node(school.name, Location.time(home, school, 0)));
			adjlist[school.name].add(new Node(home.name, Location.time(home, school, 0)));


			for (int i = 0; i < size; i++) {
				ArrayList<Location> cur = a.get(i);
				int len = cur.size();
				for (int j = 0; j < len; j++) {
					Location l = cur.get(j);
					if (j > 0) {
						Location prev = cur.get(j-1);
						adjlist[l.name].add(new Node(prev.name, Location.time(l, prev, 1)));
					}

					if (j < len-1) {
						Location nxt = cur.get(j+1);
						adjlist[l.name].add(new Node(nxt.name, Location.time(l, nxt, 1)));
					}

					for (int r = 0; r < size; r++) {
						if (r == i) {
							for (int k = 0; k < len; k++) {
								if (k == j-1 || k == j || k == j+1) continue;
								Location o = a.get(r).get(k);
								adjlist[l.name].add(new Node(o.name, Location.time(l, o, 0)));
							}
						}
						else {
							for (int k = 0; k < a.get(r).size(); k++) {
								Location o = a.get(r).get(k);
								adjlist[l.name].add(new Node(o.name, Location.time(l, o, 0)));
							}
						}
					}
				}
			}

			V = c;
			out.println(Math.round(dijksra(0, 1)));
			if (t > 0)
				out.println();
		}

		out.flush();
		out.close();
	}

	static double dijksra(int s, int t) {
		double[] dist = new double[V];
		Arrays.fill(dist, INF);
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		dist[s] = 0.0;
		pq.add(new Node(s, 0.0));
		while(!pq.isEmpty()) {
			Node cur = pq.remove();
			if(cur.name == t)
				break;
			if(cur.cost > dist[cur.name] + EPS)
				continue;
			for(Node nxt: adjlist[cur.name])
				if(cur.cost + nxt.cost + EPS < dist[nxt.name]) {
					dist[nxt.name] = cur.cost + nxt.cost;
					pq.add(new Node(nxt.name, dist[nxt.name]));
				}
		}

		return dist[t];
	}

	static class Node implements Comparable<Node> {
		int name;
		double cost;

		public Node(int n, double c) {
			name = n;
			cost = c;
		}

		@Override
		public int compareTo(Node o) {
			if(!(Math.abs(cost - o.cost) < EPS))
				return Double.compare(cost, o.cost);
			return name > o.name ? 1 : -1;
		}

		@Override
		public String toString() {
			return "(" + name + ", " + cost + ")";
		}
	}

	static class Location {
		int name;
		Point c;

		public Location(int n, Point c) {
			name = n;
			this.c = c;
		}

		static double time(Location n1, Location n2, int k) {
			if (k == 0) 
				return Point.dist(n1.c, n2.c) / WALKING;
			else 
				return Point.dist(n1.c, n2.c) / SUBWAY;
		}

		@Override
		public String toString() {
			return "(" + name + ", " + c.toString() + ")";
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		static double dist(Point p, Point q) {
			return Math.hypot(p.x-q.x, p.y-q.y);
		}

		static double sq(double n) {
			return n * n;
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
