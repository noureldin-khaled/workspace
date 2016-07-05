package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AhoyPirates {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int TC = sc.nextInt();
		for (int i = 1; i <= TC; i++) {
			int m = sc.nextInt();
			StringBuilder acc = new StringBuilder();
			for (int j = 0; j < m; j++) {
				int t = sc.nextInt();
				String s = sc.nextLine();
				StringBuilder sb = new StringBuilder();
				while(t-->0)
					sb.append(s);
				acc.append(sb);
			}

			int n = acc.length();
			int N = 1; while(N < n) N = N << 1;
			int arr[] = new int[N+1];

			for (int j = 1; j <= n; j++)
				arr[j] = acc.charAt(j-1) - '0';

			SegmentTree st = new SegmentTree(arr);
			int q = sc.nextInt();
			out.printf("Case %d:\n", i);
			int j = 1;
			while(q-->0) {
				char type = sc.next().charAt(0);
				int l = sc.nextInt()+1, r = sc.nextInt()+1;
				if (type == 'S') 
					out.printf("Q%d: %d\n", j++, st.query(l, r));
				else 
					st.update_range(l, r, type);
			}
		}

		out.flush();
		out.close();
	}

	static class SegmentTree {
		int N;
		int[] array, st;
		char[] lazy;

		public SegmentTree(int[] arr) {
			array = arr;
			N = arr.length - 1;
			st = new int[N << 1]; // 2*N, should be 2N-1 but we add one to cross zero index.
			lazy = new char[N << 1];
			Arrays.fill(lazy, 'U');
			build(1, 1, N);
		}

		public void build(int node, int b, int e) { // O(n)
			if (b == e)
				st[node] = array[b];
			else {
				int mid = (b+e) / 2;
				int left = left(node);
				int right = right(node);
				build(left, b, mid);
				build(right, mid+1, e);
				st[node] = st[left] + st[right];
			}
		}

		public void update_lazy(int node, char type) {
			if (type == 'U') return;

			if (type == 'I') {
				switch(lazy[node]) {
				case 'F': lazy[node] = 'E'; break;
				case 'E': lazy[node] = 'F'; break;
				case 'I': lazy[node] = 'U'; break;
				case 'U': lazy[node] = 'I'; break;
				}
			}
			else
				lazy[node] = type;
		}

		public void update_opr(int node, int b, int e, char type) {
			if (type == 'U') return;

			switch(type) {
			case 'E': st[node] = 0; break;
			case 'F': st[node] = (e-b+1); break;
			case 'I': st[node] = (e-b+1) - st[node]; break;
			}
		}

		public void update_range(int i, int j, char type) {
			update_range(1, 1, N, i, j, type);
		}

		public void update_range(int node, int b, int e, int i, int j, char type) {
			if (i > e || j < b)
				return;
			if (b >= i && e <= j) {
				update_lazy(node, type);
				update_opr(node, b, e, type);
			}
			else {
				propagate(node, b, e);
				int mid = (b+e) / 2;
				int left = left(node);
				int right = right(node);

				update_range(left, b, mid, i, j, type);
				update_range(right, mid+1, e, i, j, type);
				st[node] = st[left] + st[right];
			}

		}

		public void propagate(int node, int b, int e) {
			int mid = (b+e) / 2;
			int left = left(node);
			int right = right(node);

			update_lazy(left, lazy[node]);
			update_lazy(right, lazy[node]);
			update_opr(left, b, mid, lazy[node]);
			update_opr(right, mid+1, e, lazy[node]);

			lazy[node] = 'U';
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

			propagate(node, b, e);
			int mid = (b+e)/2;
			int q1 = query(left(node), b, mid, i, j);
			int q2 = query(right(node), mid+1, e, i, j);
			return q1 + q2;
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
