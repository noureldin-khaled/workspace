package Testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class t {
	final static long MOD = 1000000007;
	static int n;
	static int k;
	static int d;
	static long dp[][];

	public static void main (String[]args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());;
		d = Integer.parseInt(st.nextToken());;
		dp = new long[200][4];
		for (int i = 0; i < 200; i++)
			Arrays.fill(dp[i], -1);
		
		System.out.println(rec(0, 0)%MOD);
	}
	
	static long rec(int soFar, int valid) {
		if (soFar == n)
			if (valid == 1)
				return 1;
			else
				return 0;
		if (soFar > n)
			return 0;
		
		if (dp[soFar][valid] != -1)
			return dp[soFar][valid];
		long ans = 0;
		for (int i = 1; i <= k; i++) {
			if (i >= d)
				ans = (ans%MOD + rec(soFar+i, 1)%MOD)%MOD;
			else
				ans = (ans%MOD + rec(soFar+i, valid)%MOD)%MOD;
		}
		
		return dp[soFar][valid] = ans%MOD;
	}
}
