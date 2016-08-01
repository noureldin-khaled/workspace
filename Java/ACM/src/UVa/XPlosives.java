package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class XPlosives {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(sc.Ready()) {
			DisjointSets ds = new DisjointSets(100003);
			int ans = 0;
			while(true) {
				int u = sc.nextInt();
				if (u == -1) break;
				int v = sc.nextInt();
				
				if (ds.inSameSet(u, v))
					ans++;
				else
					ds.union(u, v);
			}
			
			out.println(ans);
		}

		out.flush();
		out.close();
	}

	static class DisjointSets {
		int representative[];
		int rank[];

		public DisjointSets(int n) {
			representative = new int[n];
			rank = new int[n];
			for (int i = 0; i < representative.length; i++)
				representative[i] = i;
			Arrays.fill(rank, 1);
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
			if (x1 != y1)
				if (rank[x1] > rank[y1]) {
					representative[y1] = x1;
				} else if (rank[x1] < rank[y1]) {
					representative[x1] = y1;
				} else {
					representative[x1] = y1;
					rank[y1]++;
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
