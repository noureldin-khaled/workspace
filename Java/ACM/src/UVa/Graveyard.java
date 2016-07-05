package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Graveyard {
	static final double distance = 10000.0;
	static final double EPS = 1e-9;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(sc.Ready()) {
			int n = sc.nextInt(), m = sc.nextInt();
			
			double p[] = new double[n];
			p[0] = 0.0;
			for (int i = 1; i < n; i++)
				p[i] = p[i-1] + distance/n;
			
			double newP[] = new double[n+m];
			newP[0] = 0.0;
			for (int i = 1; i < n+m; i++)
				newP[i] = newP[i-1] + distance/(n+m);
			
			boolean taken[] = new boolean[n+m];
			double ans = 0.0;
			for (int i = 0; i < n; i++) {
				int index = -1;
				for (int j = 0; j < n+m; j++) {
					if (!taken[j] && (index == -1 || Math.abs(newP[j] - p[i]) + EPS < Math.abs(newP[index] - p[i]))) 
						index = j;
				}
				
				taken[index] = true;
				ans += Math.abs(newP[index] - p[i]);
			}
			
			out.printf("%.4f\n", ans);
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
