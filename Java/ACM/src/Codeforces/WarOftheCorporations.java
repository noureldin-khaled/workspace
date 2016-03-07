package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WarOftheCorporations {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		String a = sc.nextLine();
		String b = sc.nextLine();
		
		String cat = b + "#" + a;
		
		int z[] = z(cat);

		int P = b.length();
		int ans = 0;
		int i = 0;
		while(i < z.length) {
			if (z[i] == P) {
				ans++;
				i += P;
			}
			else
				i++;
		}
		System.out.println(ans);
	}

	public static int[] z(String s) {
		int L = 0;
		int R = 0;
		int n = s.length();
		int z[] = new int[n];
		z[0] = -1;

		for (int i = 1; i < n; i++) {
			if (i > R) { // exceeded the Z-box
				L = R = i;
				while(R < n && s.charAt(R-L) == s.charAt(R))
					R++;
				z[i] = R-L;
				R--;
			}
			else {
				int k = i-L;
				if (i + z[k] <= R)
					z[i] = z[k];
				else {
					L = i;
					while (R < n && s.charAt(R-L) == s.charAt(R))
						R++;
					z[i] = R-L;
					R--;
				}
			}
		}
		return z;
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

		public String Next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(Next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(Next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(Next());
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
