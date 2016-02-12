package A2ojLadders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GTXLevel1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i = 0;
		int arr[] = new int[n];
		while(i < n){
			if (st.hasMoreTokens())
				arr[i++] = Integer.parseInt(st.nextToken());
			else
				st = new StringTokenizer(br.readLine());
		}
		
		Arrays.sort(arr);
		int dist[] = new int[n-1];
		for (int j = 0; j < n-1; j++) {
			dist[j] = arr[j+1] - arr[j];
		}
		
		int min = dist[0];
		int minIndex = 0;
		for (int j = 1; j < dist.length; j++) {
			if (dist[j] < min){
				min = dist[j];
				minIndex = j;
			}
		}
		
		System.out.println(arr[minIndex] + " " + arr[minIndex+1]);
	}

}
