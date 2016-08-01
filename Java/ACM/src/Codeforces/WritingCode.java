package Codeforces;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WritingCode {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), b = sc.nextInt(), mod = sc.nextInt();

		int a[] = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = sc.nextInt();

		int dp[][][] = new int[2][m+1][b+1];
		dp[0][0][0] = 1;
		
		int p = 0;
		int c = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= m; j++)
				for (int k = 0; k <= b; k++) {
					dp[c][j][k] = dp[p][j][k];
					if (j > 0 && k-a[i-1] >= 0)
						dp[c][j][k] += dp[c][j-1][k - a[i-1]];
					dp[c][j][k] %= mod;
				}
			c = 1-c;
			p = 1-p;
		}
		
		int ans = 0;
		for (int j = 0; j <= b; j++) {
			ans += dp[p][m][j];
			ans %= mod;
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
