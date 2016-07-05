package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Conformity {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while(true) {
			int n = sc.nextInt();
			if (n == 0) break;

			TreeMap<Combination, Integer> tm = new TreeMap<>();
			for (int i = 0; i < n; i++) {
				int c[] = new int[5];
				for (int j = 0; j < 5; j++)
					c[j] = sc.nextInt();
				Arrays.sort(c);

				Combination comb = new Combination(c[0], c[1], c[2], c[3], c[4]);
				if (tm.containsKey(comb)) {
					int count = tm.get(comb);
					tm.put(comb, count+1);
				}
				else
					tm.put(comb, 1);
			}
			
			int max = 0;
			for (Entry<Combination, Integer> entry : tm.entrySet())  
				max = Math.max(entry.getValue(), max);
			
			int ans = 0;
			for (Entry<Combination, Integer> entry : tm.entrySet())  
				if (entry.getValue() == max)
					ans += entry.getValue();
		
			out.println(ans);
		}

		out.flush();
		out.close();
	}

	static class Combination implements Comparable<Combination> {
		int c1, c2, c3, c4, c5;

		public Combination(int c1, int c2, int c3, int c4, int c5) {
			this.c1 = c1;
			this.c2 = c2;
			this.c3 = c3;
			this.c4 = c4;
			this.c5 = c5;

		}
		@Override
		public int compareTo(Combination o) {
			if (Integer.compare(c1, o.c1) != 0)
				return Integer.compare(c1, o.c1);
			if (Integer.compare(c2, o.c2) != 0)
				return Integer.compare(c2, o.c2);
			if (Integer.compare(c3, o.c3) != 0)
				return Integer.compare(c3, o.c3);
			if (Integer.compare(c4, o.c4) != 0)
				return Integer.compare(c4, o.c4);
			return Integer.compare(c5, o.c5);
		}
		
		@Override
		public String toString() {
			return c1 + " " + c2 + " " + c3 + " " + c4 + " " + c5;
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
