package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kString {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int k = sc.nextInt();
		char[] line = sc.nextLine().toCharArray();

		int occ[] = new int[26];
		for (int i = 0; i < line.length; i++) 
			occ[line[i] - 'a']++;

		for (int i = 0; i < 26; i++) {
			if (occ[i] > 0) {
				if (occ[i]%k != 0) {
					System.out.println(-1);
					return;
				}
			}
		}

		int factors[] = new int[26];
		for (int i = 0; i<  26; i++)
			factors[i] = occ[i]/k;
		
		while(true) {
			boolean done = true;
			for (int i = 0; i < 26; i++) {
				if (occ[i] > 0) {
					done = false;
					for (int j = 0; j < factors[i]; j++) {
						sb.append(Character.toString((char) (i + 'a')));
						occ[i]--;
					}
				}
			}

			if (done)
				break;
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
