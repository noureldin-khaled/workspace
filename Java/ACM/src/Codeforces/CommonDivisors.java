package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CommonDivisors {
	static String s1, s2;
	static int n1, n2;
	static int[] z1, z2;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String l1 = sc.nextLine(), l2 = sc.nextLine();
		
		if (l1.length() < l2.length()) {
			s1 = l1;
			s2 = l2;
		}
		else {
			s1 = l2;
			s2 = l1;
		}
		
		n1 = s1.length();
		n2 = s2.length();
		
		z1 = z(s1 + "#" + s1);
		z2 = z(s1 + "#" + s2);
		
		int ans = 0;
		for (int i = 1; i <= n1; i++) 
			if (valid1(i) && valid2(i)) 
				ans++;
		
		System.out.println(ans);
	}
	
	static boolean valid1(int i) {
		if (n1%i != 0) return false;
		
		int idx = n1 - i + n1 + 1;
		int tmp = i;
		while(idx > n1) {
			if (z1[idx] != tmp) return false;
			tmp += i;
			idx -= i;
		}
		
		return true;
	}

	static boolean valid2(int i) {
		if (n2%i != 0) return false;
		
		int idx = n2 - i + n1 + 1;
		int tmp = i;
		while(idx > n1) {
			if (z2[idx] != tmp) return false;
			tmp = Math.min(n1, tmp + i);
			idx -= i;
		}
		
		return true;
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
