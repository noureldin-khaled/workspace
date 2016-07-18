package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ReversePrime {
	static int size;
	static boolean[] bs;
	static ArrayList<Integer> primes;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		primes = new ArrayList<>();
		sieve(1000001);
		ArrayList<Integer> al = new ArrayList<>();
		
		for (int i = 2; i < 1000000; i++) {
			if (bs[i]) {
				StringBuilder s = new StringBuilder(i+"");
				StringBuilder r = s.reverse();
				for (int j = 6-s.length(); j >= 0; j--)
					r.append("0");
				al.add(Integer.parseInt(r.toString()));
			}	
		}
		
		Collections.sort(al);
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		int n = al.size();
		long a[] = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = numPF(al.get(i));
			tm.put(al.get(i), i+1);
		}
		
		long arr[] = new long[n];
		Arrays.fill(arr, 1);
		FenwickTree f = new FenwickTree(n, a);
		FenwickTree fix = new FenwickTree(n, arr);
		
		while(sc.Ready()) {
			char c = sc.next().charAt(0);
			int num = sc.nextInt();
			
			if (c == 'q') {
				num++;
				int low = 1;
				int high = n;
				
				while(low <= high) {
					int mid = low + (high-low)/2;
					long r = fix.rsq(mid);
					
					if (r == num) {
						out.println(f.rsq(mid));
						break;
					}
					else if (r > num)
						high = mid-1;
					else
						low = mid+1;
				}
			}
			else {
				int idx = tm.get(num);
				f.update_point_new(idx, 0);
				fix.update_point_new(idx, 0);
			}
		}
		
		out.flush();
		out.close();
	}

	static void sieve(int upperbound) {
		size = upperbound+1;
		bs = new boolean[size];
		Arrays.fill(bs, true);
		bs[0] = bs[1] = false;

		for (long i = 2; i < size; i++) 
			if (bs[(int) i]) {
				for (long j = i*i; j < size; j+=i) 
					bs[(int) j] = false;
				primes.add((int) i);
			}
	}
	
	static long numPF(long N) {
		int PF_idx = 0;
		long PF = primes.get(PF_idx), ans = 0;
		while(N != 1 && (PF * PF <= N)) {
			while(N % PF == 0) {
				N /= PF;
				ans++;
			}
			PF = primes.get(++PF_idx);
		}
		
		if (N != 1) 
			ans++;
		return ans;
	}
	
	static class FenwickTree {
		int n;
		long[] ft;
		long[] array;

		public FenwickTree(int n, long[] arr) {
			this.n = n;
			ft = new long[n+1]; // one based.
			array = arr;
			
			for (int i = 0; i < n; i++)
				update_point(i+1, arr[i]);
		}

		// O(log n). Gets the sum from 1 to b.
		public long rsq(int b) {
			long sum = 0;
			while(b > 0) {
				sum += ft[b];
				b -= LSOne(b);
			}

			return sum;
		}

		public long rsq(int l, int r) {
			return rsq(r) - rsq(l-1);
		}

		// O(log n). Update means increment or decrement.
		public void update_point(int k, long val) {
			while(k <= n) {
				ft[k] += val;
				k += LSOne(k);
			}
		}
		
		// New value not increment or decrement.
		public void update_point_new(int k, long newVal) {
			long diff = newVal - array[k-1];
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
