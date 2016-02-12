package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Dollars {
    static final int arr[] = {10000,5000,2000,1000,500,200,100,50,20,10,5};
    static long dp[][];

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	dp = new long[14][30005];
	for (int i = 0; i < 13; i++) 
	    Arrays.fill(dp[i], -1);
	

	while(true) {
	    String line = br.readLine();
	    if (line.equals("0.00")) break;
	
	    double temp2 = Math.round(Double.parseDouble(line)*100);
	    int num = (int) temp2;
	    long ans = rec(0, num);

	    for (int i = 0; i < 6-line.length(); i++) 
		out.print(' ');
	    out.print(line);
	    
	    String ansTemp = ans + "";
	    for (int i = 0; i < 17 - ansTemp.length(); i++) 
		out.print(' ');
	    
	    out.println(ans);
	}

	out.flush();
	out.close();
    }

    public static long rec(int index, int remSum) {
	if (remSum == 0)
	    return 1;
	if (remSum < 0 || index >= arr.length)
	    return 0;

	if (dp[index][remSum] != -1) return dp[index][remSum];

	long take = rec(index, remSum - arr[index]);
	long leave = rec(index+1, remSum);

	return dp[index][remSum] = take + leave;
    } 

}
