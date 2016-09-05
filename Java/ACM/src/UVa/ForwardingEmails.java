package UVa;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class ForwardingEmails {
	static int[] adjList;
	static int[]  dfs_num, dfs_low, size;
	static boolean[] inSCC;
	static int dfsNumberCounter;
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		for(int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			adjList = new int[n];

			for(int j = 0; j < n; j++) {
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;

				adjList[u] = v;
			}

			dfs_low = new int[n];
			dfs_num = new int[n];
			dfsNumberCounter = 0;
			stack = new Stack<Integer>();
			inSCC = new boolean[n];
			size = new int[n];

			for(int j = 0; j < n; j++) 
				if (dfs_num[j] == 0)
					SCC(j);

			int max = 0;
			int maxNode = -1;
			for(int j = 0; j < n; j++) {
				if (size[j] > max) {
					max = size[j];
					maxNode = j;
				}
			}

			out.printf("Case %d: %d\n",i,maxNode+1);
		}

		out.flush();
		out.close();
	}

	public static void SCC(int u) {
		dfs_num[u] = dfs_low[u] = ++dfsNumberCounter;
		stack.push(u);

		int v = adjList[u];
		if (dfs_num[v] == 0)
			SCC(v);
		if (!inSCC[v]) 
			dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);

		if (size[v] != 0)
			size[u] = size[v];

		if (dfs_num[u] == dfs_low[u]) {
			Queue<Integer> q = new LinkedList<Integer>();
			int s = 0;
			while(true) {
				int elem = stack.pop();
				q.add(elem);
				s++;
				inSCC[elem] = true;
				if(elem == u)
					break;
			}
			while(!q.isEmpty()) {
				int node = q.remove();
				size[node] += s;
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

		public String Next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(Next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(Next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(Next());
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
