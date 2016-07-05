package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ExtrapolationUsingaDifferenceTable {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while(true) {
			int n = sc.nextInt();
			if (n == 0) break;

			int in[] = new int[n];
			for (int i = 0; i < n; i++)
				in[i] = sc.nextInt();

			long arr[] = new long[n];
			for (int i = 1; i <= n; i++) {
				int tmp[] = new int[n-i];
				int k = 0;
				for (int j = 0; j < n-i; j++) 
					tmp[k++] = in[j+1] - in[j];
				arr[i-1] = in[k];
				in = tmp.clone();
			}

			int k = sc.nextInt();
			for (int r = 0; r < k; r++) {
				long val = arr[n-1];
				for (int i = n-2; i >= 0; i--) {
					arr[i] = val + arr[i];
					val = arr[i];
				}
			}

			out.printf("Term %d of the sequence is %d\n", n+k, arr[0]);
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
