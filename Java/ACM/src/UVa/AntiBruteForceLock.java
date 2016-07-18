package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AntiBruteForceLock {
	static Edge edgelist[];
	static int V;
	static int n;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		while(t-->0) {
			n = sc.nextInt();
			String a[] = new String[n+1];
			a[0] = "0000";
			for (int i = 1; i < n+1; i++)
				a[i] = sc.next();

			V = (n*(n-1))/2 + 1;
			edgelist = new Edge[V];
			int k = 0;
			for (int i = 1; i < n+1; i++)
				for (int j = i+1; j < n+1; j++) 
					edgelist[k++] = new Edge(i, j, op(a[i], a[j]));
			
			Edge e = new Edge(-1, -1, 100000);
			for (int i = 1; i < n+1; i++) {
				int o = op(a[0], a[i]);
				if (o < e.weight)
					e = new Edge(0, i, o);
			}
			edgelist[k++] = e;
			out.println(kruskal());
		}

		out.flush();
		out.close();
	}

	static int op(String s1, String s2) {
		int res = 0;
		for (int i = 0; i < 4; i++) {
			int c1 = s1.charAt(i) - '0';
			int c2 = s2.charAt(i) - '0';
			int tC1 = c1;

			int ans1 = 0;
			while(tC1 != c2) {
				ans1++;
				tC1 = MOD(tC1+1, 10);
			}

			tC1 = c1;
			int ans2 = 0;
			while(tC1 != c2) {
				ans2++;
				tC1 = MOD(tC1-1, 10);
			}

			res += Math.min(ans1, ans2);
		}

		return res;
	}

	static int MOD(int a, int b) {
		return (a%b + b)%b;
	}

	static long kruskal() {
		long mst = 0;
		Arrays.sort(edgelist);
		DisjointSets ds = new DisjointSets(n+1);

		for(Edge e: edgelist)
			if(!ds.inSameSet(e.from, e.to)) {
				mst += e.weight;
				ds.union(e.from, e.to);
			}

		return mst;
	}


	static class Edge implements Comparable<Edge> {
		int from, to;
		long weight;

		public Edge(int f, int t, long w) {
			from = f;
			to = t;
			weight = w;
		}

		@Override
		public int compareTo(Edge o) {
			if (weight > o.weight)
				return 1;
			else if (weight < o.weight)
				return -1;
			return 0;
		}
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
