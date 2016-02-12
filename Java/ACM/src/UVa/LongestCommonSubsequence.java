package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class LongestCommonSubsequence {
	static int firstLength;
	static int secondLength;
	static String first;
	static String second;
	static int[][]dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(br.ready()){
			first = br.readLine();
			second = br.readLine();
			firstLength = first.length();
			secondLength = second.length();
			
			dp = new int[firstLength][secondLength];
			for (int i = 0; i < dp.length; i++) 
				Arrays.fill(dp[i], -1);
			
			out.println(longest(0, 0));
		}
		out.flush();
		out.close();
	}
	
	public static int longest(int i,int j){
		if (i == firstLength || j == secondLength)
			return 0;
		
		if (dp[i][j] != -1)
			return dp[i][j];
		
		if (first.charAt(i) == second.charAt(j))
			return dp[i][j] = longest(i+1, j+1) + 1;
		
		int firstmove = longest(i+1, j);
		int secondmove = longest(i, j+1);
		
		return dp[i][j] = Math.max(firstmove, secondmove);
		
		
	}

}
