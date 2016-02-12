package Testing;

import java.util.Arrays;

public class Knapsack {
	static int w[] = {2, 3, 10, 2, 6};
	static int p[] = {3, 2, 9, 2, 3};
	static int dp[][];
	final static int INF = 1000000;

	public static int f(int i, int rem){
		if (rem < 0)
			return -INF;
		if (rem == 0)
			return 0;
		if (i == w.length)
			return 0;

		if (dp[i][rem] != -1){
			System.out.println("here");
			return dp[i][rem];
		}
		
		int take = f(i+1, rem-w[i]) + p[i];
		int leave = f(i+1, rem);
		
		return dp[i][rem] = Math.max(take, leave);
		
	}
	
	public static void main(String[] args) {
		int n = 5;
		int maxW = 10;
		
		dp = new int[n+1][maxW + 1];
		
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(f(0, maxW));
	}
}
