package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SoldierAndCards {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int k1 = sc.nextInt();
		LinkedList<Integer> first = new LinkedList<>();
		for (int j = 0; j < k1; j++)
			first.addLast(sc.nextInt());
		
		
		int k2 = sc.nextInt();
		LinkedList<Integer> second = new LinkedList<>();
		for (int j = 0; j < k2; j++)
			second.addLast(sc.nextInt());
		
		for (int i = 0; i <= 5000000; i++) {
			if (first.isEmpty()) {
				System.out.println(i + " " + 2);
				return;
			}
			if (second.isEmpty()) {
				System.out.println(i + " " + 1);
				return;
			}
			
			int s1 = first.removeFirst();
			int s2 = second.removeFirst();
			
			if (s1 > s2) {
				first.addLast(s2);
				first.addLast(s1);
			}
			else {
				second.addLast(s1);
				second.addLast(s2);
			}
		}
		
		System.out.println(-1);
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
