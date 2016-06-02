package UVa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class CoinChange {
	static final int [] coins = {50,25,10,5,1};
	static int [][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		dp = new int[6][8000];
			for (int i = 0; i < dp.length; i++) 
				Arrays.fill(dp[i], -1);
		while (br.ready()) {
			line = br.readLine();
			System.out.println(coinChange(0, Integer.parseInt(line)));
		}
		
		
	}
	
	public static int coinChange(int cent, int remMoney){
		if (remMoney == 0)
			return 1;
		if (remMoney < 0)
			return 0;
		if (cent == coins.length && remMoney > 0)
			return 0;
		
		if (dp[cent][remMoney] != -1)
			return dp[cent][remMoney];
		
		int take = coinChange(cent, remMoney-coins[cent]);
		int leave = coinChange(cent+1, remMoney);
		
		return dp[cent][remMoney] = take + leave;
	}

}
