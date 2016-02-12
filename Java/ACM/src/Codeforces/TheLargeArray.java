package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheLargeArray {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int input[] = new int[n];
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			input[i] = num;
			
			if (num > max)
				max = num;
		}
		
		int occurences[] = new int[max+1];
		int smallestIndex[] = new int[max+1];
		int largestIndex[] = new int[max+1];
		Arrays.fill(smallestIndex, -1);
		
		for (int i = 0; i < input.length; i++) {
			int element = input[i];
			occurences[element]++;
			if (smallestIndex[element] == -1){
				smallestIndex[element] = i;
				largestIndex[element] = i;
			}
			else
				largestIndex[element] = i;
		}
		
		int maxElement = 0;
		int maxElementfirstOcc = -1;
		int maxElementlastOcc = n+1;
		for (int i = 0; i < occurences.length; i++) {
			if (occurences[i] > maxElement){
				maxElement = occurences[i];
				maxElementfirstOcc = smallestIndex[i];
				maxElementlastOcc = largestIndex[i];
			}
			else if (occurences[i] == maxElement){
				int minDiff = maxElementlastOcc - maxElementfirstOcc + 1;
				int curDiff = largestIndex[i] - smallestIndex[i] + 1;
				
				if (curDiff < minDiff) {
					maxElementfirstOcc = smallestIndex[i];
					maxElementlastOcc = largestIndex[i];
				}
			}
		}
		
		System.out.println((maxElementfirstOcc+1) + " " + (maxElementlastOcc+1));
		
		
	}
}
