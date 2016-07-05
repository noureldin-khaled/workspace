package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IntervalProduct {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		sc.waitForInput(3000);
		while(sc.Ready()) {
			int n = sc.nextInt(), k = sc.nextInt();
			
			int N = 1; while(N < n) N <<= 1; //padding
			int arr[] = new int[N+1];
			Arrays.fill(arr, 1);
			for (int i = 1; i <= n; i++) {
				int a = sc.nextInt();
				arr[i] = a > 0 ? 1 : a < 0 ? -1 : 0;
			}
						
			SegmentTree st = new SegmentTree(arr);

			while(k-->0) {
				char c = sc.next().charAt(0);
				if (c == 'C') {
					int i = sc.nextInt(), val = sc.nextInt();
					st.update_point(i, val > 0 ? 1 : val < 0 ? -1 : 0);
				}
				else {
					int i = sc.nextInt(), j = sc.nextInt();
					int p = st.query(i, j);
					out.print(p > 0 ? '+' : p < 0 ? '-' : '0');
				}
			}
			out.println();
		}
		
		out.flush();
		out.close();
	}
	
	static class SegmentTree {
		int N;
		int[] array, st;
		
		public SegmentTree(int[] arr) {
			array = arr;
			N = arr.length - 1;
			st = new int[N << 1]; // 2*N, should be 2N-1 but we add one to cross zero index.
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
				st[node] = st[left] * st[right]; // ->
			}
		}
		
		public void update_point(int node, int val) {
			node += N - 1;
			st[node] = val;
			while(node > 1) {
				node = parent(node);
				st[node] = st[left(node)] * st[right(node)]; // ->
			}
		}
		
		public int query(int i, int j) {
			return query(1, 1, N, i, j);
		}
		
		// O(log n)
		public int query(int node, int b, int e, int i, int j) {
			if (i > e || j < b)
				return 1;
			if (b >= i && e <= j)
				return st[node];
			
			int mid = (b+e)/2;
			int q1 = query(left(node), b, mid, i, j);
			int q2 = query(right(node), mid+1, e, i, j);
			return q1 * q2; // ->
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
