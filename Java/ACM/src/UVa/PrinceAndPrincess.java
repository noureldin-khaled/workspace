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

public class PrinceAndPrincess {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		for (int c = 1; c <= t; c++) {
			int n = sc.nextInt(), p = sc.nextInt(), q = sc.nextInt();
			Pair A[] = new Pair[p+1];
			ArrayList<Integer> B = new ArrayList<Integer>();
			
			for (int i = 0; i <= p; i++)
				A[i] = new Pair(sc.nextInt(), i);
			
			Arrays.sort(A);
			for (int i = 0; i <= q; i++) {
				int a = sc.nextInt();
				int idx = binarySearch(A, p+1, a);
				if (idx != -1)
					B.add(idx);
			}
			
			
			Integer [] r = B.toArray(new Integer[B.size()]);
			out.printf("Case %d: %d\n", c, LIS(r));
		}
		
		out.flush();
		out.close();
	}
	
	static int LIS(Integer A[]) {
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
		}
		
		return s;
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
	
	static int binarySearch(Pair L[], int size, int key) {
		int low = 0;
		int high = size-1;
		
		while(low <= high) {
			int mid = low + (high-low)/2;
			
			if (L[mid].val == key) 
				return L[mid].index;
			if (L[mid].val < key)
				low = mid+1;
			else
				high = mid-1;
		}
		
		return -1;
	}
	
	static class Pair implements Comparable<Pair> {
		int val, index;
		
		public Pair(int v, int i) {
			val = v;
			index = i;
		}

		@Override
		public int compareTo(Pair o) {
			if (val != o.val)
				return Integer.compare(val, o.val);
			if (index != o.index)
				return Integer.compare(index, o.index);
			return 0;
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
