package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TheBridgesOfKolsberg {
	static Node a[];
	static Node b[];
	static int n, m;
	static Answer dp[][];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-->0) {
			TreeMap<String, Integer> tm = new TreeMap<>();
			int k = 0;
			n = sc.nextInt();
			a = new Node[n];
			for (int i = 0; i < n; i++)
			{
				sc.next();
				String name = sc.next();
				Integer x = tm.get(name);
				if (x == null)
				{
					x = k++;
					tm.put(name, x);
				}
				
				a[i] = new Node(x, sc.nextLong());
			}
			
			m = sc.nextInt();
			b = new Node[m];
			for (int i = 0; i < m; i++)
			{
				sc.next();
				String name = sc.next();
				Integer x = tm.get(name);
				if (x == null)
				{
					x = k++;
					tm.put(name, x);
				}
				
				b[i] = new Node(x, sc.nextLong());
			}
			
			dp = new Answer[n+2][m+2];
			out.println(rec(0, 0));
		}
		
		out.flush();
		out.close();
	}
	
	static Answer rec(int idx, int j) {
		if (idx == n || j == m)
			return new Answer(0, 0);
		
		if (dp[idx][j] != null)
			return dp[idx][j];
		
		Answer ans = new Answer(-1, Integer.MAX_VALUE);
		if (a[idx].name == b[j].name)
		{
			Answer tmp = rec(idx+1, j+1);
			Answer cur = new Answer(a[idx].value+b[j].value, 1);
			cur.cost += tmp.cost;
			cur.bridges += tmp.bridges;
					
			if (cur.cost > ans.cost || (cur.cost == ans.cost && cur.bridges < ans.bridges))
				ans = new Answer(cur.cost, cur.bridges);
		}
		
		Answer cur = rec(idx+1, j);
		if (cur.cost > ans.cost || (cur.cost == ans.cost && cur.bridges < ans.bridges))
			ans = new Answer(cur.cost, cur.bridges);
		
		cur = rec(idx, j+1);
		if (cur.cost > ans.cost || (cur.cost == ans.cost && cur.bridges < ans.bridges))
			ans = new Answer(cur.cost, cur.bridges);
		
		return dp[idx][j] = ans;
	}
	
	static class Answer {
		long cost;
		int bridges;
		
		public Answer(long c, int b) {
			cost = c;
			bridges = b;
		}
		
		@Override
		public String toString() {
			return cost + " " + bridges;
		}
	}
	
	static class Node {
		int name;
		long value;
		
		public Node(int n, long v) {
			name = n;
			value = v;
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
