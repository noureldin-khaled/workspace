package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinelandMail {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long arr[] = new long[n];
		
		for (int i = 0; i < n; i++) 
			arr[i] = Long.parseLong(st.nextToken());
		
		for (int i = 0; i < arr.length; i++) {
			if (i == 0)
				System.out.print(arr[1] - arr[0] + " ");
			else if (i == arr.length-1)
				System.out.print(arr[arr.length-1] - arr[arr.length-2] + " ");
			else{
				long min1 = arr[i+1] - arr[i];
				long min2 = arr[i] - arr[i-1];
				System.out.print(Math.min(min1, min2) + " ");
			}
			
			if (i == 0 || i == arr.length-1)
				System.out.print(arr[arr.length-1] - arr[0]);
			else 
				System.out.print(Math.max(arr[arr.length-1] - arr[i], arr[i] - arr[0]));
			
			System.out.println();
		}
	}

}
