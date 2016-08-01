package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PayThePrice {
	static int a[];
	static int n;
	static long dp[][];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		a = new int[300];
		for (int i = 0; i < 300; i++)
			a[i] = i+1;
		n = a.length;
		dp = new long[n+5][1000+5];
		for (int i = 0; i < n+5; i++)
			Arrays.fill(dp[i], -1);
		
		while(sc.Ready()) {
			String[] split = sc.nextLine().split(" ");
			
			int k = Integer.parseInt(split[0]);
			if (split.length == 1) 
				out.println(rec(k, k));
			else if (split.length == 2){
				int l1 = Integer.parseInt(split[1]);
				out.println(rec(k, l1));
			} 
			else {
				int l1 = Integer.parseInt(split[1]), l2 = Integer.parseInt(split[2]);
				out.println(rec(k, l2) - rec(k, l1-1));
			}
		}
		
		out.flush();
		out.close();
	}
	
	static long rec(int remVal, int maxCoins) {
		if (maxCoins < 0 || remVal < 0)
			return 0;
		if (remVal == 0)
			return 1;
		if (maxCoins == 0)
			return 0;
		if (dp[remVal][maxCoins] != -1)
			return dp[remVal][maxCoins];
		
		long choice1 = rec(remVal-maxCoins, maxCoins);
		long choice2 = rec(remVal, maxCoins-1);
		
		return dp[remVal][maxCoins] = choice1 + choice2;
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
