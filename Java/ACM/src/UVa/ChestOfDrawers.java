package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ChestOfDrawers {
	static int n, s;
	static BigInteger dp[][][];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true) {
			n = sc.nextInt();
			s = sc.nextInt();

			if (n < 0 && s < 0) break;
			
			dp = new BigInteger[n + 5][s + 5][5];
			for (int i = 0; i < n+5; i++) 
				for (int j = 0; j < s+5; j++) 
					for (int k = 0; k < 5; k++) 
						dp[i][j][k] = BigInteger.valueOf(-1);
			
			out.println(rec(0, 0, 1));
		}
		
		out.flush();
		out.close();
	}
	
	public static BigInteger rec(int index, int secured, int above) {
		if (secured > s)
			return BigInteger.ZERO;
		if (index == n) {
			if (secured == s)
				return BigInteger.ONE;
			else
				return BigInteger.ZERO;
		}
		
		if (dp[index][secured][above].compareTo(BigInteger.valueOf(-1)) != 0)
			return dp[index][secured][above];
		
		BigInteger lock = rec(index + 1, above == 1 ? secured + 1 : secured, 1);
		BigInteger unlock = rec(index + 1, secured, 0);
		
		return dp[index][secured][above] = lock.add(unlock);
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
