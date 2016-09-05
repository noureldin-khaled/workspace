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

public class Bloodgroups {
	static ArrayList<Integer> adjlist[];
	static int n, m;
	static int[] pairU, pairV, dist;
	static final int NIL = 0, INF = (int)1e9;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		sc.waitForInput(2000);
		while(sc.Ready()) {
			int N = sc.nextInt(), Q = sc.nextInt();
			boolean a[][] = new boolean[N][N];
			
			boolean o = true;
			for (int i = 0; i < N; i++) {
				int B = sc.nextInt();
				if (B == N)
					o = false;
				
				while(B-->0)
					a[i][sc.nextInt()-1] = true;
			}
			
			while(Q-->0) {
				int B = sc.nextInt();
				if (B == 0)
					out.println(o ? 'Y' : 'N');
				else {
					boolean b[] = new boolean[N];
					for (int i = 0; i < B; i++)
						b[sc.nextInt()-1] = true;
					
					adjlist = new ArrayList[N+5];
					for (int i = 0; i < N+5; i++)
						adjlist[i] = new ArrayList<>();
					
					n = N;
					m = B;
					int k = 0;
					for (int i = 0; i < N; i++)
						if (b[i]) {
							for (int j = 0; j < N; j++)
								if (a[j][i])
									adjlist[j+1].add(k+1);
							k++;
						}
					
					out.println(hopcroftKarp() == B ? 'Y' : 'N');
				}
			}
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
