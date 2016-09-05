package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GuardianOfDecency {
	static int n, m;
	static ArrayList<Integer> adjlist[];
	static int[] pairU, pairV, dist;
	static final int NIL = 0, INF = (int)1e9;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-->0) {
			int V = sc.nextInt();
			adjlist = new ArrayList[V+5];
			for (int i = 0; i < V+5; i++)
				adjlist[i] = new ArrayList<>();
			
			n = 0;
			m = 0;
			Puple a[] = new Puple[V];
			for (int i = 0; i < V; i++) {
				a[i] = new Puple(sc.nextInt(), sc.next().charAt(0), sc.next(), sc.next());
				if (a[i].gender == 'M')
					n++;
				else
					m++;
			}
			
			Puple male[] = new Puple[n];
			Puple female[] = new Puple[m];
			int k1 = 0, k2 = 0;
			
			for (int i = 0; i < V; i++)
				if (a[i].gender == 'M')
					male[k1++] = new Puple(a[i].height, a[i].gender, a[i].music, a[i].sport);
				else
					female[k2++] = new Puple(a[i].height, a[i].gender, a[i].music, a[i].sport);
			
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					if (f(male[i], female[j]))
						adjlist[i+1].add(j+1);
			
			out.println(V - hopcroftKarp());
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
	
	static boolean f(Puple p1, Puple p2) {
		return Math.abs(p1.height-p2.height) <= 40 && p1.music.equals(p2.music) && !p1.sport.equals(p2.sport);
	}
	
	static class Puple {
		int height;
		char gender;
		String music;
		String sport;
		
		public Puple(int h, char g, String m, String s) {
			height = h;
			gender = g;
			music = m;
			sport = s;
		}
		
		@Override
		public String toString() {
			return "(" + height + ", " + gender + ", " + music + ", " + sport + ")";
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
