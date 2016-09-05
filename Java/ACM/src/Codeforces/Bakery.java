package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bakery {
	static ArrayList<Node> adjlist[];
	static boolean isStorage[];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
		adjlist = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjlist[i] = new ArrayList<>();
		
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt()-1, v = sc.nextInt()-1;
			long w = sc.nextLong();
			
			adjlist[u].add(new Node(v, w));
			adjlist[v].add(new Node(u, w));
		}
		
		long[] dist = new long[n];
		Arrays.fill(dist, -1);
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		isStorage = new boolean[n];
		for (int i = 0; i < k; i++) {
			int a = sc.nextInt()-1;
			isStorage[a] = true;
			dist[a] = 0;
			pq.add(new Node(a, 0));
		}
		
		
		while(!pq.isEmpty()) {
			Node cur = pq.remove();
			if(cur.cost > dist[cur.name])
				continue;
			for(Node nxt: adjlist[cur.name])
				if(dist[nxt.name] == -1 || cur.cost + nxt.cost < dist[nxt.name])
				{
					dist[nxt.name] = cur.cost + nxt.cost;
					pq.add(new Node(nxt.name, dist[nxt.name]));
				}
		}
		
		long ans = -1;
		
		for (int i = 0; i < n; i++) {
			if (!isStorage[i] && dist[i] != -1) {
				if (ans == -1 || dist[i] < ans)
					ans = dist[i];
			}
		}
		
		out.println(ans);
		
		out.flush();
		out.close();
	}
	
	static class Node implements Comparable<Node>{
		int name;
		long cost;
		
		public Node(int n, long c) {
			name = n;
			cost = c;
		}
		
		@Override
		public int compareTo(Node o) {
			if (cost != o.cost)
				return cost > o.cost ? 1 : -1;
			return name > o.name ? 1 : -1;
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
