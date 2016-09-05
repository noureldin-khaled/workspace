package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FreeParentheses {
	static int n;
	static int[] a, sign;
	static boolean[][][] visited;
	static boolean[] used;
	static final int OFF = 3000;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		sc.waitForInput(3000);
		while(sc.Ready()) {
			String s = sc.nextLine();
			StringTokenizer st = new StringTokenizer(s);
			
			a = new int[35];
			sign = new int[35];
			
			int i = 0;
			while(st.hasMoreTokens()) {
				String t = st.nextToken();
				if (t.equals("-")) 
					sign[i] = -1;
				else if (t.equals("+"))
					sign[i] = 1;
				else {
					a[i] = Integer.parseInt(t);
					i++;
				}
			}
			n = i;
			
			sign[0] = 1;
			visited = new boolean[35][35][10000];
			used = new boolean[10000];
			rec(0, 0, 0);
			
			int ans = 0;
			for (i = 0; i < 10000; i++)
				if (used[i])
					ans++;
			
			out.println(ans);
		}
		
		out.flush();
		out.close();
	}
	
	static void rec(int idx, int open, int soFar) {
		if (visited[idx][open][soFar + OFF]) return;
		
		visited[idx][open][soFar + OFF] = true;
		
		if (idx == n) {
			used[soFar + OFF] = true;
			return;
		}
			
		int newVal = soFar + a[idx] * sign[idx] * (open%2 == 0 ? 1 : -1);
		if (sign[idx] == -1)
			rec(idx+1, open+1, newVal);
		if (open > 0)
			rec(idx+1, open-1, newVal);
		rec(idx+1, open, newVal);
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
