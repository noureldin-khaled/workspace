package UVa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class DividingCoins {
	final static int INF = -50001;
	static int [][] dp;
	static int[] coins;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int m = Integer.parseInt(br.readLine());
			coins = new int[m];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) 
				coins[j] = Integer.parseInt(st.nextToken());


			int sum = 0;
			for (int j = 0; j < coins.length; j++) 
				sum += coins[j];

			dp = new int[m][(sum/2)+1];
			for (int j = 0; j < m; j++) 
				Arrays.fill(dp[j], -1);

			int num = dividing(0, sum/2);

			int ans = ((sum/2)-num)*2;
			if ((sum%2) != 0)
				ans += 1;

			System.out.println(ans);		
		}

	}

	public static int dividing(int coin, int halfSum){
		if (halfSum == 0 || (coin == coins.length && halfSum > 0))
			return 0;
		if (halfSum < 0)
			return INF;

		if (dp[coin][halfSum] != -1)
			return dp[coin][halfSum];

		int take = dividing(coin+1, halfSum - coins[coin]) + coins[coin];
		int leave = dividing(coin+1, halfSum);

		return dp[coin][halfSum] = Math.max(take, leave);
	}

}
