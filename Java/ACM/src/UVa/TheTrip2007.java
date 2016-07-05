package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheTrip2007 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = 1;
		while(true) {
			int n = sc.nextInt();
			if (n == 0) break;

			if (t > 1)
				out.println();
			Integer arr[] = new Integer[n];
			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();

			Arrays.sort(arr);

			ArrayList<Integer> res[] = new ArrayList[n];
			for (int i = 0; i < n; i++)
				res[i] = new ArrayList<Integer>();
			int prev = -1;
			int index = 0;
			int maxIndex = -1;
			for (int i = 0; i < n; i++) {
				if (arr[i] != prev)
					index = 0;

				res[index].add(arr[i]);
				maxIndex = Math.max(maxIndex, index);
				index++;
				prev = arr[i];
			}
			int k = maxIndex+1;
			
			out.println(k);
			for (int i = 0; i < k; i++) {
				for (int j = i; j < n; j+=k) {
					if (j > i)
						out.print(" ");
					out.print(arr[j]);
				}
				out.println();
			}

			t++;
		}

		out.flush();
		out.close();
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
