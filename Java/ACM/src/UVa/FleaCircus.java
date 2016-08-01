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

public class FleaCircus {
	static ArrayList<Integer> adjlist[];
	static int[] parent;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true) {
			int n = sc.nextInt();
			if (n == 0) break;
			
			adjlist = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjlist[i] = new ArrayList<>();
			
			for (int i = 0; i < n-1; i++) {
				int u = sc.nextInt()-1, v = sc.nextInt()-1;
				adjlist[u].add(v);
				adjlist[v].add(u);
			}
			
			int q = sc.nextInt();
			while(q-->0) {
				int u = sc.nextInt()-1, v = sc.nextInt()-1;
				parent = new int[n];
				visited = new boolean[n];
				Arrays.fill(parent, -1);
				dfs(u, v);
				int child[] = new int[n];
				int node = v;
				
				while(node != u) {
					int p = parent[node];
					child[p] = node;
					node = p;
				}
				
				while(true) {
					if (u == v) {
						out.printf("The fleas meet at %d.\n", u+1);
						break;
					}
					
					if (child[u] == v) {
						out.printf("The fleas jump forever between %d and %d.\n", Math.min(u, v)+1, Math.max(u, v)+1);
						break;
					}
					u = child[u];
					v = parent[v];
				}
			}
		}
		
		out.flush();
		out.close();
	}
	
	static void dfs(int u, int target) {
		visited[u] = true;
		if (u == target)
			return;
		
		for (Integer v : adjlist[u])
			if (!visited[v]) {
				parent[v] = u;
				dfs(v, target);
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
