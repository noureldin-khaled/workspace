package Spoj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PiggyBank {
	final static int INF = 25000001;
	static int [][] dp;
	static int[] prices;
	static int[] weight;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int remW = Integer.parseInt(st.nextToken())*(-1) + Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(br.readLine());
			prices = new int[N];
			weight = new int[N];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				prices[j] = Integer.parseInt(st.nextToken());
				weight[j] = Integer.parseInt(st.nextToken());
			}

			dp = new int[N][remW+1];
			for (int j = 0; j < N; j++) 
				Arrays.fill(dp[j], -1);

			int ans = piggyBank(0, remW);
			
			if (ans == INF)
				System.out.println("This is impossible.");
			else 
				System.out.println("The minimum amount of money in the piggy-bank is " + ans + ".");
		}

	}

	public static int piggyBank(int coin,int remW){
		if (remW == 0)
			return 0;
		if (remW < 0)
			return INF;
		if (coin == prices.length && remW > 0)
			return INF;

		if (dp[coin][remW] != -1)
			return dp[coin][remW];

		int take = piggyBank(coin, remW-weight[coin]) + prices[coin];
		int leave = piggyBank(coin+1, remW);

		return dp[coin][remW] = Math.min(take, leave);

	}

}
