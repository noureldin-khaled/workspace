package UVa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SuperSale {
	final static int INF = -3001;
	static int [][] dp;
	static int[] objectPrices;
	static int[] objectWeight;
	static int[] peopleWeight;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t;i++) {
			int N = Integer.parseInt(br.readLine());
			objectPrices = new int[N];
			objectWeight = new int[N];

			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				objectPrices[j] = Integer.parseInt(st.nextToken());
				objectWeight[j] = Integer.parseInt(st.nextToken());
			}
			int G = Integer.parseInt(br.readLine());
			peopleWeight = new int[G];
			int max = -1;

			for (int j = 0; j < G; j++){
				peopleWeight[j] = Integer.parseInt(br.readLine());
				if (peopleWeight[j] > max)
					max = peopleWeight[j];
			}

			dp = new int[N][max+1];

			int ans = 0;
			for (int j = 0; j < peopleWeight.length; j++) {
				for (int k = 0; k < N; k++) 
					Arrays.fill(dp[k], -1);
				int sol = superScale(0, peopleWeight[j]);
				ans += sol;
			}
			System.out.println(ans);
		}
	}

	public static int superScale(int object,int remW){
		if (remW == 0)
			return 0;
		if (remW < 0)
			return INF;
		if (object == objectPrices.length)
			return 0;

		if (dp[object][remW] != -1)
			return dp[object][remW];

		int take = superScale(object+1, remW-objectWeight[object]) + objectPrices[object];
		int leave = superScale(object+1, remW);

		return dp[object][remW] =  Math.max(take, leave);
	}

}
