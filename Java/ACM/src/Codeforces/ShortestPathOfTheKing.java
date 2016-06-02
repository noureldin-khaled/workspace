package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ShortestPathOfTheKing {
	static final int dx[] = {1,0,-1,0,1,1,-1,-1};
	static final int dy[] = {0,1,0,-1,1,-1,1,-1};
	static final String dir[] = {"U","R","D","L","RU","LU","RD","LD"};
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		String s = sc.nextLine();
		String t = sc.nextLine();
		
		int initX = (s.charAt(1) - '0')-1;
		int initY = s.charAt(0) - 'a';
		
		int destX = (t.charAt(1) - '0')-1;
		int destY = t.charAt(0) - 'a';
		
		boolean visited[][] = new boolean[8][8];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(initX, initY, new ArrayList<String>()));
		visited[initX][initY] = true;
		while(!q.isEmpty()) {
			Node cur = q.remove();
			
			if (cur.i == destX && cur.j == destY) {
				int size = cur.path.size();
				out.println(size);
				for (int i = 0; i < size; i++)
					out.println(cur.path.get(i));
				break;
			}
			
			for (int k = 0; k < 8; k++) {
				int newI = cur.i + dx[k];
				int newJ = cur.j + dy[k];

				if (newI >= 0 && newI < 8 && newJ >= 0 && newJ < 8 && !visited[newI][newJ]){
					ArrayList<String> newPath = (ArrayList<String>) cur.path.clone();
					newPath.add(dir[k]);
					visited[cur.i][cur.j] = true;
					q.add(new Node(newI, newJ, newPath));
				}
			}
		}
		
		
		
		out.flush();
		out.close();
	}
	
	static class Node {
		int i, j;
		ArrayList<String> path;
		
		public Node(int i, int j, ArrayList<String> path) {
			this.i = i;
			this.j = j;
			this.path = path;
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
