package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SKYLINE {
	static final int INF = (int) 2e9;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int N = 1; while(N < 100001) N <<= 1; //padding
			SegmentTree st = new SegmentTree(N+1);

			int ans = 0;
			for (int i = 0; i < n; i++) {
				int l = sc.nextInt(), r = sc.nextInt(), h = sc.nextInt();
				int tm = st.query(l, r-1, h);
				st.update_range(l, r-1, h);
				ans += tm;
			}

			out.println(ans);
		}

		out.flush();
		out.close();
	}

	static class Node {
		int max, min;

		public Node(int max, int min) {
			this.max = max;
			this.min = min;
		}

		@Override
		public String toString() {
			return "(maxH: " + max + ", " + "minH: " + min + ")"; 
		}
	}

	static class SegmentTree {
		int N;
		Node[] st, lazy;

		public SegmentTree(int n) {
			N = n - 1;
			st = new Node[N << 1];
			lazy = new Node[N << 1];

			for (int i = 0; i < N << 1; i++)
				st[i] = new Node(0, 0);
			for (int i = 0; i < N << 1; i++)
				lazy[i] = new Node(0, 0);
		}

		public void update_point(int node, int val) {
			node += N - 1;
			st[node].min = val;
			if (val > st[node].max)
				st[node].max = val;
			while(node > 1) {
				node = parent(node);
				st[node] = new Node(Math.max(st[left(node)].max, st[right(node)].max), Math.min(st[left(node)].min, st[right(node)].min));
			}
		}

		public void update_range(int i, int j, int val) {
			update_range(1, 1, N, i, j, val);
		}

		public void update_range(int node, int b, int e, int i, int j, int val) {
			if (i > e || j < b)
				return;
			if (b >= i && e <= j && val >= st[node].max) {
				st[node].max = val;
				lazy[node].max = Math.max(lazy[node].max, val);
				st[node].min = val;
				lazy[node].min = val;
			}
			else if (val >= st[node].min) {
				propagate(node);
				int mid = (b+e) / 2;
				int left = left(node);
				int right = right(node);

				update_range(left, b, mid, i, j, val);
				update_range(right, mid+1, e, i, j, val);
				st[node] = new Node(Math.max(st[left].max, st[right].max), Math.min(st[left].min, st[right].min));
			}
		}

		public int query(int i, int j, int h) {
			Node n = query(i, j);
			if (h >= n.max)
				return j-i+1;
			if (h < n.min || i == j)
				return 0;

			int mid = (i+j)/2;
			return query(i, mid, h) + query(mid+1, j, h);
		}

		public Node query(int i, int j) {
			return query(1, 1, N, i, j);
		}

		// O(log n)
		public Node query(int node, int b, int e, int i, int j) {
			if (i > e || j < b)
				return new Node(0, INF);
			if (b >= i && e <= j)
				return st[node];

			propagate(node);
			int mid = (b+e)/2;
			Node q1 = query(left(node), b, mid, i, j);
			Node q2 = query(right(node), mid+1, e, i, j);
			return new Node(Math.max(q1.max, q2.max), Math.min(q1.min, q2.min));
		}

		public void propagate(int node) {
			int left = left(node);
			int right = right(node);

			if (lazy[node].min > 0) {
				lazy[left].min = lazy[node].min;
				st[left].min = lazy[node].min;
				lazy[right].min = lazy[node].min;
				st[right].min = lazy[node].min;
			}

			lazy[left].max = Math.max(lazy[left].max, lazy[node].max);
			st[left].max = Math.max(st[left].max, lazy[node].max);
			lazy[right].max = Math.max(lazy[right].max, lazy[node].max);
			st[right].max = Math.max(st[right].max, lazy[node].max);
			lazy[node] = new Node(0, 0);
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

														/* ANOTHER SOLUTION */

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.StringTokenizer;
//
//public class SKYLINE {
//
//	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);
//
//		int t = sc.nextInt();
//		while(t-->0) {
//			int n = sc.nextInt();
//			int N = 1; while(N < 100001) N <<= 1; //padding
//			SegmentTree st = new SegmentTree(N+1);
//
//			for (int i = 0; i < n; i++) {
//				int l = sc.nextInt(), r = sc.nextInt(), h = sc.nextInt();
//				st.update_range(l, r-1, h);
//			}
//
//			out.println(st.ans);
//		}
//
//		out.flush();
//		out.close();
//	}
//
//	static class Node {
//		int max, min;
//
//		public Node(int max, int min) {
//			this.max = max;
//			this.min = min;
//		}
//
//		@Override
//		public String toString() {
//			return "(maxH: " + max + ", " + "minH: " + min + ")"; 
//		}
//	}
//
//	static class SegmentTree {
//		int N, ans;
//		Node[] st, lazy;
//
//		public SegmentTree(int n) {
//			N = n - 1;
//			st = new Node[N << 1];
//			lazy = new Node[N << 1];
//
//			for (int i = 0; i < N << 1; i++)
//				st[i] = new Node(0, 0);
//			for (int i = 0; i < N << 1; i++)
//				lazy[i] = new Node(0, 0);
//		}
//
//		public void update_range(int i, int j, int val) {
//			update_range(1, 1, N, i, j, val);
//		}
//
//		public void update_range(int node, int b, int e, int i, int j, int val) {
//			if (i > e || j < b)
//				return;
//			if (b >= i && e <= j && val >= st[node].max) {
//				st[node].max = val;
//				ans += (e-b+1);
//				lazy[node].max = Math.max(lazy[node].max, val);
//				st[node].min = val;
//				lazy[node].min = val;
//			}
//			else if (val >= st[node].min) {
//				propagate(node);
//				int mid = (b+e) / 2;
//				int left = left(node);
//				int right = right(node);
//
//				update_range(left, b, mid, i, j, val);
//				update_range(right, mid+1, e, i, j, val);
//				st[node] = new Node(Math.max(st[left].max, st[right].max), Math.min(st[left].min, st[right].min));
//			}
//		}
//
//		public void propagate(int node) {
//			int left = left(node);
//			int right = right(node);
//
//			if (lazy[node].min > 0) {
//				lazy[left].min = lazy[node].min;
//				st[left].min = lazy[node].min;
//				lazy[right].min = lazy[node].min;
//				st[right].min = lazy[node].min;
//			}
//
//			lazy[left].max = Math.max(lazy[left].max, lazy[node].max);
//			st[left].max = Math.max(st[left].max, lazy[node].max);
//			lazy[right].max = Math.max(lazy[right].max, lazy[node].max);
//			st[right].max = Math.max(st[right].max, lazy[node].max);
//
//			lazy[node] = new Node(0, 0);
//		}
//
//		public int left(int node) {
//			return node << 1;
//		}
//
//		public int right(int node) {
//			return (node << 1) + 1;
//		}
//
//		public int parent(int node) {
//			return node >> 1;
//		}
//	}
//
//	static class Scanner {
//		BufferedReader br;
//		StringTokenizer st;
//
//		public Scanner(FileReader f) {
//			br = new BufferedReader(f);
//		}
//
//		public Scanner(InputStream in) {
//			br = new BufferedReader(new InputStreamReader(in));
//		}
//
//		public String next() throws IOException {
//			while (st == null || !st.hasMoreTokens())
//				st = new StringTokenizer(br.readLine());
//			return st.nextToken();
//		}
//
//		public String nextLine() throws IOException {
//			return br.readLine();
//		}
//
//		public int nextInt() throws IOException {
//			return Integer.parseInt(next());
//		}
//
//		public long nextLong() throws IOException {
//			return Long.parseLong(next());
//		}
//
//		public double nextDouble() throws IOException {
//			return Double.parseDouble(next());
//		}
//
//		public boolean Ready() throws IOException {
//			return br.ready();
//		}
//
//		public void waitForInput(long time) {
//			long ct = System.currentTimeMillis();
//			while(System.currentTimeMillis() - ct < time) {};
//		}
//
//	}
//}

