package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class DirectedRoads {
	static ArrayList<Integer> adjlist[];
	static int n, dfsCounter, dfs_num[], dfs_low[];
	static boolean[] inSCC;
	static Stack<Integer> stack;
	static long ways;
	static long edges;
	static final int mod = (int)1e9 + 7;
	static final BigInteger MOD = BigInteger.valueOf(mod);
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		adjlist = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjlist[i] = new ArrayList<>();
		
		int in[] = new int[n];
		for (int i = 0; i < n; i++) {
			int v = sc.nextInt()-1;
			adjlist[i].add(v);
			in[v]++;
		}
		
		ways = 1;
		edges = 0;
		dfsCounter = 0;
		dfs_low = new int[n];
		dfs_num = new int[n];
		inSCC = new boolean[n];
		stack = new Stack<>();
		tarjanSCC();
		
		System.out.println(ways * (BigInteger.valueOf(2).modPow(BigInteger.valueOf(n - edges), MOD).longValue()) % mod);
	}
	
	static void tarjanSCC() {
		for (int i = 0; i < n; ++i)
			if (dfs_num[i] == 0)
				tarjanSCC(i);
	}

	static void tarjanSCC(int u) {
		dfs_num[u] = dfs_low[u] = ++dfsCounter;
		stack.push(u);

		for (int v : adjlist[u]) {
			if (dfs_num[v] == 0)
				tarjanSCC(v);
			if (!inSCC[v])
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
		}
		if (dfs_num[u] == dfs_low[u]) {
			int s = 0;
			while (true) {
				int v = stack.pop();
				inSCC[v] = true;
				s++;
				if (v == u)
					break;
			}
			if (s > 1){
				ways = (ways % mod * (BigInteger.valueOf(2).modPow(BigInteger.valueOf(s), MOD).longValue() - 2) % mod) % mod;
				edges += s;
			}
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
