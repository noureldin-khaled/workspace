package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MakingChange {
	static final int a[] = {5, 10, 20, 50, 100, 200};
	static int b[];
	static final int INF = (int)1e9;
	static int target;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true) {
			b = new int[6];
			int s = 0;
			for (int i = 0; i < 6; i++) {
				int v = sc.nextInt();
				b[i] = v;
				s += v;
			}
			
			if (s == 0) break;
			target = (int) Math.round(sc.nextDouble() * 100);
			
			dp2 = new int[10][10000];
			for (int i = 0; i < 10; i++)
				Arrays.fill(dp2[i], -1);
			dp1 = new int[10][10000];
			for (int i = 0; i < 10; i++)
				Arrays.fill(dp1[i], -1);
			
			int ans = rec1(0, 0);
			String l = ans+"";
			for (int i = 2-l.length(); i >= 0; i--)
				out.print(" ");
			out.println(ans);
		}
		
		out.flush();
		out.close();
	}
	
	static int dp1[][];
	static int rec1(int idx, int soFar) {
		if (idx >= 6) 
			return rec2(0, soFar - target);
		if (dp1[idx][soFar] != -1)
			return dp1[idx][soFar];
		
		int ans = INF;
		for (int i = 0; i <= b[idx]; i++)
			ans = Math.min(ans, i + rec1(idx+1, soFar + (i*a[idx])));
		return dp1[idx][soFar] = ans;
	}
	
	static int dp2[][];
	static int rec2(int idx, int rem) {
		if (rem == 0)
			return 0;
		if (idx >= 6 || rem < 0)
			return INF;
		if (dp2[idx][rem] != -1)
			return dp2[idx][rem];
		
		int take = rec2(idx, rem-a[idx]) + 1;
		int leave = rec2(idx+1, rem);
		
		return dp2[idx][rem] = Math.min(take, leave);
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
