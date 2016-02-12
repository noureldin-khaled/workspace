package Spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TreatsForTheCows {
    static int arr[];
    static int n;
    static int dp[][];
    
    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	n = Integer.parseInt(br.readLine());
	arr = new int[n];
	
	for (int i = 0; i < n; i++) 
	    arr[i] = Integer.parseInt(br.readLine());
	
	dp = new int[n][n];
	
	for (int i = 0; i < n; i++) 
	    Arrays.fill(dp[i], -1);
	
	System.out.println(rec(0,n-1));
	
    }

    public static int rec(int i, int j) {
	if (i > j)
	    return 0;
	
	if (dp[i][j] != -1) return dp[i][j];
	
	int age = i+1 + (n-1) - j;
	int left = rec(i+1, j) + arr[i]*age;
	int right = rec(i, j-1) + arr[j]*age;
	
	return dp[i][j] = Math.max(left, right);
    }

}
