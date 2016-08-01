package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RotatedSquare {
	static int N, n;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true) {
			N = sc.nextInt();
			n = sc.nextInt();
			if (N+n == 0) break;
			
			char A[][] = new char[N][N];
			char a[][][] = new char[4][n][n];
			
			for (int i = 0; i < N; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < N; j++)
					A[i][j] = line.charAt(j);
			}
			
			for (int i = 0; i < n; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < n; j++)
					a[0][i][j] = line.charAt(j);
			}
			
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					a[1][j][n-i-1] = a[0][i][j];
					a[2][n-i-1][n-j-1] = a[0][i][j];
					a[3][n-j-1][i] = a[0][i][j];
					
				}
			
			for (int i = 0; i < 4; i++) {
				if (i > 0)
					out.print(" ");
				
				out.print(count(A, a, i));
			}
			
			out.println();
		}
		
		out.flush();
		out.close();
	}
		
	static int count(char[][] A, char[][][] a, int k) {
		int res = 0;
		for (int i = 0; i <= N-n; i++)
			for (int j = 0; j <= N-n; j++) {
				boolean matched = true; 
				for (int r = 0; r < n && matched; r++)
					for (int c = 0; c < n && matched; c++)
						if (A[i+r][j+c] != a[k][r][c])
							matched = false;
				if (matched)
					res++;
			}
		
		return res;
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
