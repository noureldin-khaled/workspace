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

public class CockroachEscapeNetworks {
	static ArrayList<Integer> adjlist[];
	static int n;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		for (int c = 1; c <= t; c++) {
			n = sc.nextInt();
			int m = sc.nextInt();
			adjlist = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjlist[i] = new ArrayList<>();
			
			for (int i = 0; i < m; i++)
				adjlist[sc.nextInt()].add(sc.nextInt());
			
			int ans = 0;
			for (int i = 0; i < n; i++) 
				ans = Math.max(ans, bfs(i));
			
			out.printf("Case #%d:\n%d\n\n", c, ans);
		}
		
		out.flush();
		out.close();
	}
	
	static int bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		int dist[] = new int[n];
		Arrays.fill(dist, -1);
		dist[s] = 0;
		q.add(s);
		
		while(!q.isEmpty()) {
			int cur = q.remove();
			for (Integer nxt : adjlist[cur])
				if (dist[nxt] == -1) {
					dist[nxt] = dist[cur] + 1;
					q.add(nxt);
				}
		}
		
		int res = 0;
		for (int i = 0; i < n; i++)
			res = Math.max(res, dist[i]);
		return res;
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
