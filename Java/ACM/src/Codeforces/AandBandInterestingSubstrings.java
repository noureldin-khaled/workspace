package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class AandBandInterestingSubstrings {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int values[] = new int[26];
		for (int i = 0; i < 26; i++)
			values[i] = sc.nextInt();
		
		String line = sc.nextLine();
		int len = line.length();
		
		long comm[] = new long[len];
		comm[0] = values[line.charAt(0) - 'a'];
		for (int i = 1; i < len; i++)
			comm[i] = comm[i-1] + values[line.charAt(i)-'a'];
		
		TreeMap<Long, Integer> tms[] = new TreeMap[26];
		for (int i = 0; i < 26; i++)
			tms[i] = new TreeMap<Long, Integer>();
		
		long ans = 0;
		tms[line.charAt(0)-'a'].put(comm[0], 1);
		for (int i = 1; i < len; i++) {
			int c = line.charAt(i) - 'a';
			if (tms[c].containsKey(comm[i-1])) {
				int count = tms[c].get(comm[i-1]);
				ans += count;
			}
			
			if (tms[c].containsKey(comm[i])) {
				int count = tms[c].get(comm[i]);
				tms[c].put(comm[i], count+1);
			}
			else
				tms[c].put(comm[i], 1);
		}

		System.out.println(ans);
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
