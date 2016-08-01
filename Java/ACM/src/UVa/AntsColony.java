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

public class AntsColony {
	static ArrayList<Node> adjlist[];
	static int n;
	static int[] L2, E, H;
	static long[] L1;
	static int idx;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true) {
			n = sc.nextInt();
			if (n == 0) break;

			adjlist = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjlist[i] = new ArrayList<>();

			for (int i = 1; i <= n-1; i++) {
				int A = sc.nextInt();
				long L = sc.nextLong();

				adjlist[i].add(new Node(A, L));
				adjlist[A].add(new Node(i, L));
			}

			int size = ((n-1) << 1) + 5;
			L1 = new long[size];
			L2 = new int[size];
			E = new int[size];
			H = new int[size];

			build();
			SparseTable st = new SparseTable(L2);
			
			int q = sc.nextInt();
			for (int i = 0; i < q; i++) {
				if (i > 0)
					out.print(" ");
				int u = sc.nextInt(), v = sc.nextInt();
				int s = H[u];
				int b = H[v];
				if (s > b) {
					int tmp = s;
					s = b;
					b = tmp;
				}
				
				int lca = E[st.query(s, b)];
				out.print(L1[s] + L1[b] - 2*L1[H[lca]]);
			}

			out.println();
		}

		out.flush();
		out.close();
	}

	static void dfs(int cur, long sumSoFar, int depth) {
		H[cur] = idx;
		E[idx] = cur;
		L2[idx] = depth;
		L1[idx++] = sumSoFar;

		for (Node nxt : adjlist[cur]) {
			if (H[nxt.name] == -1) {
				dfs(nxt.name, sumSoFar+nxt.weight, depth+1);
				E[idx] = cur;
				L2[idx] = depth;
				L1[idx++] = sumSoFar;
			}
		}
	}

	static void build() {
		idx = 0;
		Arrays.fill(H, -1);
		dfs(0, 0, 0);
	}

	static class Node {
		int name;
		long weight;

		public Node(int n, long w) {
			name = n;
			weight = w;
		}
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
