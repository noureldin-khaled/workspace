package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Team_401 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt(), m = sc.nextInt();
		
		if (n > m + 1) 
			sb.append("-1");
		else if (n == m + 1) {
			for (int i = 0; i < m; i++)
				sb.append("01");
			sb.append("0");
		}
		else {
			while (n > 0 && m > 0) {
				int ratio = m/n;
				
				if (ratio > 2)
					ratio = 2;
				for (int i = 0; i<  ratio; i++) {
					sb.append("1");
					m--;
				}
				
				sb.append("0");
				n--;
			}
			
			if (m > 2) 
				sb = new StringBuilder("-1");
			else
				for (int i = 0; i < m; i++)
					sb.append("1");
		}
		
		System.out.println(sb);
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
