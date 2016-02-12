package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LongtailHedgehog {
    static ArrayList<Integer> arr[];
    static int dp[];

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());

	arr = new ArrayList[n];
	for (int i = 0; i < n; i++) 
	    arr[i] = new ArrayList<>();

	for (int i = 0; i < m; i++) {
	    st = new StringTokenizer(br.readLine());
	    int first = Integer.parseInt(st.nextToken())-1;
	    int second = Integer.parseInt(st.nextToken())-1;

	    arr[first].add(second);
	    arr[second].add(first);
	}
	
	long ans = 0;
	
	dp = new int[n];
	Arrays.fill(dp, -1);
	
	for (int i = n-1; i >= 0; i--) {
	    ans = Math.max(ans, (long)dfs(i)*arr[i].size());
	}

	out.println(ans);

	out.flush();
	out.close();
    }

    public static int dfs(int node) {
	if (dp[node] != -1)
	    return dp[node];
	
	int max = 1;
	for (int i = 0; i < arr[node].size(); i++) {
	    int dest = arr[node].get(i);
	    if (dest < node) {
		int cur = dfs(dest) + 1;
		max = Math.max(cur, max);
	    }
	}
	
	return dp[node] = max;
    }

}
