package Codeforces;

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

public class DestinationUnknown {
	static ArrayList<Node> adjlist[];
	static final int INF = (int)1e9;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();

			adjlist = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjlist[i] = new ArrayList<>();

			int st = sc.nextInt()-1;
			Edge e = new Edge(sc.nextInt()-1, sc.nextInt()-1);

			for (int i = 0; i < m; i++) {
				int u = sc.nextInt()-1, v = sc.nextInt()-1, w = sc.nextInt();
				adjlist[u].add(new Node(v, w, false));
				adjlist[v].add(new Node(u, w, false));
			}

			int dist[] = new int[n];
			boolean valid[] = new boolean[n];
			Arrays.fill(dist, INF);

			PriorityQueue<Node> pq = new PriorityQueue<>();
			dist[st] = 0;
			pq.add(new Node(st, 0, false));
			while(!pq.isEmpty()) {
				Node cur = pq.remove();
				if (cur.cost > dist[cur.name])
					continue;
				if (cur.found)
					valid[cur.name] = true;
				for (Node nxt : adjlist[cur.name])
					if (cur.cost + nxt.cost <= dist[nxt.name]) {
						boolean flag = cur.found;
						if (e.equals(new Edge(cur.name, nxt.name)) ) 
							flag = true;
			
						dist[nxt.name] = cur.cost + nxt.cost;
						pq.add(new Node(nxt.name, dist[nxt.name], flag));
					}
			}

			ArrayList<Integer> res = new ArrayList<>();
			while(q-->0) {
				int d = sc.nextInt()-1;
				if (valid[d])
					res.add(d+1);
			}

			Collections.sort(res);
			for (int i = 0; i < res.size(); i++) {
				if (i > 0)
					out.print(" ");
				out.print(res.get(i));
			}

			out.println();
		}

		out.flush();
		out.close();
	}

	static class Edge {
		int f, t;

		public Edge(int a, int b) {
			f = a;
			t = b;
		}

		public int min() {
			return Math.min(f, t);
		}

		public int max() {
			return Math.max(f, t);
		}

		@Override
		public boolean equals(Object obj) {
			Edge o = (Edge) obj;
			return min() == o.min() && max() == o.max();
		}
	}

	static class Node implements Comparable<Node> {
		int name;
		int cost;
		boolean found;

		public Node(int n, int c, boolean f) {
			name = n;
			cost = c;
			found = f;
		}

		@Override
		public int compareTo(Node o) {
			if (cost < o.cost)
				return -1;
			if (cost > o.cost)
				return 1;
			return Integer.compare(name, o.name);
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
