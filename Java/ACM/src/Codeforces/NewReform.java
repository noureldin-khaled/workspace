package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NewReform {
	static ArrayList<Integer> adjlist[];
	static int indegrees[];
	static boolean [] visited;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		adjlist = new ArrayList[n];

		for (int i = 0; i < n; i++)
			adjlist[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;

			adjlist[u].add(v);
			adjlist[v].add(u);
		}
		indegrees = new int[n];
		visited = new boolean[n];
		
		int ans = 0;
		for (int i = 0; i < n; i++) 
			if (!visited[i])
				ans += dfs(i, -1);

		System.out.println(ans);
		
		StringBuilder sb = new StringBuilder();
		sb.delete(0, 0);
	}

	static int dfs(int u, int parent) {
		visited[u] = true;
		
		for (Integer v : adjlist[u]) {
			if (!visited[v]) {
				int temp = dfs(v, u);
				if (temp == 0)
					return 0;
			}
			else if (v != parent)
				return 0;
		}
		
		return 1;
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
