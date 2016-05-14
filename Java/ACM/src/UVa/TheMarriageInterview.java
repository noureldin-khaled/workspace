package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class TheMarriageInterview {
	static BigInteger dp[];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = 1;
		while(true) {
			int n = sc.nextInt();
			int back = sc.nextInt();
			
			if (n > 60) break;
			
			int size = n+5 < 0 ? 0 : n + 5;
			dp = new BigInteger[size];
			for (int i = 0; i < size; i++)
				dp[i] = new BigInteger("-1");
			
			out.printf("Case %d: %d\n", t++, rec(n, back).add(BigInteger.ONE));
		}	
		
		out.flush();
		out.close();
	}
	
	
	
	public static BigInteger rec(int n, int back) {
		if (n <= 1)
			return BigInteger.ZERO;
		
		if (dp[n].compareTo(BigInteger.valueOf(-1)) != 0)
			return dp[n];
		
		BigInteger ans = BigInteger.ZERO;
		for (int i = 1; i <= back; i++) 
			ans = ans.add(rec(n-i, back));
		
		return dp[n] = ans.add(BigInteger.valueOf(back >= 0 ? back : 0));
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
