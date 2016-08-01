package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SwapsInPermutation {
	static ArrayList<Integer> adjlist[];
	static boolean visited[];
	static PriorityQueue<Integer> values, positions;
	static int a[];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt(), m = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		
		values = new PriorityQueue<>();
		positions = new PriorityQueue<>();
		adjlist = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjlist[i] = new ArrayList<>();
		
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt()-1, v = sc.nextInt()-1;
			adjlist[u].add(v);
			adjlist[v].add(u);
		}
		
		int res[] = new int[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) 
			if (!visited[i]) {
				values = new PriorityQueue<>(new Sorter());
				positions = new PriorityQueue<>();
				dfs(i);
				
				while (!values.isEmpty() && !positions.isEmpty()) {
					int val = values.remove();
					int pos = positions.remove();
					
					res[pos] = val;
				}
			}
		
		for (int i = 0; i < n; i++)
			out.print(res[i] + " ");
		
		out.flush();
		out.close();
	}
	
	static void dfs(int u) {
		visited[u] = true;
		positions.add(u);
		values.add(a[u]);
		
		for (Integer v : adjlist[u])
			if (!visited[v])
				dfs(v);
	}
	
	static class Sorter implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return  o2 - o1;
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
