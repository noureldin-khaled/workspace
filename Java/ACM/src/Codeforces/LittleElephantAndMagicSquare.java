package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LittleElephantAndMagicSquare {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int arr[][] = new int[3][3];
	StringTokenizer st = new StringTokenizer(br.readLine());
	arr[0][0] = Integer.parseInt(st.nextToken());
	arr[0][1] = Integer.parseInt(st.nextToken());
	arr[0][2] = Integer.parseInt(st.nextToken());
	
	int sum1 = arr[0][1] + arr[0][2];

	st = new StringTokenizer(br.readLine());
	arr[1][0] = Integer.parseInt(st.nextToken());
	arr[1][1] = Integer.parseInt(st.nextToken());
	arr[1][2] = Integer.parseInt(st.nextToken());
	
	int sum2 = arr[1][0] + arr[1][2];

	st = new StringTokenizer(br.readLine());
	arr[2][0] = Integer.parseInt(st.nextToken());
	arr[2][1] = Integer.parseInt(st.nextToken());
	arr[2][2] = Integer.parseInt(st.nextToken());
	
	int sum3 = arr[2][0] + arr[2][1];
	
	arr[2][2] = (sum1+sum2-sum3)/2;
	arr[0][0] = sum2-arr[2][2];
	arr[1][1] = sum1-arr[2][2];
	
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
		System.out.print(arr[i][j] + " ");
	    }
	    System.out.println();
	}
    }

}
