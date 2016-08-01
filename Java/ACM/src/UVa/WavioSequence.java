package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class WavioSequence {
	static int table[][];
	static final int INC = 0;
	static final int DEC = 1;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while(sc.Ready()) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();

			table = new int[2][n];
			LIS(a, INC);
			reverse(a);
			LIS(a, DEC);
			
			int ans = 1;
			for (int i = 0; i < n; i++) {
				int e = 1 + Math.min(table[INC][i], table[DEC][n-i-1])*2;
				if (e%2 != 0)
					ans = Math.max(ans, e);
			}
			
			out.println(ans);
		}

		out.flush();
		out.close();

	}

	static void reverse(int a[]) {
		int n = a.length;
		for (int i = 0; i < n/2; i++) {
			int tmp = a[i];
			a[i] = a[n-i-1];
			a[n-i-1] = tmp;
		}
	}

	static void LIS(int A[], int k) {
		int n = A.length;
		ArrayList<Integer> L = new ArrayList<Integer>();

		int s = 0;
		for (int i = 0; i < n; i++) {
			int pos = binarySearch(L, s, A[i])+1;
			if (pos == s) {
				L.add(A[i]);
				s++;
			}
			else 
				L.set(pos, A[i]);
			
			table[k][i] = pos;
		}
	}

	static int binarySearch(ArrayList<Integer> L, int size, int key) {
		int low = 0;
		int high = size-1;
		int ans = -1;

		while(low <= high) {
			int mid = low + (high-low)/2;

			if (L.get(mid) < key) {
				ans = mid;
				low = mid+1;
			}
			else
				high = mid-1;
		}

		return ans;
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
