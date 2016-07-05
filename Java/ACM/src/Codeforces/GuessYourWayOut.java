package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GuessYourWayOut {
	static long n;
	static int height;
	static final int L = 0;
	static final int R = 1;
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		height = sc.nextInt();
		n = sc.nextLong();
		
		System.out.println(rec(height, L));
	}
	
	public static long rec(int h, int inst) {
		if (h == 0) return 0;
		
		long half = ((long)1 << h);
		half /= 2;
		if (n <= half) { // exit on left
			if (inst == L) 
				return rec(h-1, R) + 1;
			else {
				long nodes =  ((((long)1 << (h+1)) - 1) / 2);

				return rec(h-1, R) + nodes + 1;
			}
		}
		else { // exit on right
			if (inst == L) {
				long nodes = ((((long)1 << (h+1)) - 1) / 2);
				n -= half;
				return rec(h-1, L) + nodes + 1;
			}
			else {
				n -= half;
				return rec(h-1, L) + 1;
			}
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
