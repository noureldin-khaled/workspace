package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Potentiometers {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int tc = 1;
		while(true) {
			int n = sc.nextInt();
			
			if (n == 0) break;
			
			if (tc > 1) out.println();
			
			int arr[] = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			
			FenwickTree ft = new FenwickTree(n, arr);
			
			out.printf("Case %d:\n", tc++);
			while(true) {
				String t = sc.next();
				if (t.equals("END")) break;
				
				if (t.equals("M")) {
					int l = sc.nextInt(), r = sc.nextInt();
					out.println(ft.rsq(l, r));
				}
				else {
					int i = sc.nextInt(), newVal = sc.nextInt();
					ft.update_point_new(i, newVal);
				}
			}
		}
		
		out.flush();
		out.close();
	}
	
	static class FenwickTree {
		int n;
		int[] ft;
		int[] array;

		public FenwickTree(int n, int[] arr) {
			this.n = n;
			ft = new int[n+1]; // one based.
			array = arr;
			
			for (int i = 0; i < n; i++)
				update_point(i+1, arr[i]);
		}

		// O(log n). Gets the sum from 1 to b.
		public int rsq(int b) {
			int sum = 0;
			while(b > 0) {
				sum += ft[b];
				b -= LSOne(b);
			}

			return sum;
		}

		public int rsq(int l, int r) {
			return rsq(r) - rsq(l-1);
		}

		// O(log n). Update means increment or decrement.
		public void update_point(int k, int val) {
			while(k <= n) {
				ft[k] += val;
				k += LSOne(k);
			}
		}
		
		// New value not increment or decrement.
		public void update_point_new(int k, int newVal) {
			int diff = newVal - array[k-1];
			array[k-1] = newVal;
			update_point(k, diff);
		}

		public void scale(int c) {	
			for(int i = 1; i <= n; ++i)	ft[i] *= c;	
		}

		public int LSOne(int i) {
			return i & (-i);
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
