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

public class Hotelbooking {
	static ArrayList<Node> adjlist[];
	static final int LMT = 600;
	static int n;
	static boolean[] hotel, used;
	static Queue<Node> nodes;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true) {
			n = sc.nextInt();
			if (n == 0) break;
			
			adjlist = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjlist[i] = new ArrayList<>();
			hotel = new boolean[n];
			int k = sc.nextInt();
			for (int i = 0; i < k; i++)
				hotel[sc.nextInt()-1] = true;
			
			int m = sc.nextInt();
			for (int i = 0; i < m; i++) {
				int u = sc.nextInt()-1, v = sc.nextInt()-1;
				long w = sc.nextLong();
				
				adjlist[u].add(new Node(v, w));
				adjlist[v].add(new Node(u, w));
			}
			
			used = new boolean[n];
			nodes = new LinkedList<>();
			nodes.add(new Node(0, 0));
			used[0] = true;
			long ans = -1;
			
			while(!nodes.isEmpty()) {
				Node s = nodes.remove();
				if (bfs(s) && (ans == -1 || s.cost < ans)) 
					ans = s.cost;
			}
			
			out.println(ans);
		}
		
		out.flush();
		out.close();
	}
	
	static boolean bfs(Node s) {
		long dist[] = new long[n];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(s.name, 0));
		Arrays.fill(dist, -1);
		dist[s.name] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.remove();
			if (cur.name == n-1)
				return true;
			
			for (Node nxt : adjlist[cur.name])
				if ((dist[nxt.name] == -1 || cur.cost + nxt.cost < dist[nxt.name]) && cur.cost + nxt.cost <= LMT) {
					dist[nxt.name] = cur.cost + nxt.cost;
					q.add(new Node(nxt.name, dist[nxt.name]));
					if (hotel[nxt.name] && !used[nxt.name]) {
						used[nxt.name] = true;
						nodes.add(new Node(nxt.name, s.cost+1));
					}
				}
		}
		
		return false;
	}
	
	static class Node {
		int name;
		long cost;
		
		public Node(int n, long c) {
			name = n;
			cost = c;
		}
		
		@Override
		public String toString() {
			return "(" + name + ", " + cost + ")";
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
