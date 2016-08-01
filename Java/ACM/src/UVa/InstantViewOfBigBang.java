package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class InstantViewOfBigBang {
	static final int INF = (int)1e9;
	static boolean visited[];
	static ArrayList<Node> adjlist[];
	static ArrayList<Integer> dag[];
	static TreeSet<Integer> ts;
	static int V, dfsCounter, SCC, dfs_num[], dfs_low[];
	static int[] SCC_id;
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		for (int c = 1; c <= t; c++) {
			out.printf("Case %d:", c);

			int n = sc.nextInt(), m = sc.nextInt();
			adjlist = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjlist[i] = new ArrayList<>();

			for (int i = 0; i < m; i++) {
				int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
				adjlist[u].add(new Node(v, w));
			}

			V = n;
			dfs_low = new int[V];
			dfs_num = new int[V];
			SCC_id = new int[V];
			SCC = 0;
			dfsCounter = 0;
			stack = new Stack<>();
			tarjanSCC();

			ArrayList<Integer> elements[] = new ArrayList[SCC];
			for (int i = 0; i < SCC; i++)
				elements[i] = new ArrayList<>();

			for (int i = 0; i < V; i++)
				elements[SCC_id[i]].add(i);

			dag = new ArrayList[SCC];
			for (int i = 0; i < SCC; i++)
				dag[i] = new ArrayList<>();

			ArrayList<Node> a[] = new ArrayList[n];
			for (int i = 0; i<  n; i++)
				a[i] = new ArrayList<>();

			for (int i = 0; i < V; i++)
				for (Node v : adjlist[i])
					if (SCC_id[i] != SCC_id[v.name])
						dag[SCC_id[i]].add(SCC_id[v.name]);
					else
						a[i].add(new Node(v.name, v.cost));
			
			System.out.println(SCC);
			for (int i = 0; i < n; i++)
				System.out.println(i + ": " + a[i]);
			int[] dist = new int[V];
			ts = new TreeSet<>();
			for (int i = 0; i < SCC; i++) {
				Arrays.fill(dist, INF);
				dist[elements[i].get(0)] = 0;
				int size = elements[i].size();
				boolean modified = true;
				for (int k = 0; k < size-1 && modified; k++) {
					int u = elements[i].get(0);
					modified = false;
					for (Node nxt : a[u])
						if (dist[u] + nxt.cost < dist[nxt.name]) { 
							dist[nxt.name] = dist[u] + nxt.cost;
							modified = true;
						}
				}

				boolean negative_cycle_exists = false;
				for (int j = 0; j < size; j++) {
					int u = elements[i].get(j);
					for (Node nxt : a[u])
						if (dist[u] + nxt.cost < dist[nxt.name]) {
							negative_cycle_exists = true;
							break;
						}
				}

				if (negative_cycle_exists) 
					ts.add(i);
			}

			visited = new boolean[SCC];
			for (int i = 0; i < SCC; i++)
				if (!visited[i])
					dfs(i);

			if (ts.isEmpty())
				out.print(" impossible");
			else {
				TreeSet<Integer> res = new TreeSet<>();
				for (Integer i : ts)
					res.addAll(elements[i]);

				for (Integer i : res)
					out.print(" " + i);
			}

			out.println();
		}

		out.flush();
		out.close();
	}

	static void tarjanSCC() { // O(V + E)
		Arrays.fill(SCC_id, -1);
		for (int i = 0; i < V; ++i)
			if (dfs_num[i] == 0)
				tarjanSCC(i);
	}

	static void tarjanSCC(int u) {
		dfs_num[u] = dfs_low[u] = ++dfsCounter;
		stack.push(u);

		for (Node v : adjlist[u]) {
			if (dfs_num[v.name] == 0)
				tarjanSCC(v.name);
			if (SCC_id[v.name] == -1)
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v.name]);
		}
		if (dfs_num[u] == dfs_low[u]) {
			// SCC found
			while (true) {
				int v = stack.pop();
				SCC_id[v] = SCC;
				if (v == u)
					break;
			}
			SCC++;
		}
	}

	static void dfs(int u) {
		visited[u] = true;

		for (Integer v : dag[u]) {
			if (!visited[v]) 
				dfs(v);
			if (ts.contains(v))
				ts.add(u);
		}
	}

	static class Node {
		int name, cost;

		public Node(int n, int c) {
			name = n;
			cost = c;
		}

		@Override
		public String toString() {
			return "(" + name + ", " + cost + ")";
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
