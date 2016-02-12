package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SecretPolynomial {

    static int [][] array;
    static int n, f1, ff1;

    public static void main(String[] args) throws IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(br.readLine());
	StringTokenizer s = new StringTokenizer(br.readLine());
	f1 = new Integer(s.nextToken());
	ff1 = new Integer(s.nextToken());
	array = new int[2][n+1];
	array[0][0] = 1;
	array[1][0] = 1;
	int cur = 1;
	int pre = 0;

	while(n-->0) {
	    for (int i = 1; i < array[1].length; i++) {
		array[cur][i] = array[pre][i] + array [pre][i-1];
	    }
	    pre = 1-pre;
	    cur = 1-cur;
	}
	
	int sum = 0;
	for (int i = 0; i < array[pre].length; i++) {
	    sum += array[pre][i];
	}
	
	if(sum == f1){
	    
	}


    }

}
