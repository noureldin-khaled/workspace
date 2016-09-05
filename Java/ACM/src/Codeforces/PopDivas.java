package Codeforces;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PopDivas {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt(), m = sc.nextInt();
		BigInteger a[] = new BigInteger[1 << n];
		Pair b[] = new Pair[1 << m];

		int inA[] = new int[n];
		int inB[] = new int[m];

		for (int i = 0; i < n; i++)
			inA[i] = sc.nextInt();
		for (int i = 0; i < m; i++)
			inB[i] = sc.nextInt();

		for (int i = 0; i < (1 << n); i++) {
			BigInteger cur = BigInteger.ONE;
			for (int j = 0; j < n; j++)
				if ((i & (1 << j)) != 0)
					cur = cur.multiply(BigInteger.valueOf(inA[j]));
			a[i] = cur;
		}

		for (int i = 0; i < (1 << m); i++) {
			BigInteger cur = BigInteger.ONE;
			for (int j = 0; j < m; j++)
				if ((i & (1 << j)) != 0)
					cur = cur.multiply(BigInteger.valueOf(inB[j]));
			b[i] = new Pair(cur, i);
		}

		Arrays.sort(b);

		boolean done = false;
		for (int i = 1; i < (1 << n) && !done; i++) {
			BigInteger cur = a[i];
			Pair ans = valid(cur, b, (1 << m));
			if (ans == null) continue;
			out.println('Y');
			out.println(Integer.bitCount(i) + " " + Integer.bitCount(ans.idx));
			for (int k = 0; k < n; k++)
				if ((i & (1 << k)) != 0)
					out.print(inA[k] + " ");
			out.println();
			for (int k = 0; k < m; k++)
				if ((ans.idx & (1 << k)) != 0)
					out.print(inB[k] + " ");
			out.println();
			done = true;
		}
		
		if (!done)
			out.println('N');
		out.flush();
		out.close();
	}

	static Pair valid(BigInteger cur, Pair[] b, int size) {
		int low = 1;
		int high = size-1;
		
		while(low <= high) {
			int mid = low + (high-low)/2;
			
			if (b[mid].num.equals(cur))
				return b[mid];
			if (b[mid].num.compareTo(cur) > 0)
				high = mid-1;
			else
				low = mid+1;
		}
		
		return null;
	}

	static class Pair implements Comparable<Pair>{
		BigInteger num;
		int idx;

		public Pair(BigInteger n, int i) {
			num = n;
			idx = i;
		}

		@Override
		public int compareTo(Pair o) {
			if (num.compareTo(o.num) != 0)
				return num.compareTo(o.num) > 0 ? 1 : -1;
				return idx > o.idx ? 1 : -1;
		}

		@Override
		public String toString() {
			return "(" + num + ", " + idx + ")";
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		public String next() throws Exception {
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		public long nextLong() throws Exception {
			return Long.parseLong(next());
		}
	}
}