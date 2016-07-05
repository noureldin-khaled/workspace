package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NPHardProblem {
	static ArrayList<Integer>[] adjlist;
	static int[] color;
	static boolean[] visited;
	static int N;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int m = sc.nextInt();
		adjlist = new ArrayList[N];
		for (int i = 0; i < N; i++)
			adjlist[i] = new ArrayList<>();
		
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt()-1, v = sc.nextInt()-1;
			adjlist[u].add(v);
			adjlist[v].add(u);
		}
		
		color = new int[N];
		visited = new boolean[N];
		Arrays.fill(color, -1);
		boolean valid = true;
		for (int i = 0; i < N && valid; i++) 
			if (!visited[i] && !isBipartite(i))
				valid = false;
		
		if (valid) {
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			int one = 0;
			int two = 0;
			for (int i = 0; i < N; i++) {
				if (color[i] == 0) {
					one++;
					sb1.append((i+1) + " ");
				}
				else {
					two++;
					sb2.append((i+1) + " ");
				}
			}
			System.out.println(one);
			System.out.println(sb1);
			System.out.println(two);
			System.out.println(sb2);
		}
		else
			System.out.println(-1);
	}
	
	public static boolean isBipartite(int s) {;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		color[s] = 0;

		while(!q.isEmpty()){
			int parent = q.remove();
			visited[parent] = true;
			for (int child : adjlist[parent]) {
				if (color[child] == color[parent])
					return false;

				if (color[child] == -1)
					color[child] = 1 - color[parent];	

				if (!visited[child])
					q.add(child);
			}
		}

		return true;
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
