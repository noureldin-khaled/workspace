package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HelpingFillBates {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		String line = sc.nextLine();
		int m = sc.nextInt();
		int n = line.length();

		Pair[] arr = new Pair[n];
		for (int i = 0; i < n; i++)
			arr[i] = new Pair(line.charAt(i), i);
		Arrays.sort(arr);
		while(m-->0) {
			String s = sc.nextLine();

			int min = 1000001, max = -1;
			boolean valid = true;
			int prev = -1;
			for (int i = 0; i < s.length(); i++) {
				char cur = s.charAt(i);
				int low = 0;
				int high = n-1;
				int ans = -1;
				
				while(low <= high) {
					int mid = low + (high-low)/2;

					if (arr[mid].c == cur) {
						if (arr[mid].index <= prev)
							low = mid+1;
						else {
							ans = mid;
							high = mid-1;
						}
					}
					else if (arr[mid].c > cur)
						high = mid-1;
					else
						low = mid+1;
				}

				if (ans == -1) {
					valid = false;
					break;
				}
				prev = arr[ans].index;
				min = Math.min(min, arr[ans].index);
				max = Math.max(max, arr[ans].index);
			}

			out.println(valid ? "Matched " + min + " " + max : "Not matched");
		}
		out.flush();
		out.close();
	}

	static class Pair implements Comparable<Pair> {
		char c;
		int index;
		public Pair(char c, int i) {
			this.c = c;
			index = i;
		}

		@Override
		public int compareTo(Pair o) {
			if (c != o.c)
				return c > o.c ? 1 : -1;
				if (index != o.index)
					return index > o.index ? 1 : -1;
					return 0;
		}

		@Override
		public String toString() {
			return "(" + c + ", " + index + ")";
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
