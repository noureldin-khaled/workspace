package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AlyonaAndTheTree {
	static ArrayList<Node> adjlist[];
	static boolean visited[];
	static int a[];
	static int ans;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		adjlist = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjlist[i] = new ArrayList<Node>();
		
		a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		
		for (int u = 1; u < n; u++) {
			int v = sc.nextInt()-1;
			long w = sc.nextLong();
			adjlist[u].add(new Node(v, w));
			adjlist[v].add(new Node(u, w));
		}
		
		visited = new boolean[n];
		ans = 0;
		dfs(0, 0);
		System.out.println(ans);
	}
	
	public static void dfs(int node, long soFar) {
		visited[node] = true;
		
		if (soFar > a[node]) {
			dfs2(node);
			return;
		}
		
		for (Node e : adjlist[node]) 
			if (!visited[e.name])
				dfs(e.name, Math.max(0, soFar+e.weight));
	}
	
	public static void dfs2(int node) {
		visited[node] = true;
		ans++;
		
		for (Node e : adjlist[node])
			if (!visited[e.name])
				dfs2(e.name);
	}
	
	static class Node {
		int name;
		long weight;
		
		public Node(int n, long w) {
			name = n;
			weight = w;
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
