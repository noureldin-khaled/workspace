package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DrivingRange {
	static Edge[] edglist;
	static ArrayList<Node> adjlist[];
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while(true) {
			int n = sc.nextInt(), m = sc.nextInt();
			if (n == 0 && m == 0) break;

			edglist = new Edge[m];
			for (int i = 0; i < m; i++) {
				int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
				edglist[i] = new Edge(w, u, v);
			}
			
			Arrays.sort(edglist);
			DisjointSets ds = new DisjointSets(n);
			
			adjlist = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjlist[i] = new ArrayList<Node>();
			
			for (Edge e : edglist)
				if (!ds.inSameSet(e.from, e.to)) {
					adjlist[e.from].add(new Node(e.to, e.weight));
					adjlist[e.to].add(new Node(e.from, e.weight));
					ds.union(e.from, e.to);
				}
			
			visited = new boolean[n];
			int ans = dfs(0, 0);
			
			boolean valid = true;
			for (int i = 0; i < n && valid; i++)
				if (!visited[i])
					valid = false;
			
			if (valid)
				out.println(ans);
			else
				out.println("IMPOSSIBLE");
		}

		out.flush();
		out.close();
	}
	
	public static int dfs(int u, int maxSoFar) {
		visited[u] = true;
		
		for (Node nxt : adjlist[u]) {
			if (!visited[nxt.name])
				maxSoFar = dfs(nxt.name, Math.max(maxSoFar, nxt.cost));
		}
		
		return maxSoFar;
	}

	static class Node {
		int name, cost;
		public Node(int n, int c) {
			name = n;
			cost = c;
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

	static class Edge implements Comparable<Edge> {
		int weight;
		int from;
		int to;

		public Edge(int weight, int from, int to){
			this.weight = weight;
			this.from = from;
			this.to = to;
		}

		public String toString(){
			return "("+weight+", ("+from+", " + to + "))";
		}

		public int compareTo(Edge o) {
			if (this.weight > o.weight)
				return 1;
			if (this.weight < o.weight)
				return -1;
			return 0;
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
