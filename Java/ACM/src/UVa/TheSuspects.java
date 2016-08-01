package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TheSuspects {
	static ArrayList<Integer> adjlist[];
	static boolean visited[];
	static int ans;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while(true) {
			int n = sc.nextInt(), m = sc.nextInt();
			if (n+m == 0) break;
			
			adjlist = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjlist[i] = new ArrayList<>();
			
			for (int i = 0; i < m; i++) {
				int k = sc.nextInt();
				int a[] = new int[k];
				for (int j = 0; j < k; j++)
					a[j] = sc.nextInt();
				
				for (int j = 0; j < k-1; j++) {
					adjlist[a[j]].add(a[j+1]);
					adjlist[a[j+1]].add(a[j]);
				}
			}
			visited = new boolean[n];
			ans = 0;
			dfs(0);
			out.println(ans);
		}
		
		out.flush();
		out.close();
	}
	
	static void dfs(int u) {
		visited[u] = true;
		ans++;
		
		for (Integer v : adjlist[u])
			if (!visited[v])
				dfs(v);
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
