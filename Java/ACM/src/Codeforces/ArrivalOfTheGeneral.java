package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrivalOfTheGeneral {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		int maxIndex = -1;
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num > max){
				max = num;
				maxIndex = i;
			}
			arr[i] = num;
		}
		
		int count = 0;
		for (int i = maxIndex; i > 0; i--) {
			int temp = arr[i];
			arr[i] = arr[i-1];
			arr[i-1] = temp;
			count++;
		}
		
		int min = 201;
		int minIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= min){
				min = arr[i];
				minIndex = i;
			}
		}
		
		for (int i = minIndex; i < arr.length-1; i++) {
			int temp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = temp;
			count++;
		}
		
		System.out.println(count);
		
	}

}
