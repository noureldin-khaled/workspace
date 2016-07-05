package Hackerrank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SimilarPair {
	static ArrayList<Integer> adjlist[];
	static SegmentTree st;
	static long ans;
	static int n, t;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		t = sc.nextInt();
		
		adjlist = new ArrayList[n+1];
		for (int i = 0; i < n+1; i++)
			adjlist[i] = new ArrayList<>();
		
		int parent[] = new int[n+1];
		Arrays.fill(parent, -1);
		for (int i = 0; i < n-1; i++) {
			int u = sc.nextInt(), v = sc.nextInt();
			adjlist[u].add(v);
			adjlist[v].add(u);
			parent[v] = u;
		}
		
		int root = -1;
		for (int i = 1; i <= n; i++)
			if (parent[i] == -1) {
				root = i;
				break;
			}
		
		int N = 1; while(N < n) N <<= 1;
		st = new SegmentTree(N+1);
		dfs(root, -1);
		System.out.println(ans);
	}
	
	public static void dfs(int u, int p) {
		ans += st.query(Math.max(0, u-t), Math.min(n, u+t));
		st.toggle_point(u);
		
		for (int v : adjlist[u]) {
			if (v != p)
				dfs(v, u);
		}
		
		st.toggle_point(u);
	}
	
	static class SegmentTree {
		int N;
		int[] array, st;
		
		public SegmentTree(int n) {
			array = new int[n];
			N = n - 1;
			st = new int[N << 2];
		}
		
		public void toggle_point(int node) {
			node += N - 1;
			st[node] = 1 - st[node];
			while(node > 1) {
				node = parent(node);
				st[node] = st[left(node)] + st[right(node)]; // ->
			}
		}
		
		public int query(int i, int j) {
			return query(1, 1, N, i, j);
		}
		
		// O(log n)
		public int query(int node, int b, int e, int i, int j) {
			if (i > e || j < b)
				return 0;
			if (b >= i && e <= j)
				return st[node];
			
			int mid = (b+e)/2;
			int q1 = query(left(node), b, mid, i, j);
			int q2 = query(right(node), mid+1, e, i, j);
			return q1 + q2; // ->
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
