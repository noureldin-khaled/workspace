package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class InterestingArray {
	static PrintWriter out;
	static int n;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out);

		n = sc.nextInt();
		int m = sc.nextInt();
		int N = 1; while(N < n) N <<= 1;
		SegmentTree st = new SegmentTree(N+1);
		int a[] = new int[m];
		int b[] = new int[m];
		int q[] = new int[m];

		for (int i = 0; i < m; i++) {
			int l = sc.nextInt(), r = sc.nextInt(), val = sc.nextInt();
			st.update_range(l, r, val);
			a[i] = l;
			b[i] = r;
			q[i] = val;
		}

		boolean valid = true;
		for (int i = 0; i < m && valid; i++) {
			if (st.query(a[i], b[i]) != q[i])
				valid = false;
		}
		
		if (!valid)
			out.println("NO");
		else {
			out.println("YES");
			st.print(1);
		}
		out.flush();
		out.close();
	}

	static class SegmentTree {
		int N;
		int[] st, lazy;

		public SegmentTree(int n) {
			N = n - 1;
			st = new int[N << 1];
			lazy = new int[N << 1];
		}

		public void update_range(int i, int j, int val) {
			update_range(1, 1, N, i, j, val);
		}

		public void update_range(int node, int b, int e, int i, int j, int val) {
			if (i > e || j < b)
				return;
			if (b >= i && e <= j) {
				st[node] |= val;
				lazy[node] |= val;
			}
			else {
				propagate(node);
				int mid = (b+e) / 2;
				int left = left(node);
				int right = right(node);

				update_range(left, b, mid, i, j, val);
				update_range(right, mid+1, e, i, j, val);
				st[node] = st[left] & st[right];
			}
		}

		public void propagate(int node) {
			int left = left(node);
			int right = right(node);
			st[left] |= lazy[node];
			st[right] |= lazy[node];
			lazy[left] |= lazy[node];
			lazy[right] |= lazy[node];
			lazy[node] = 0;
		}

		public int query(int i, int j) {
			return query(1, 1, N, i, j);
		}

		// O(log n)
		public int query(int node, int b, int e, int i, int j) {
			if (i > e || j < b)
				return -1;
			if (b >= i && e <= j)
				return st[node];

			propagate(node);
			int mid = (b+e)/2;
			int q1 = query(left(node), b, mid, i, j);
			int q2 = query(right(node), mid+1, e, i, j);
			return q1 & q2;
		}

		public boolean isLeave(int node) {
			return node >= N && node <= n+N-1;
		}

		public boolean isOutside(int node) {
			return node > n+N-1;
		}

		public void print(int node) {
			if (isOutside(node))
				return;
			if (isLeave(node)) {
				out.print(st[node] + " ");
				return;
			}

			propagate(node);
			print(left(node));
			print(right(node));
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
