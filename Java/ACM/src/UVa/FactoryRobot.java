package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class FactoryRobot {
	static int V;
	static ArrayList<Integer> adjlist[];
	static boolean visited[];
	static final double EPS = 1e-9;
	static Stack<Integer> st;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int V = n+4;
			
			Pillar a[] = new Pillar[n];
			for (int i = 0; i < n; i++)
				a[i] = new Pillar(sc.nextInt(), sc.nextInt(), sc.nextInt());
			
			double low = 0.0;
			double high = 1000.0;
			double ans = -1;
			
			for (int k = 0; k < 64; k++) {
				double mid = low + (high-low)/2.0;
				
				adjlist = new ArrayList[V];
				for (int i = 0; i < V; i++)
					adjlist[i] = new ArrayList<>();
				
				for (int i = 0; i < n; i++) {
					Pillar cur = a[i];
					int node = i+4;
					if (f(cur, cur.x, 1000, 2*mid)) {
						adjlist[node].add(0);
						adjlist[0].add(node);
					}
					if (f(cur, cur.x, 0, 2*mid)) {
						adjlist[node].add(1);
						adjlist[1].add(node);
					}
					if (f(cur, 1000, cur.y, 2*mid)) {
						adjlist[node].add(2);
						adjlist[2].add(node);
					}
					if (f(cur, 0, cur.y, 2*mid)) {
						adjlist[node].add(3);
						adjlist[3].add(node);
					}
					
					for (int j = 0; j < n; j++) {
						if (node == j+4) continue;
						if (f(cur, a[j], 2*mid))
							adjlist[node].add(j+4);
					}
				}
						
				boolean flag = true;
				visited = new boolean[V];
				for (int i = 0; i < V && flag; i++)
					if (!visited[i]) {
						st = new Stack<>();
						dfs(i);
						
						if (isIsolated())
							flag = false;
					}
				
				if (flag) {
					ans = mid;
					low = mid;
				}
				else
					high = mid;
			}
			
			out.printf("%.3f\n", ans);
		}
		
		out.flush();
		out.close();
	}
	
	static void dfs(int u) {
		visited[u] = true;
		st.push(u);
		
		for (Integer v : adjlist[u])
			if (!visited[v])
				dfs(v);
	}
	
	static boolean isIsolated() {
		int c = 0;
		while(!st.isEmpty()) 
			if (st.pop() < 4)
				c++;
		return c >= 2;
	}
	
	static boolean f(Pillar p1, Pillar p2, double diameter) {
		double d = dist(p1.x, p1.y, p2.x, p2.y);
		d = d - (p1.r + p2.r);
		return d <= diameter + EPS;
	}
	
	static boolean f(Pillar p, int x, int y, double diameter) {
		double d = dist(p.x, p.y, x, y);
		d = d - p.r;
		return d <= diameter + EPS;
	}
	
	static double dist(int x1, int y1, int x2, int y2) {
		return Math.sqrt(sq((double)x2-x1) + sq((double)y2-y1));
	}
	
	static double sq(double n) {
		return n*n;
	}
	
	static class Pillar {
		int x, y, r;
		
		public Pillar(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
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
