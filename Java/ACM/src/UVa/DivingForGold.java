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

public class DivingForGold {
	static int n, w;
	static int values[];
	static int depths[];
	static int dp[][];
	static ArrayList<Pair> path;
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		sc.waitForInput(3000);
		int c = 0;
		while(sc.Ready()) {
			if (c > 0)
				out.print('\n');
			
			int t = sc.nextInt();
			w = sc.nextInt();
			n = sc.nextInt();
			
			values = new int[n+5];
			depths = new int[n+5];

			for (int i = 0; i < n; i++) {
				int d = sc.nextInt();
				int v = sc.nextInt();
				
				depths[i] = d;
				values[i] = v;
			}
			
			dp = new int[n + 5][t + 5];
			for (int i = 0; i < n+5; i++) 
				Arrays.fill(dp[i], -1);
			
			out.println(rec(0, t));
			path = new ArrayList<>();
			print(0, t);
			int size = path.size();
			out.println(size);
			for (int i = 0; i < size; i++)
				out.println(path.get(i));
			
			c++;
			
		}
		
		out.flush();
		out.close();
	}
	
	public static int rec(int index, int remW) {
		if (remW < 0)
			return -INF;
		if (index == n)
			return 0;
		
		if (dp[index][remW] != -1)
			return dp[index][remW];
		
		int time = w*depths[index] + 2*w*depths[index];
		int take = rec(index + 1, remW - time) + values[index];
		int leave = rec(index + 1, remW);
		
		return dp[index][remW] = Math.max(take, leave);
	}
	
	public static void print(int index, int remW) {
		if (remW < 0 || index == n)
			return;
		
		int optimal = rec(index, remW);
		int time = w*depths[index] + 2*w*depths[index];
		if ((rec(index + 1, remW - time) + values[index]) == optimal) {
			path.add(new Pair(depths[index], values[index]));
			print(index + 1, remW - time);
		}
		else 
			print(index + 1, remW);
	}
	
	static class Pair {
		int first;
		int second;
		
		public Pair(int f, int s) {
			first = f;
			second = s;
		}
		
		@Override
		public String toString() {
			return first + " " + second;
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
