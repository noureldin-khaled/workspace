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

public class AbsurdistanRoads {
	static Edge[] edgeList;
	static int g[][];
	static boolean inMST[][];
	static ArrayList<Integer> adjlist[];
	static boolean visited[];
	static int n, st;
	static Edge e;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = 0;
		while(sc.Ready()) {
			if (t++ > 0)
				out.println();

			n = sc.nextInt();
			edgeList = new Edge[n * (n-1) / 2];
			g = new int[n][n];
			int k = 0;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					int c = sc.nextInt();
					g[i][j] = c;
					if (j > i) {
						edgeList[k++] = new Edge(c, i, j);
					}
				}

			inMST = new boolean[n][n];
			kruskal();
			adjlist = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjlist[i] = new ArrayList<>();
			
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (inMST[i][j])
						adjlist[i].add(j);
			e = null;
			for (int i = 0; i < n; i++) {
				visited = new boolean[n];
				st = i;
				dfs(i, 0);
			}

			if (e != null)
				inMST[e.from][e.to] = inMST[e.to][e.from] = true;

			for (int i = 0; i < n; i++)
				for (int j = 0; j < i; j++)
					if (inMST[i][j]) {
						out.printf("%d %d %d\n", i+1, j+1, g[i][j]);
						if (e == null) {
							out.printf("%d %d %d\n", i+1, j+1, g[i][j]);
							e = new Edge(0, 0, 0);
						}
					}
		}

		out.flush();
		out.close();
	}

	static void dfs(int u, int s) {
		visited[u] = true;
		if (u != st && g[st][u] > 0 && !inMST[st][u] && g[st][u] < s && (e == null || g[st][u] < e.weight))
			e = new Edge(g[st][u], st, u);
		
		for (int v : adjlist[u]) 
			if (!visited[v]) 
				dfs(v, s + g[u][v]);
	}

	static void kruskal() {
		Arrays.sort(edgeList);
		DisjointSets ds = new DisjointSets(n);

		for(Edge e: edgeList)
			if(!ds.inSameSet(e.from, e.to)) {
				ds.union(e.from, e.to);
				inMST[e.from][e.to] = inMST[e.to][e.from] = true;
			}
	}

	static class Node {
		int name, cost;

		public Node(int n, int c) {
			name = n;
			cost = c;
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
