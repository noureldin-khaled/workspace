package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HowDoYouAdd{
	static int dp[][];
	static final int num = 1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		dp = new int[101][101];
		for (int i = 0; i < dp.length; i++) 
			Arrays.fill(dp[i], -1);
		while(true){
			String line = br.readLine();
			if (line.equals("0 0"))
				break;
			StringTokenizer st = new StringTokenizer(line);
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			out.println(ways(N,K));
			
		}
		out.flush();
		out.close();
	}

	public static int ways(int N,int K){
		if (N < 0)
			return 0;
		if (K == 1)
			return 1;
		
		if (dp[N][K] != -1)
			return dp[N][K];
		int sum = 0;
		for (int i = 0; i <= N; i++) 
			sum += ways(N-i, K-1);

		return dp[N][K] = (sum%num);
	}
}



















