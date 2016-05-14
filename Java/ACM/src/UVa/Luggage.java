package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Luggage {
	static int arr[];
	static Boolean dp[][][];
	static int len;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-->0) {
			String[] s = sc.nextLine().split(" ");
			len = s.length;
			arr = new int[len];
			for (int i = 0; i < len; i++)
				arr[i] = Integer.parseInt(s[i]);
			
			dp = new Boolean[len][205][205];
			for (int i = 0; i < len; i++)
				for (int j = 0; j < 205; j++)
					for (int k = 0; k < 205; k++)
						dp[i][j][k] = null;
			
			out.println(rec(0, 0, 0) ? "YES" : "NO");
		}
		
		out.flush();
		out.close();
	}
	
	public static boolean rec(int index, int first, int second) {
		if (index == len)
		{
			if (first == second)
				return true;
			else
				return false;
		}
		
		if (dp[index][first][second] != null)
			return dp[index][first][second];

		return dp[index][first][second] = rec(index + 1, first + arr[index], second) || rec(index + 1, first, second + arr[index]);

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
