package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Twins {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) 
			sum += arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		int count = 0;
		int curSum = 0;
		for (int i = arr.length-1; i >= 0; i--) {
			curSum += arr[i];
			count++;
			if (curSum > sum/2)
				break;
		}
		
		System.out.println(count);
	}

}
