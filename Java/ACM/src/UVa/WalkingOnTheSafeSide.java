package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WalkingOnTheSafeSide {
	static int W;
	static int N;
	static boolean [][] arr;
	static int[][]dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0){
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			 W = Integer.parseInt(st.nextToken());
			 N = Integer.parseInt(st.nextToken());
			
			arr = new boolean[W][N];
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int j = Integer.parseInt(st.nextToken()) - 1;
				while(st.hasMoreTokens())
					arr[j][Integer.parseInt(st.nextToken())-1] = true;
			}
			dp = new int[W][N];
			for (int i = 0; i < dp.length; i++) 
				Arrays.fill(dp[i], -1);
			
			out.println(ways(0,0));
			if (t > 0)
				out.println();
		}
		out.flush();
		out.close();
	}
	
	public static int ways(int x,int y){
		if (x == (W-1) && y == (N-1))
			return 1;
		if (x == W || y == N)
			return 0;
		if (arr[x][y])
			return 0;
		
		if (dp[x][y] != -1)
			return dp[x][y];
		
		int right = ways(x,y+1);
		int down = ways(x+1,y);
		
		return dp[x][y] = right + down;
	}
}
