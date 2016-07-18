package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class LorenzoVonMatterhorn {
	
	static long ans;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int q = sc.nextInt();
		edgelist = new TreeMap<>();
		while(q-->0) {
			int t = sc.nextInt();
			long u = sc.nextLong(), v = sc.nextLong();

			if (t == 1) {
				long w = sc.nextLong();
				update(u, v, w);
			}
			else {
				ans = 0;
				path(u, v);
				out.println(ans);
			}
		}

		out.flush();
		out.close();
	}

	static TreeSet<Long> visited;
	static TreeMap<Edge, Long> edgelist;
	static boolean stop;

	static void update(long u, long v, long w) {
		visited = new TreeSet<>();
		stop = false;
		update_value1(Math.max(u, v), Math.min(u, v), w);
		if (stop)
			return;
		long c = update_value2(Math.min(u, v), w);
		update_finish(c, w);
	}

	static void update_value1(long u, long dist, long weight) {
		visited.add(u);
		if (u == dist) {
			stop = true;
			return;
		}
		if (u == 1)
			return;

		long p = parent(u);
		Edge e = new Edge(Math.max(u, p), Math.min(u, p));

		if (edgelist.containsKey(e)) {
			long w = edgelist.get(e);
			edgelist.put(e, w + weight);
		}
		else
			edgelist.put(e, weight);

		update_value1(p, dist, weight);
	}

	static long update_value2(long u, long weight) {
		if (visited.contains(u)) 
			return u;
		
		long p = parent(u);
		Edge e = new Edge(Math.max(u, p), Math.min(u, p));

		if (edgelist.containsKey(e)) {
			long w = edgelist.get(e);
			edgelist.put(e, w + weight);
		}
		else
			edgelist.put(e, weight);

		return update_value2(p, weight);
	}

	static void update_finish(long u, long weight) {
		if (u == 1)
			return;

		long p = parent(u);
		Edge e = new Edge(Math.max(u, p), Math.min(u, p));

		long w = edgelist.get(e);
		edgelist.put(e, w - weight);

		update_finish(p, weight);
	}
	
	static void path(long u, long v) {
		visited = new TreeSet<>();
		stop = false;
		path_value1(Math.max(u, v), Math.min(u, v));
		if (stop)
			return;
		long c = path_value2(Math.min(u, v));
		path_finish(c);
	}

	static void path_value1(long u, long dist) {
		visited.add(u);
		if (u == 1)
			return;
		if (u == dist) {
			stop = true;
			return;
		}
		
		long w = 0;
		long p = parent(u);
		Edge e = new Edge(Math.max(u, p), Math.min(u, p));

		if (edgelist.containsKey(e)) 
			w = edgelist.get(e);
		
		ans += w;
		path_value1(p, dist);
	}
	
	static long path_value2(long u) {
		if (visited.contains(u))
			return u;
		
		long w = 0;
		long p = parent(u);
		Edge e = new Edge(Math.max(u, p), Math.min(u, p));

		if (edgelist.containsKey(e)) 
			w = edgelist.get(e);
		
		ans += w;
		return path_value2(p);
	}
	
	static void path_finish(long u) {
		if (u == 1)
			return;
		
		long p = parent(u);
		Edge e = new Edge(Math.max(u, p), Math.min(u, p));

		long w = 0;
		if (edgelist.containsKey(e))
			w = edgelist.get(e);
		
		ans -= w;
		path_finish(p);
	}

	static long parent(long node) {
		return node >> 1;
	}

	static class Edge implements Comparable<Edge>{
		long u, v;

		public Edge(long u, long v) {
			this.u = u;
			this.v = v;
		}

		@Override
		public int compareTo(Edge o) {
			if (u > o.u)
				return 1;
			if (u < o.u)
				return -1;
			if (v > o.v)
				return 1;
			if (v < o.v)
				return -1;
			return 0;
		}
		
		@Override
		public String toString() {
			return "(" + u + ", " + v + ")";
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
