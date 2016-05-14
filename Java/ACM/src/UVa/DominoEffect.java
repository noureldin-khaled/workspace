package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DominoEffect {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = 1;
		while(true) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			if (n == 0 && m == 0) break;

			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++)
				Arrays.fill(arr[i], -1);
			
			ArrayList<Node> adjlist[] = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjlist[i] = new ArrayList<>();

			for (int i = 0; i < m; i++) {
				int u = sc.nextInt() - 1;
				int v = sc.nextInt() - 1;
				int w = sc.nextInt();

				adjlist[u].add(new Node(v, w));
				adjlist[v].add(new Node(u, w));
				arr[u][v] = arr[v][u] = w;
			}

			int[] dist = new int[n];
			Arrays.fill(dist, -1);

			dist[0] = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0));
			while(!pq.isEmpty()) {
				Node cur = pq.remove();
				if(cur.cost > dist[cur.node])
					continue;
				
				for (Node nxt : adjlist[cur.node]) {
					if (dist[nxt.node] == -1 || cur.cost + nxt.cost < dist[nxt.node]) {
						dist[nxt.node] = cur.cost + nxt.cost;
						pq.add(new Node(nxt.node, dist[nxt.node]));
					}
				}
			}

			Answer ans = null;
			for (int i = 0; i < n; i++)
				if (ans == null || (double)dist[i] > ans.time) 
					ans = new Answer((double)dist[i], i + 1);
			
			int max = 0;
			for (int i = 0; i < n; i++) {
				if (arr[ans.key1-1][i] != -1) {
					int cur = dist[i] + arr[ans.key1-1][i] - dist[ans.key1-1];
					if(cur > max) {
						max = cur;
						ans = new Answer(dist[ans.key1-1] + cur/2.0, ans.key1, i + 1);
					}
				}
			}
			
			out.printf("System #%d\nThe last domino falls after %.1f seconds, ", t++, ans.time);
			if (ans.key2 == -1)
				out.println("at key domino " + ans.key1 + ".");
			else
				out.println("between key dominoes " + Math.min(ans.key1, ans.key2) + " and " + Math.max(ans.key1, ans.key2) + ".");
			out.println();
		}

		out.flush();
		out.close();
	}

	static class Answer {
		double time;
		int key1, key2;

		public Answer(double t, int k1, int k2) {
			time = t;
			key1 = k1;
			key2 = k2;
		}

		public Answer(double t, int k1) {
			time = t;
			key1 = k1;
			key2 = -1;
		}
	}

	static class Edge {
		int cost;
		boolean visited;

		public Edge(int c, boolean v) {
			cost = c;
			visited = v;
		}

		@Override
		public String toString() {
			return cost + " " + visited;
		}
	}

	static class Node implements Comparable<Node>{
		int node;
		int cost;

		public Node(int t, int c) {
			node = t;
			cost = c;
		}

		@Override
		public int compareTo(Node o) {
			if (Integer.compare(cost, o.cost) != 0)
				return Integer.compare(cost, o.cost);
			return Integer.compare(node, o.node);
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
