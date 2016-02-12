package Testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DP {
	static long dp[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dp = new long[n+1];
		Arrays.fill(dp, -1);
		long ans = fib(n);
		System.out.println(ans);
	}

	public static long fib(int n) {
		if (n == 0 || n == 1)
			return n;
		
		if (dp[n] != -1)
			return dp[n];
		return dp[n] = fib(n-1) + fib(n-2);
	}

}
