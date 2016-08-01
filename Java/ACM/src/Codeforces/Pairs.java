package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pairs {
	
	static long[] solve(long[] c) {
		long res[] = new long[5];
		Arrays.fill(res, -1);
		if ((c[0] + c[1] - c[4]) % 2 != 0)
			return res;

		res[0] = (c[0] + c[1] - c[4]) / 2;
		res[1] = c[0] - res[0];
		res[2] = c[1] - res[0];
		res[3] = c[2] - res[0];
		res[4] = c[3] - res[0];
		
		return res;
	}
	
	static boolean isValid(long[] res, long[] c){
		for (int i = 0; i < res.length; i++)
			if (res[i] < 0)
				return false;

		if (res[0] + res[1] == c[0] && res[0] + res[2] == c[1] && res[0] + res[3] == c[2]
				&& res[0] + res[4] == c[3] && res[1] + res[2] == c[4] && res[1] + res[3] == c[5]
						&& res[1] + res[4] == c[6] && res[2] + res[3] == c[7] && res[2] + res[4] == c[8] && res[3] + res[4] == c[9])
			return true;
		return false;
	}

	
	static boolean nextPerm(long[] arr){
		int length = arr.length;
		int i = length - 2;
		for (; i >= 0; i--) {
			if (arr[i] < arr[i+1]){
				break;
			}
		}

		if (i == -1)
			return false;

		for (int j = length - 1; j > i; j--) {
			if (arr[j] > arr[i]){
				long tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
				break;
			}
		}

		int s = i+1;
		int e = length -1;

		while (s < e){
			long tmp = arr[s];
			arr[s] = arr[e];
			arr[e] = tmp;
			s++;
			e--;
		}

		return true;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pr = new PrintWriter(System.out);
		int T = sc.nextInt();
		int tc = 1;
		while (T-- > 0) {
			long[] c = new long[10];
			for (int i = 0; i < 10; i++)
				c[i] = sc.nextLong();

			Arrays.sort(c);
			pr.printf("Case %d:", tc++);
			do {
				long b[] = solve(c);
				if (isValid(b, c)) {
					Arrays.sort(b);
					for (int i = 0; i < b.length; i++) {
						pr.print(" ");
						pr.print(b[i]);
					}
					pr.println();
					break;
				}

				
			} while (nextPerm(c));
		}
		pr.flush();
		pr.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}