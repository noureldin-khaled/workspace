package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SerejaAndBrackets {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		char[] seq = sc.nextLine().toCharArray();
		int n = seq.length;
		int N = 1; while(N < n) N = N << 1;
		
		Node[] arr = new Node[N+1];
		for (int i = 0; i < N+1; i++)
			arr[i] = new Node(0, 0, 0);
		
		for (int i = 1; i <= n; i++) 
			arr[i] = new Node(0, seq[i-1] == '(' ? 1 : 0, seq[i-1] == ')' ? 1 : 0);
		
		SegmentTree st = new SegmentTree(arr);
		int q = sc.nextInt();
		while(q-->0) {
			int l = sc.nextInt(), r = sc.nextInt();
			out.println(st.query(l, r).max);
		}
		
		out.flush();
		out.close();
	}
	
	static class Node {
		int max, open, closed;
		
		public Node(int m, int o, int c) {
			max = m;
			open = o;
			closed = c;
		}
		
		@Override
		public String toString() {
			return "(" + max + ", " + open + ", " + closed + ")";
		}
	}
	
	static class SegmentTree {
		int N;
		Node[] array, st;
		
		public SegmentTree(Node[] arr) {
			array = arr;
			N = arr.length - 1;
			st = new Node[N << 1]; // 2*N, should be 2N-1 but we add one to cross zero index.
			build(1, 1, N);
		}
			
		public void build(int node, int b, int e) { // O(n)
			if (b == e)
				st[node] = new Node(array[b].max, array[b].open, array[b].closed);
			else {
				int mid = (b+e) / 2;
				int left = left(node);
				int right = right(node);
				build(left, b, mid);
				build(right, mid+1, e);
				int leftRemBrackets = Math.max(0, st[left].open - st[left].max/2);
				int rightRemBrackets = Math.max(0, st[right].closed - st[right].max/2);
				
				st[node] = new Node(st[left].max + st[right].max + 2*Math.min(leftRemBrackets, rightRemBrackets), st[left].open + st[right].open, st[left].closed + st[right].closed); // ->
			}
		}
		
		public Node query(int i, int j) {
			return query(1, 1, N, i, j);
		}
		
		// O(log n)
		public Node query(int node, int b, int e, int i, int j) {
			if (i > e || j < b)
				return null;
			if (b >= i && e <= j)
				return st[node];
			
			int mid = (b+e)/2;
			Node q1 = query(left(node), b, mid, i, j);
			Node q2 = query(right(node), mid+1, e, i, j);
			return q1 == null ? new Node(q2.max, q2.open, q2.closed) : q2 == null ? new Node(q1.max, q1.open, q1.closed) : new Node(q1.max + q2.max + 2*Math.min(Math.max(0, q1.open - q1.max/2), Math.max(0, q2.closed - q2.max/2)), q1.open + q2.open, q1.closed + q2.closed); // ->
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
