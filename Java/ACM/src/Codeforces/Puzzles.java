package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Puzzles {
    static int dp[][];
    static int [] arr;
    static int n;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	StringTokenizer st = new StringTokenizer(br.readLine());
	n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());

	st = new StringTokenizer(br.readLine());
	arr = new int[m];
	
	for (int i = 0; i < m; i++) 
	   arr[i] = Integer.parseInt(st.nextToken());
	
	Arrays.sort(arr);

	dp = new int[m+1][m+1];
	for (int i = 0; i <m+1; i++) 
	    Arrays.fill(dp[i], -1);

	System.out.println(rec(0,m-1));
    }
    
    public static int rec(int i, int j){
	if (j-i+1 == n)
	    return arr[j] - arr[i];
	
	if (dp[i][j] != -1)
	    return dp[i][j];
	
	int choice1 = rec(i+1, j);
	int choice2 = rec(i, j-1);
	
	return dp[i][j] = Math.min(choice1, choice2);
    }
}
