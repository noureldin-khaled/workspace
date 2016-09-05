package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BuyOneGetTheRestFree {
	static int n, d, V, s, t, sum;
	static final int INF = (int)1e9;
	static ArrayList<Node>[] adjlist;
	static int[] z, p;
	static int[][] res, a, o;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int cases = sc.nextInt();
		for (int tc = 1; tc <= cases; tc++) {
			n = sc.nextInt();
			d = sc.nextInt()+1;
			int m = sc.nextInt();
			
			a = new int[n][d];
			int k = 0;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < d; j++)
					a[i][j] = k++;
			
			V = k+1;
			o = new int[V][V];
			
			adjlist = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjlist[i] = new ArrayList<>();
			
			for (int i = 0; i < m; i++) {
				int u = sc.nextInt()-1, v = sc.nextInt()-1, c = sc.nextInt(), p = sc.nextInt(), dd = sc.nextInt();
				if (u == v) continue;
				int x = a[u][dd], y = a[v][dd+1];
				adjlist[x].add(new Node(y, p));
				adjlist[y].add(new Node(x, p));
				
				o[x][y] = c;
			}
			
			z = new int[n];
			sum = 0;
			for (int i = 0; i < n; i++) {
				z[i] = sc.nextInt();
				sum += z[i];
				
				int u = V-1, v = a[i][0];
				adjlist[u].add(new Node(v, 0));
				adjlist[v].add(new Node(u, 0));
				
				o[u][v] = z[i];
			}
			
			for (int i = 0; i < n; i++)
				for (int j = 0; j < d-1; j++) {
					int u = a[i][j], v = a[i][j+1];
					adjlist[u].add(new Node(v, 0));
					adjlist[v].add(new Node(u, 0));
					
					o[u][v] = INF;
				}
			
			s = V-1;
			t = a[n-1][d-1];
			
			int low = 0;
			int high = 100000;
			int ans = -1;
			
			while(low <= high) {
				int mid = low + (high-low)/2;
				if (mf(mid)) {
					ans = mid;
					high = mid-1;
				}
				else
					low = mid+1;
			}
			
			out.printf("Case #%d: ", tc);
			if (ans == -1)
				out.println("Impossible");
			else
				out.println(ans);
		}
		
		out.flush();
		out.close();
	}
	
	static boolean mf(int cur) {
		res = new int[V][V];
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				res[i][j] = o[i][j];
		int mf = 0;
		while(true) {
			Queue<Integer> q = new LinkedList<Integer>();
			p = new int[V];
			Arrays.fill(p, -1);
			p[s] = s;
			q.add(s);
			while(!q.isEmpty()) {
				int u = q.remove();
				if(u == t)
					break;
				for(Node v: adjlist[u])
					if(res[u][v.name] > 0 && p[v.name] == -1 && v.price <= cur) {
						p[v.name] = u;
						q.add(v.name);
					}
			}

			if(p[t] == -1)
				break;
			mf += augment(t, INF);

		}
		
		return mf == sum;
	}

	static int augment(int v, int flow) {
		if(v == s)
			return flow;
		flow =  augment(p[v], Math.min(res[p[v]][v],flow));
		res[p[v]][v] -= flow;
		res[v][p[v]] += flow;

		return flow;
	}
	
	static class Node {
		int name, price;
		
		public Node(int n, int p) {
			name = n;
			price = p;
		}
		
		@Override
		public String toString() {
			return "(" + name + ", " + price + ")";
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
			while (System.currentTimeMillis() - ct < time) {
			}
			;
		}

	}

}
