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

public class DungeonMaster {
	static int n, m, h;	
	static final int dx[] = {-1,0,1,0,0,0};
	static final int dy[] = {0,1,0,-1,0,0};
	static final int dk[] = {0,0,0,0,1,-1};

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while(true) {
			h = sc.nextInt();
			n = sc.nextInt();
			m = sc.nextInt();
			if (h+n+m == 0) break;
			
			char dungeon[][][] = new char[h][n][m];
			Cell st = null;
			Cell tr = null;

			for (int c = 0; c < h; c++)
				for (int i = 0; i < n; i++) {
					String l = sc.next();
					for (int j = 0; j < m; j++) {
						dungeon[c][i][j] = l.charAt(j);
						if (dungeon[c][i][j] == 'S')
						{
							st = new Cell(i, j, c);
							dungeon[c][i][j] = '.';
						}

						if (dungeon[c][i][j] == 'E')
						{
							tr = new Cell(i, j, c);
							dungeon[c][i][j] = '.';
						}
					}
				}	
			
			int dist[][][] = new int[h][n][m];
			for (int i = 0; i < h; i++)
				for (int j = 0; j < n; j++)
					Arrays.fill(dist[i][j], -1);
			
			Queue<Cell> q = new LinkedList<Cell>();
			q.add(st);
			dist[st.k][st.i][st.j] = 0;
			
			while(!q.isEmpty()) {
				Cell cur = q.remove();
				
				if (cur.equals(tr))
					break;
				
				for (int k = 0; k < 6; k++) {
					int newI = cur.i + dx[k];
					int newJ = cur.j + dy[k];
					int newK = cur.k + dk[k];
					
					if (valid(newI, newJ, newK) && dungeon[newK][newI][newJ] == '.' && dist[newK][newI][newJ] == -1) {
						dist[newK][newI][newJ] = dist[cur.k][cur.i][cur.j] + 1;
						q.add(new Cell(newI, newJ, newK));
					}
				}
			}
			
			if (dist[tr.k][tr.i][tr.j] == -1)
				out.println("Trapped!");
			else
				out.printf("Escaped in %d minute(s).\n", dist[tr.k][tr.i][tr.j]);
		}

		out.flush();
		out.close();

	}

	static boolean valid(int i, int j, int k) {
		return i >= 0 && i < n &&  j >= 0 && j < m && k >= 0 && k < h;
	}

	static class Cell {
		int i, j, k;

		public Cell(int i, int j, int k) {
			this.i = i;
			this.j = j;
			this.k = k;
		}
		
		@Override
		public boolean equals(Object obj) {
			Cell o = (Cell) obj;
			return i == o.i && j == o.j && k == o.k;
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
