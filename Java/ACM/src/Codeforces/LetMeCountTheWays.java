package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class LetMeCountTheWays {
	final static int []coins = {50,25,10,5,1};
	static long [][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dp = new long[5][31000];
		for (int i = 0; i < dp.length; i++) 
			Arrays.fill(dp[i], -1);
		String line;
		while (br.ready()){
		line = br.readLine();	
		long ans = letMeCount(0, Integer.parseInt(line));
		if (ans == 1)
			System.out.println("There is only 1 way to produce " + line +" cents change.");
		else 
			System.out.println("There are " + ans +" ways to produce " + line + " cents change.");
		}
	}
	
	public static long letMeCount(int coin,int remMoney){
		if (remMoney == 0)
			return 1;
		if (remMoney < 0)
			return 0;
		if (coin == coins.length)
			return 0;
		
		if (dp[coin][remMoney] != -1)
			return dp[coin][remMoney];
		
		long take = letMeCount(coin, remMoney-coins[coin]);
		long leave = letMeCount(coin+1, remMoney);
		
		return dp[coin][remMoney] = take + leave;
	}

}
