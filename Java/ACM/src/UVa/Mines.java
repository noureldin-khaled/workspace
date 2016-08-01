package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Mines {
	static ArrayList<Integer> adjlist[];
	static int V, dfsCounter, SCC, dfs_num[], dfs_low[];
	static int[] SCC_id;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			adjlist = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjlist[i] = new ArrayList<>();
			
			Mine a[] = new Mine[n];
			for (int i = 0; i < n; i++)
				a[i] = new Mine(new Point(sc.nextDouble(), sc.nextDouble()), sc.nextInt());
			
			for (int i = 0; i < n; i++) {
				double d = ((double)a[i].d/2);
				Point br = new Point(a[i].p.x+d, a[i].p.y-d);
				Point tl = new Point(a[i].p.x-d, a[i].p.y+d);
				
				for (int j = 0; j < n; j++) {
					if (i == j) continue;
					
					if (inside(a[j].p, br, tl))
						adjlist[i].add(j);
				}
			}
			
			
			
			V = n;
			dfsCounter = 0;
			SCC = 0;
			dfs_num = new int[V];
			dfs_low = new int[V];
			SCC_id = new int[V];
			stack = new Stack<>();
			tarjanSCC();
			
			int parent[] = new int[SCC];
			Arrays.fill(parent, -1);
			for (int u = 0; u < n; u++)
				for (Integer v : adjlist[u])
					if (SCC_id[u] != SCC_id[v]) 
						parent[SCC_id[v]] = SCC_id[u];
					
			
			int ans = 0;
			for (int i = 0; i < SCC; i++)
				if (parent[i] == -1)
					ans++;
			out.println(ans);
		}
		
		out.flush();
		out.close();
	}
	
	static void tarjanSCC() {	//O(V + E)
		Arrays.fill(SCC_id, -1);
		for(int i = 0; i < V; ++i)
			if(dfs_num[i] == 0)
				tarjanSCC(i);
	}

	static void tarjanSCC(int u) {
		dfs_num[u] = dfs_low[u] = ++dfsCounter;
		stack.push(u);

		for(int v: adjlist[u]) {
			if(dfs_num[v] == 0)
				tarjanSCC(v);
			if(SCC_id[v] == -1)
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);	
		}
		if(dfs_num[u] == dfs_low[u]) {
			//SCC found
			while(true)	{
				int v = stack.pop();
				SCC_id[v] = SCC;
				if(v == u)
					break;
			}
			SCC++;
		}
	}
	
	static boolean inside(Point p, Point br, Point tl) {
		return p.between(br, tl);
	}
	
	static class Point {
		double x, y;
		
		static final double EPS = 1e-9;
		
		public Point(double a, double b) {
			x = a;
			y = b;
		}
		
		public boolean between(Point p, Point q) {
			return x + EPS > Math.min(p.x, q.x) && x < Math.max(p.x, q.x) + EPS && y + EPS > Math.min(p.y, q.y) && y < Math.max(p.y, q.y) + EPS;
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
		
	}
	
	static class Mine {
		int d;
		Point p;
		
		public Mine(Point p, int d) {
			this.p = p;
			this.d = d;
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
