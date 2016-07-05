package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BabaeiAndBirthdayCake {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int N = 1; while(N < n) N <<= 1;

		SegmentTree st = new SegmentTree(N+1);
		long a[] = new long[n];
		for (int i = 0; i < n; i++) 
			a[i] = f(sc.nextLong(), sc.nextLong());
		
		long a2[] = a.clone();
		Arrays.sort(a2);
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(a2));
		
		TreeMap<Long, Integer> tm = new TreeMap<>();
		for (int i = 0; i < n; i++)
			tm.put(a2[i], i);
		
		long res = 0;
		for (int i = 0; i < n; i++) {
			int index = tm.get(a[i]);
			long cur = a[i] + st.query(1, index);
			res = Math.max(cur, res);
			st.update_point(index+1, cur);
		}
		
		System.out.printf("%.9f\n", Math.PI * res);
	}

	public static long f(long r, long h) {
		return r * r * h;
	}

	static class SegmentTree {
		int N;
		long[] st;

		public SegmentTree(int n) {
			N = n - 1;
			st = new long[N << 1];
		}

		public void update_point(int node, long val) {
			node += N - 1;
			st[node] = val;
			while(node > 1) {
				node = parent(node);
				st[node] = Math.max(st[left(node)], st[right(node)]);
			}
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

			int mid = (b+e)/2;
			long q1 = query(left(node), b, mid, i, j);
			long q2 = query(right(node), mid+1, e, i, j);
			return Math.max(q1, q2);
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
