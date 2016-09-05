package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class sqrtlogsin {
	static final int MOD = 1000000;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		double log[] = new double[1000001];
		double sq[] = new double[1000001];
		double sin[] = new double[1000001];
		
		for (int i = 0; i <= 1000000; i++)
		{
			log[i] = Math.log(i);
			sq[i] = Math.sqrt(i);
			sin[i] = Math.sin(i);
		}
		
		int x[] = new int[1000001];
		x[0] = 1;
		for (int i = 1; i <= 1000000; i++)
			x[i] = (x[(int) (i - sq[i])] + x[(int) log[i]] + x[(int) (i * Math.pow(sin[i], 2))])%MOD;
		
		while(true)
		{
			int n = sc.nextInt();
			if (n == -1) break;
			
			out.println(x[n]);
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
