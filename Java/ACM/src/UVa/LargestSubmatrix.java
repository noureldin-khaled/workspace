package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LargestSubmatrix {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		sc.nextLine();
		while(t-->0) {
			int a[][] = new int[25][25];
			int i = 0;
			while(sc.Ready()) {
				String s = sc.nextLine();
				if (s.isEmpty()) break;
				for (int j = 0; j < s.length(); j++) 
					a[i][j] = s.charAt(j) - '0';
				i++;
			}
			
			int n = i;
			int[][] commulative = new int[n][n];

			for(i = 0; i < n; i++) 
				for (int j = 0; j < n; j++) {
					commulative[i][j] = a[i][j];

					if (i > 0)
						commulative[i][j] += commulative[i-1][j];
					if (j > 0)
						commulative[i][j] += commulative[i][j-1];
					if (i > 0 && j > 0)
						commulative[i][j] -= commulative[i-1][j-1];
				}
			
			int ans = 0;
			for (i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					for (int k = i; k < n; k++)
						for (int l = j; l < n; l++) {
							int sub = commulative[k][l];
							if (i > 0) sub -= commulative[i-1][l];
							if (j > 0) sub -= commulative[k][j-1];
							
							if (i > 0 && j > 0) sub += commulative[i-1][j-1];
							int length = k-i+1;
							int width = l-j+1;
							if (sub == length * width)
								ans = Math.max(ans, sub);
						}
			
			out.println(ans);
			if (t > 0)
				out.println();
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
