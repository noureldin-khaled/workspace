package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class XeniaAndBitOperations {
	static final int OR = 0;
	static final int XOR = 1;
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int h = sc.nextInt(), m = sc.nextInt();
		int n = 1 << h;
		int N = 1; while(N < n) N <<= 1;
		
		int arr[] = new int[N+1];
		for (int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();
		
		SegmentTree st = new SegmentTree(arr, h+1);
		
		while(m-->0) {
			int p = sc.nextInt(), b = sc.nextInt();
			st.update_point(p, b);
			out.println(st.root());
		}
		
		
		out.flush();
		out.close();
	}
	
	static class SegmentTree {
		int N;
		int[] array, st;
		
		public SegmentTree(int[] arr, int h) {
			array = arr;
			N = arr.length - 1;
			st = new int[N << 1];
			build(1, 1, N, h%2 == 0 ? OR : XOR);
		}
		
		public int root() {
			return st[1];
		}
			
		public void build(int node, int b, int e, int op) { // O(n)
			if (b == e)
				st[node] = array[b];
			else {
				int mid = (b+e) / 2;
				int left = left(node);
				int right = right(node);
				build(left, b, mid, 1 - op);
				build(right, mid+1, e, 1 - op);
				st[node] = op == OR ? st[left] | st[right] : st[left] ^ st[right];
			}
		}
		
		public void update_point(int node, int val) {
			node += N - 1;
			st[node] = val;
			int op = OR;
			while(node > 1) {
				node = parent(node);
				st[node] = op == OR ? st[left(node)] | st[right(node)] : st[left(node)] ^ st[right(node)];
				op = 1 - op;
			}
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
