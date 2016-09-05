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

public class AntennaPlacement {
	static ArrayList<Integer> adjlist[];
	static int n, m, h, w;
	static int match[];
	static final int dx[] = {-1,0,1, 0};
	static final int dy[] = { 0,1,0,-1};

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		while(t-->0) {
			h = sc.nextInt();
			w = sc.nextInt();
			int total = 0;
			char grid[][] = new char[h][w];
			for (int i = 0; i < h; i++) {
				String line = sc.next();
				for (int j = 0; j < w; j++) {
					grid[i][j] = line.charAt(j);
					if (grid[i][j] == '*')
						total++;
				}
			}

			ArrayList<Node> a1 = new ArrayList<>();
			ArrayList<Node> a2 = new ArrayList<>();
			
			Queue<Node> q = new LinkedList<Node>();
			boolean visited[][] = new boolean[h][w];
			visited[0][0] = true;
			q.add(new Node(0, 0, false));
			while(!q.isEmpty()) {
				Node cur = q.remove();
				if (!cur.c)
					a1.add(cur);
				else
					a2.add(cur);
				for (int k = 0; k < 4; k++) {
					int newI = cur.i + dx[k];
					int newJ = cur.j + dy[k];

					if (valid(newI, newJ) && !visited[newI][newJ]) {
						visited[newI][newJ] = true;
						q.add(new Node(newI, newJ, !cur.c));
					}
				}
			}
			
			n = a1.size();
			m = a2.size();
			
			adjlist = new ArrayList[n+5];
			for (int i = 0; i < n+5; i++)
				adjlist[i] = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				Node cur = a1.get(i);
				if (grid[cur.i][cur.j] != '*') continue;
				for (int j = 0; j < m; j++) {
					Node other = a2.get(j);
					if (grid[other.i][other.j] != '*') continue;
					if (adjacent(cur, other))
						adjlist[i].add(j);
				}
			}
			
			out.println(total - MCBM());
		}

		out.flush();
		out.close();
	}
	
	static boolean adjacent(Node cur, Node other) {
		return (cur.i == other.i && cur.j+1 == other.j) || (cur.i == other.i && cur.j-1 == other.j) || (cur.i+1 == other.i && cur.j == other.j) || (cur.i-1 == other.i && cur.j == other.j);
	}

	static boolean valid(int i, int j) {
		return i >= 0 && i < h && j >= 0 && j < w;
	}

	static boolean visited[];
	static int MCBM() {
		//build unweighted bipartite graph with directed edges left->right set

		int matches = 0;
		match = new int[m];
		Arrays.fill(match, -1);

		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			matches += aug(i);
		}

		return matches;
	}

	static int aug(int u) { 	// returns 1 if augmented path is found
		if (visited[u])
			return 0;

		visited[u] = true;
		for (int v : adjlist[u])
			if (match[v] == -1 || aug(match[v]) == 1) {
				match[v] = u;
				return 1;
			}

		return 0;
	}

	static class Node {
		int i, j;
		boolean c;
		public Node(int i, int j, boolean c) {
			this.i = i;
			this.j = j;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "(" + i + ", " + j + ")";
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
