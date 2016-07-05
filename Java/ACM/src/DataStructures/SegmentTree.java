package DataStructures;

import java.util.Scanner;

//Range Sum Query (with lazy propagation)
public class SegmentTree {
	/**
	 * full completely balanced tree.
	 * 1 based.
	 * power of 2 array.
	 * if not power of two make it and fill the extra cells with useless value.
	 * gcd(1, x) = 1
	 * gcd(0, x) = x
	 * 
	 *  -> 	This is where the variants of segment tree happens. for example if we want RMQ we change it to
	 *   	st[node] = Math.min(st[left], st[right]), and so on.
	 */
	
	
	int N;
	int[] array, st, lazy;
	
	public SegmentTree(int[] arr) {
		array = arr;
		N = arr.length - 1;
		st = new int[N << 1]; // 2*N, should be 2N-1 but we add one to cross zero index.
		lazy = new int[N << 1];
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
			st[node] = st[left] + st[right]; // ->
		}
	}
	
	public void update_point(int node, int val) {
		node += N - 1;
		st[node] += val;
		while(node > 1) {
			node = parent(node);
			st[node] = st[left(node)] + st[right(node)]; // ->
		}
	}
	
	public void update_range(int i, int j, int val) {
		update_range(1, 1, N, i, j, val);
	}
	
	public void update_range(int node, int b, int e, int i, int j, int val) {
		if (i > e || j < b)
			return;
		if (b >= i && e <= j) {
			st[node] += (e-b+1)*val;
			lazy[node] += val;
		}
		else {
			propagate(node, b, e);
			int mid = (b+e) / 2;
			int left = left(node);
			int right = right(node);
			
			update_range(left, b, mid, i, j, val);
			update_range(right, mid+1, e, i, j, val);
			st[node] = st[left] + st[right];
		}
	}
	
	public void propagate(int node, int b, int e) {
		int mid = (b+e) / 2;
		int left = left(node);
		int right = right(node);
		
		lazy[left] += lazy[node];
		lazy[right] += lazy[node];
		st[left] += (mid-b+1)*lazy[node];
		st[right] += (e-mid)*lazy[node];
		lazy[node] = 0;
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
		return q1 + q2; // ->
	}
	
	public void print() {
		for (int i = N; i < st.length; i++)
			System.out.print(st[i] + " ");
		System.out.println();
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
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int N = 1; while(N < n) N <<= 1; //padding
		
		int[] in = new int[N + 1];
		for(int i = 1; i <= n; i++)
			in[i] = sc.nextInt();
		
		SegmentTree st = new SegmentTree(in);

		st.print();
		
		sc.close();
	}
}
