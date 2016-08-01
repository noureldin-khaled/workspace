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

public class NewYearTree {
	static ArrayList<Integer> adjlist[];
	static int n;
	static int[] E, H1, H2;
	static long[] L;
	static int idx;
	static long color[];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		n = sc.nextInt();
		int m = sc.nextInt();
		color = new long[n];
		for (int i = 0; i < n; i++)
			color[i] = sc.nextLong();

		adjlist = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjlist[i] = new ArrayList<>();

		for (int i = 0; i < n-1; i++) {
			int u = sc.nextInt()-1, v = sc.nextInt()-1;
			adjlist[u].add(v);
			adjlist[v].add(u);
		}

		int size = ((n-1) << 1) + 1;
		L = new long[size];
		H1 = new int[size];
		H2 = new int[size];
		E = new int[size];

		build();
		int N = 1; while(N < size) N <<= 1;
		long[] in = new long[N + 1];
		for(int i = 1; i <= size; i++)
			in[i] = L[i-1];
		SegmentTree st = new SegmentTree(in);
		
		while(m-->0) {
			int t = sc.nextInt();
			if (t == 1) {
				int node = sc.nextInt()-1, val = sc.nextInt();
				st.update_range(H1[node]+1, H2[node]+1, val);
			}
			else {
				int node = sc.nextInt()-1;
				out.println(Long.bitCount(st.query(H1[node]+1, H2[node]+1)));
			}
		}

		out.flush();
		out.close();
	}

	static void dfs(int cur) {
		H1[cur] = H2[cur] = idx;
		E[idx] = cur;
		L[idx++] = color[cur];

		for (Integer nxt : adjlist[cur]) {
			if (H1[nxt] == -1) {
				dfs(nxt);
				H2[cur] = idx;
				E[idx] = cur;
				L[idx++] = color[cur];
			}
		}
	}

	static void build() {
		idx = 0;
		Arrays.fill(H1, -1);
		Arrays.fill(H2, -1);
		dfs(0);
	}

	static class SegmentTree {
		int N;
		long[] array, lazy, st;

		public SegmentTree(long[] arr) {
			array = arr;
			N = arr.length - 1;
			st = new long[N << 1];
			lazy = new long[N << 1];
			build(1, 1, N);
		}

		public void build(int node, int b, int e) { // O(n)
			if (b == e) {
				long l = 0;
				if (array[b] > 0)
					l = (1L << array[b]);
				st[node] = l;
			}
			else {
				int mid = (b+e) / 2;
				int left = left(node);
				int right = right(node);
				build(left, b, mid);
				build(right, mid+1, e);
				st[node] = st[left] | st[right];
			}
		}

		public void update_range(int i, int j, int val) {
			update_range(1, 1, N, i, j, val);
		}

		public void update_range(int node, int b, int e, int i, int j, int val) {
			if (i > e || j < b)
				return;
			if (b >= i && e <= j) {
				st[node] = (1L << val);
				lazy[node] = val;
			}
			else {
				propagate(node);
				int mid = (b+e) / 2;
				int left = left(node);
				int right = right(node);

				update_range(left, b, mid, i, j, val);
				update_range(right, mid+1, e, i, j, val);
				st[node] = st[left] | st[right];
			}
		}

		public void propagate(int node) {
			if (lazy[node] == 0) return;
			int left = left(node);
			int right = right(node);
			
			lazy[left] = lazy[node];
			lazy[right] = lazy[node];
			st[left] = (1L << lazy[node]);
			st[right] = (1L << lazy[node]);
			lazy[node] = 0;
		}

		public long query(int i, int j) {
			return query(1, 1, N, i, j);
		}

		// O(log n)
		public long query(int node, int b, int e, int i, int j) {
			if (i > e || j < b)
				return 0;
			if (b >= i && e <= j)
				return st[node];

			propagate(node);
			int mid = (b+e)/2;
			long q1 = query(left(node), b, mid, i, j);
			long q2 = query(right(node), mid+1, e, i, j);
			return q1 | q2;
		}

		public int left(int node) {
			return node << 1;
		}

		public int right(int node) {
			return (node << 1) + 1;
		}

		public int parent(int node) {
			return node >> 1;
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
