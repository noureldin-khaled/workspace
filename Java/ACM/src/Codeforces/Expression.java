package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Expression {

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int a = Integer.parseInt(br.readLine());
	int b = Integer.parseInt(br.readLine());
	int c = Integer.parseInt(br.readLine());
	
	int arr[] = new int[6];
	arr[0] = a+b+c;
	arr[1] = a*b*c;
	arr[2] = a*b+c;
	arr[3] = a+b*c;
	arr[4] = (a+b)*c;
	arr[5] = a*(b+c);
	
	int max = arr[0];
	for (int i = 1; i < arr.length; i++) 
	    max = Math.max(max, arr[i]);
	
	System.out.println(max);
    }

}
