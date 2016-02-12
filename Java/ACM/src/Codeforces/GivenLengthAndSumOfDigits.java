package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GivenLengthAndSumOfDigits {
    static int m;
    static Boolean dp[][][];
    static Boolean dp2[][][];
    static StringBuilder sb;
    static StringBuilder sb2;

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	StringTokenizer st = new StringTokenizer(br.readLine());
	m = Integer.parseInt(st.nextToken());
	int s = Integer.parseInt(st.nextToken());
	
	if (m == 1 && s == 0) {
	    System.out.println("0 0");
	    return;
	}
	
	dp = new Boolean[m+1][s+5][m+5];
	sb = new StringBuilder();
	boolean ans = rec(0, s, 0);
	
	dp = new Boolean[m+1][s+5][m+5];
	sb2 = new StringBuilder();
	boolean ans2 = rec2(0, s, 0);
	
	if (ans && ans2) {
	    sb2.reverse();
	    sb.reverse();
	    out.println(sb2 + " " + sb);
	}
	else 
	    out.println("-1 -1");

	out.flush();
	out.close();
    }

    public static boolean rec2(int index, int remSum, int noOfDigits) {
	if (!can(m-noOfDigits, remSum))
	    return false;
	if (remSum == 0 && noOfDigits == m) 
	    return true;
	if (remSum < 0 || index == m || noOfDigits == m)
	    return false;

	if (dp[index][remSum][noOfDigits] != null)
	    return dp[index][remSum][noOfDigits];

	int downLimit = 0;
	if (noOfDigits == 0)
	    downLimit++;

	boolean done = false;
	for (int i = downLimit; i <= 9; i++) {
	    boolean take = rec2(index, remSum-i, noOfDigits+1);
	    if (take) {
		done = true;
		sb2.append(i);
		break;
	    }
	    boolean leave = rec2(index+1,remSum, noOfDigits);
	    if (leave) {
		done = true;
		break;
	    }
	}

	return dp[index][remSum][noOfDigits] = done;
    }

    public static boolean rec(int index, int remSum, int noOfDigits) {
	if (!can(m-noOfDigits, remSum))
	    return false;
	if (remSum == 0 && noOfDigits == m) 
	    return true;
	if (remSum < 0 || index == m || noOfDigits == m)
	    return false;
	
	if (dp[index][remSum][noOfDigits] != null)
	    return dp[index][remSum][noOfDigits];

	int downLimit = 0;
	if (noOfDigits == 0)
	    downLimit++;

	boolean done = false;
	for (int i = 9; i >= downLimit; i--) {
	    boolean take = rec(index, remSum-i, noOfDigits+1);
	    if (take) {
		done = true;
		sb.append(i);
		break;
	    }
	    boolean leave = rec(index+1,remSum, noOfDigits);
	    if (leave) {
		done = true;
		break;
	    }
	}

	return dp[index][remSum][noOfDigits] = done;
    }
    
    public static boolean can(int m, int s)
    {
        return s >= 0 && s <= 9 * m;
    }

}
