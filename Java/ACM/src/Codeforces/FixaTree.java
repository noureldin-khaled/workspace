package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FixaTree {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt();
		int a[] = new int[n];
		DisjointSets ds = new DisjointSets(n);
		for (int i = 0; i < n; i++) {
			int p = sc.nextInt()-1;
			if (!ds.inSameSet(i, p)) 
				ds.union(i, p);
			a[i] = p;
		}

		int root = -1;
		for (int i = 0; i < n; i++)
			if (a[i] == i) {
				root = i;
				break;
			}

		if (root == -1) {
			for (int i = 0; i < n; i++) 
				if (ds.parent[i] == -1) {
					root = i;
					ds.parent[i] = i;
					break;
				}
		}

		for (int i = 0; i < n; i++) 
			if (ds.parent[i] == -1) 
				ds.parent[i] = root;
		
		int ans = 0;
		for (int i = 0; i < n; i++) 
			if (ds.parent[i] != a[i])
				ans++;

		out.println(ans);
		for (int i = 0; i < n; i++) {
			if (i > 0)
				out.print(" ");
			out.print(ds.parent[i] + 1);
		}

		out.println();
		out.flush();
		out.close();
	}

	static class DisjointSets {
		int representative[];
		int rank[];
		int parent[];

		public DisjointSets(int n) {
			representative = new int[n];
			rank = new int[n];
			parent = new int[n];
			for (int i = 0; i < representative.length; i++)
				representative[i] = i;
			Arrays.fill(rank, 1);
			Arrays.fill(parent, -1);
		}

		int findSet(int x) {
			if (x == representative[x])
				return x;
			return representative[x] = findSet(representative[x]);
		}

		boolean inSameSet(int x,int y){
			return (findSet(x) == findSet(y));
		}

		void union(int x, int y) {
			int x1 = findSet(x);
			int y1 = findSet(y);
			if (x1 != y1) {
				if (rank[x1] > rank[y1]) {
					representative[y1] = x1;
				} else if (rank[x1] < rank[y1]) {
					representative[x1] = y1;
				} else {
					representative[x1] = y1;
					rank[y1]++;
				}

				parent[x] = y;
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
