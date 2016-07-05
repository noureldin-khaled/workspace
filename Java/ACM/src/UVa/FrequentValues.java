package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class FrequentValues {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while(true) {
			int n = sc.nextInt();
			if (n == 0) break;
			int q = sc.nextInt();

			int arr[] = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();


			ArrayList<Triple> al = new ArrayList<Triple>();
			int st = 1;
			int cur = 1;
			for (int i = 0; i < n-1; i++) {
				if (arr[i] == arr[i+1]) 
					cur++;
				else {
					int en = i+1;
					al.add(new Triple(st, en, cur));
					st = en+1;
					cur = 1;
				}
			}

			al.add(new Triple(st, n, cur));
			int A[] = new int[n];
			TreeSet<Integer> start = new TreeSet<>();
			TreeSet<Integer> end = new TreeSet<>();
			for (int i = 0; i < al.size(); i++) {
				Triple c = al.get(i);
				start.add(c.s);
				end.add(c.e);

				for (int j = c.s-1; j <= c.e-1; j++)
					A[j] = c.val;
			}

			SparseTable sp = new SparseTable(A);
			
			while(q-->0) {
				int l = sc.nextInt(), r = sc.nextInt();
				if (arr[l-1] == arr[r-1]) 
					out.println(r-l+1);
				else {
					int b = end.ceiling(l);
					int a = start.floor(r);
					
					int max = Math.max(b-l+1, r-a+1);
					if (b+1 == a) 
						out.println(max);
					else {
						int between = A[sp.query(b, a-2)];
						out.println(Math.max(max, between));
					}
				}
			}
		}

		out.flush();
		out.close();
	}

	static class Triple {
		int s, e, val;

		public Triple(int s, int e, int val) {
			this.s = s;
			this.e = e;
			this.val = val;
		}
	}

	static class SparseTable {
		int[] A, SpT[];

		public SparseTable(int[] A) {
			this.A = A;
			int n = A.length;
			int k = (int)Math.floor(Math.log(n) / Math.log(2)) + 1;
			SpT = new int[n][k];

			for (int i = 0; i < n; i++)
				SpT[i][0] = i;

			// O(n * log n)
			for (int j = 1; (1 << j) <= n; j++)
				for (int i = 0; i + (1 << j) - 1 < n; i++)
					if (A[SpT[i][j-1]] > A[SpT[i + (1 << (j-1))][j-1]])
						SpT[i][j] = SpT[i][j-1];
					else
						SpT[i][j] = SpT[i + (1 << (j-1))][j-1];
		}

		// O(1)
		public int query(int i, int j) {
			int k = (int)Math.floor(Math.log(j-i+1) / Math.log(2));

			if (A[SpT[i][k]] >= A[SpT[j - (1 << k) + 1][k]])
				return SpT[i][k];
			else
				return SpT[j - (1 << k) + 1][k];
		}
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
