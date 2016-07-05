package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Quadtrees {
	static final int WHITE = 1;
	static final int BLACK = 2;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		while(t-->0) {
			String l1 = sc.next();
			String l2 = sc.next();

			Tree t1 = new Tree(l1);
			Tree t2 = new Tree(l2);
			
			int ans = t1.combine(t2, 1, 0);
			out.printf("There are %d black pixels.\n", ans);
		}

		out.flush();
		out.close();
	}

	static class Tree {
		int arr[];
		LinkedList<Character> l;

		public Tree(String s) {
			int n = s.length();
			int N = 2000;
			
			arr = new int[N];
			l = new LinkedList<>();
			for (int i = 0; i < n; i++)
				l.addLast(s.charAt(i));
			if (l.removeFirst() == 'f')
				arr[1] = BLACK;
			else
				arr[1] = WHITE;
			
			build(1);
		}

		public void build(int node) {
			if (l.isEmpty()) return;
			
			for (int i = 0; i < 4; i++) {
				char c = l.removeFirst();
				int child = (4*node - 2) + i;
				if (c == 'p') {
					arr[child] = WHITE;
					build(child);
				}
				else if (c == 'e') 
					arr[child] = WHITE;
				else 
					arr[child] = BLACK;
			}
		}
		
		public int combine(Tree t, int node, int h) {
			if (h > 5)
				return 0;
			if (arr[node] == BLACK || t.arr[node] == BLACK)
				return (int) ((1.0/Math.pow(4, h)) * 1024);
			
			int ans = 0;
			for (int i = 0; i < 4; i++) {
				int child = (4*node - 2) + i;
				ans += combine(t, child, h+1);
			}
			
			return ans;
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
