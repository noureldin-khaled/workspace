package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CorrectSolution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String solution = br.readLine();
		
		int length = input.length();
		char smallest = input.charAt(0);
		int smallestIndex = 0;
		for (int i = 1; i < length; i++) {
			if (input.charAt(i) != '0' && input.charAt(i) < smallest){
				smallest = input.charAt(i);
				smallestIndex = i;
			}
		}
		
		String realSolution = "" + smallest;
		
		int arr[] = new int[length-1];
		int k = 0;
		for (int i = 0; i < length; i++) {
			if (i != smallestIndex){
				String tmp = input.charAt(i) + "";
				arr[k] = Integer.parseInt(tmp);
				k++;
			}
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) 
			realSolution += "" + arr[i];
		
		StringBuilder s = new StringBuilder(solution);
		if (realSolution.equals(solution))
			System.out.println("OK");
		else
			System.out.println("WRONG_ANSWER");
	}

}
