package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class ShaassAndLights {
	static final int MOD = (int)1e9 + 7;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		
		BigInteger f[] = new BigInteger[n+1];
		f[0] = BigInteger.ONE;
		for (int i = 1; i <= n; i++)
			f[i] = f[i-1].multiply(BigInteger.valueOf(i));
		
		boolean on[] = new boolean[n];
		for (int i = 0; i < m; i++)
			on[sc.nextInt()-1] = true;
		
		int arr[] = new int[m+1];
		int count = 0;
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (!on[i])
				count++;
			else {
				arr[k++] = count;
				count = 0;
			}
		}
		arr[k] = count;
				
		BigInteger res = f[n-m];
		for (int i = 0; i < m+1; i++)
			res = res.divide(f[arr[i]]);
		
		for (int i = 1; i < m; i++)
			res = res.multiply(BigInteger.valueOf(2).pow(Math.max(0,arr[i]-1)));
		System.out.println(res.mod(BigInteger.valueOf(MOD)));
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
