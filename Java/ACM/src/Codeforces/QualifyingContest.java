package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class QualifyingContest {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt(), m = sc.nextInt();
		Region[] arr = new Region[m+1];
		for (int i = 0; i<  n; i++) {
			String name = sc.Next();
			int region = sc.nextInt();
			int score = sc.nextInt();
			
			if (arr[region] == null)
				arr[region] = new Region();
			
			arr[region].add(name, score);
		}
		
		for (int i = 1; i < m+1; i++) {
			if (arr[i].hasTeam()) {
				Player p1 = arr[i].pq.remove();
				Player p2 = arr[i].pq.remove();
				
				out.println(p1.name + " " + p2.name);
			}
			else
				out.println("?");
		}
		
		out.flush();
		out.close();
	}
	
	static class Region {
		PriorityQueue<Player> pq;
		
		public Region() {
			pq = new PriorityQueue<>();
		}
		
		public void add(String name, int score) {
			pq.add(new Player(name, score));
		}
		
		public boolean hasTeam() {
			Player p1 = pq.remove();
			Player p2 = pq.remove();
			if (pq.isEmpty()) {
				pq.add(p1);
				pq.add(p2);
				return true;
			}
			
			Player p3 = pq.remove();
			
			if (p2.score == p3.score)
				return false;
			
			pq.add(p1);
			pq.add(p2);
			pq.add(p3);
			
			return true;
		}
	}
	
	static class Player implements Comparable<Player> {
		String name;
		int score;
		
		public Player(String name, int score) {
			this.name = name;
			this.score = score;
		}

		@Override
		public int compareTo(Player o) {
			return o.score - this.score;
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
