package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VasiliysMultiset {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		BinaryTrie bt = new BinaryTrie();
		bt.update(0, 1);
		int q = sc.nextInt();
		while(q-->0) {
			char c = sc.next().charAt(0);
			int x = sc.nextInt();
			if (c == '+') 
				bt.update(x, 1);
			else if (c == '-') 
				bt.update(x, -1);
			else 
				out.println(bt.query(x));
		}
		
		out.flush();
		out.close();
	}
	
	static class Node {
		Node l, r;
		int val;
	}
	
	static class BinaryTrie {
		Node root;
		
		public BinaryTrie() {
			root = new Node();
		}
		
		void update(int x, int val) {
			update(root, 30, x, val);
		}
		
		void update(Node cur, int bit, int x, int val) {
			cur.val += val;
			if (bit == -1) 
				return;
			
			if ((x & (1 << bit)) == 0) { // left
				if (cur.l == null)
					cur.l = new Node();
				update(cur.l, bit-1, x, val); 
			}
			else { // right
				if (cur.r == null)
					cur.r = new Node();
				update(cur.r, bit-1, x, val);
			}
		}
		
		int query(int x) {
			return query(root, 30, x, 0);
		}
		
		int query(Node cur, int bit, int x, int acc) {
			if (bit == -1)
				return acc;
			
			if ((x & (1 << bit)) == 0) { // go for a 1
				if (cur.r != null && cur.r.val > 0)
					return query(cur.r, bit-1, x, acc | (1 << bit));
				return query(cur.l, bit-1, x, acc);
			}
			else { // go for a 0
				if (cur.l != null && cur.l.val > 0)
					return query(cur.l, bit-1, x, acc | (1 << bit));
				return query(cur.r, bit-1, x, acc);
			}
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
