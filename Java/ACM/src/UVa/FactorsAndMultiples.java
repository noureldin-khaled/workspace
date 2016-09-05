package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FactorsAndMultiples {
	static int n, m;
	static ArrayList<Integer> adjlist[];
	static int[] pairU, pairV, dist;
	static final int NIL = 0, INF = (int)1e9;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		for (int c = 1; c <= t; c++) {
			n = sc.nextInt();
			int a[] = new int[n];

			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();

			m = sc.nextInt();
			int b[] = new int[m];
			for (int i = 0; i < m; i++)
				b[i] = sc.nextInt();
			
			adjlist = new ArrayList[n+5];
			for (int i = 0; i < n+5; i++)
				adjlist[i] = new ArrayList<>();
			
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					if (a[i] == 0) {
						if (b[j] == 0)
							adjlist[i+1].add(j+1);
					}
					else if (b[j]%a[i] == 0)
						adjlist[i+1].add(j+1);
			
			out.printf("Case %d: %d\n", c, hopcroftKarp());
		}

		out.flush();
		out.close();
	}
	
	static int hopcroftKarp() {
		pairU = new int[n+1];
		pairV = new int[m+1];
		dist = new int[n+1];

		int matches = 0;

		// As long as there is an augmenting path
		while(bfs())
			for (int u = 1; u <= n; u++)
				// if current node is free and there
				// is an augmenting path from it
				if (pairU[u] == NIL && dfs(u))
					matches++;

		return matches;
	}

	// Returns true if there is an augmenting path
	static boolean bfs() {
		Queue<Integer> q = new LinkedList<Integer>();

		// First layer of nodes (set distance as 0)
		for (int u = 1; u <= n; u++)
			// if u is not matched
			if (pairU[u] == NIL) {	
				dist[u] = 0;
				q.add(u);
			}
			else
				// Else set distance as INF so that
				// this node is considered next time
				dist[u] = INF;

		dist[NIL] = INF;
		while(!q.isEmpty()) {
			int u = q.remove();
			// if this node can provide a shorter path to NIL
			if (dist[u] < dist[NIL])
				for (int v : adjlist[u])
					if (dist[pairV[v]] == INF) {
						dist[pairV[v]] = dist[u] + 1;
						q.add(pairV[v]);
					}
		}

		return dist[NIL] != INF;
	}

	// Adds augmenting path if there is one beginning with u
	static boolean dfs(int u) {
		if (u == NIL)
			return true;

		for (int v : adjlist[u])
			// Follow the distances set by BFS
			// If dfs for the pair of v also returns true (detected an augmenting path)
			if (dist[pairV[v]] == dist[u] + 1 && dfs(pairV[v])) {
				pairU[u] = v;
				pairV[v] = u;
				return true;
			}

		dist[u] = INF;
		return false;
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
