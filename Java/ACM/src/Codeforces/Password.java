package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Password {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		String s = sc.next();
		int n = s.length();
		int[] z = z(s);
		TreeSet<Integer> ts = new TreeSet<>();
		int ans = 0;
		for (int i = n-1; i > 0; i--) {
			Integer e = ts.floor(z[i]);
			if (e != null)
				ans = Math.max(ans, e);
			if (z[i] == n - i)
				ts.add(z[i]);
		}

		if (ans == 0)
			out.println("Just a legend");
		else {
			for (int i = 0; i < ans; i++)
				out.append(s.charAt(i));
			out.println();
		}
		
		out.flush();
		out.close();
	}

	static int[] z(String s) {
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
