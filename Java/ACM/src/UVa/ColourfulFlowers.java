package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ColourfulFlowers {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(sc.Ready()) {
			int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
			double s = (double)(a + b + c) / 2;
			double TriangleArea = Math.sqrt(s * (s - a) * (s - b) * (s - c));
			double inscribedCircle = Math.PI * sq(TriangleArea/s);
			double exscribedCircle = Math.PI * sq((a*b*c) / (4.0 * TriangleArea));

			out.printf("%.4f %.4f %.4f\n", exscribedCircle - TriangleArea, TriangleArea - inscribedCircle, inscribedCircle);
		}

		out.flush();
		out.close();
	}

	static double sq(double x) {
		return x * x;
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
