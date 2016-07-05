package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ThePathInTheColoredField {
	static int grid[][];
	static int m;
	static final int dx[] = {1,0,-1,0};
	static final int dy[] = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while(sc.Ready()) {
			m = sc.nextInt();
			grid = new int[m][m];
			
			for (int i = 0; i < m; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < m; j++)
					grid[i][j] = line.charAt(j) - '0';
			}
			
			int ans = 0;
			for (int i = 0; i < m; i++) 
				for (int j = 0; j < m; j++) 
					if (grid[i][j] == 1) 
						ans = Math.max(ans, bfs(i, j));
			
			out.println(ans);
		}

		out.flush();
		out.close();
	}

	public static int bfs(int i, int j) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(i, j));
		int dist[][] = new int[m][m];
		for (int k = 0; k < m; k++)
			Arrays.fill(dist[k], -1);
		
		dist[i][j] = 0;
		while(!q.isEmpty()) {
			Pair parent = q.remove();
			if (grid[parent.i][parent.j] == 3) 
				return dist[parent.i][parent.j];
			for (int k = 0; k < 4; k++) {
				int newI = parent.i + dx[k];
				int newJ = parent.j + dy[k];

				if (valid(newI, newJ) && dist[newI][newJ] == -1){
					dist[newI][newJ] = dist[parent.i][parent.j] + 1;
					q.add(new Pair(newI, newJ));
				}
			}
		}
		
		return 0;
	}
	
	public static boolean valid(int i, int j) {
		return i >= 0 && i < m && j >= 0 && j < m;
	}
	
	static class Pair {
		int i, j;
		
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
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
