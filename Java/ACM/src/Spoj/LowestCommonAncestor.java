package Spoj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LowestCommonAncestor {
	static ArrayList<Integer> adjlist[];
	static int n;
	static int[] L, E, H;
	static int idx;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		for (int c = 1; c <= t; c++) {
			n = sc.nextInt();
			adjlist = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjlist[i] = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				int m = sc.nextInt();
				for (int j = 0; j < m; j++) {
					int node = sc.nextInt()-1;
					adjlist[i].add(node);
					adjlist[node].add(i);
				}
			}
			
			int size = ((n-1) << 1) + 1;
			L = new int[size];
			E = new int[size];
			H = new int[size];
			
			buildRMQ();
			SparseTable st = new SparseTable(L);
			
			int q = sc.nextInt();
			out.printf("Case %d:\n", c);
			while(q-->0) {
				int u = sc.nextInt()-1, v = sc.nextInt()-1;
				int s = H[u];
				int b = H[v];
				if (s > b) {
					int tmp = s;
					s = b;
					b = tmp;
				}
				
				out.println(E[st.query(s, b)] + 1);
			}
		}
		
		out.flush();
		out.close();
	}
	
	static void dfs(int cur, int depth) {
		H[cur] = idx;
		E[idx] = cur;
		L[idx++] = depth;

		for (Integer nxt : adjlist[cur]) {
			if (H[nxt] == -1) {
				dfs(nxt, depth+1);
				E[idx] = cur;
				L[idx++] = depth;
			}
		}
	}
	
	static void buildRMQ() {
		idx = 0;
		Arrays.fill(H, -1);
		dfs(0, 0);
	}
	
	static class SparseTable {
		int[] A, SpT[];
		
		public SparseTable(int[] A) {
			this.A = A;
			int n = A.length;
			int k = (int)Math.floor(Math.log(n) / Math.log(2)) + 1;
			SpT = new int[n][k];
			
			for (int i = 0; i < n; i++)
				SpT[i][0] = i;
			
			// O(n * log n)
			for (int j = 1; (1 << j) <= n; j++)
				for (int i = 0; i + (1 << j) - 1 < n; i++)
					if (A[SpT[i][j-1]] < A[SpT[i + (1 << (j-1))][j-1]])
						SpT[i][j] = SpT[i][j-1];
					else
						SpT[i][j] = SpT[i + (1 << (j-1))][j-1];
		}
		
		// O(1)
		public int query(int i, int j) {
			int k = (int)Math.floor(Math.log(j-i+1) / Math.log(2));

			if (A[SpT[i][k]] <= A[SpT[j - (1 << k) + 1][k]])
				return SpT[i][k];
			else
				return SpT[j - (1 << k) + 1][k];
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
