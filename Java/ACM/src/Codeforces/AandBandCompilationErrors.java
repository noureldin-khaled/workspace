package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class AandBandCompilationErrors {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String firstInput = br.readLine();
		String secondInput = br.readLine();
		String lastInput = br.readLine();
		
		StringTokenizer st = new StringTokenizer(lastInput);
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n-2; i++) 
			arr.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(arr);
		
		st = new StringTokenizer(secondInput);
		ArrayList<Integer> secondArr = new ArrayList<>();
		for (int i = 0; i < n-1; i++) 
			secondArr.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(secondArr);
		
		
		st = new StringTokenizer(firstInput);

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			int pos = Collections.binarySearch(secondArr, num);
			if (pos < 0)
				System.out.println(num);
			else
				secondArr.remove(pos);
		}
		
		st = new StringTokenizer(secondInput);

		for (int i = 0; i < n-1; i++) {
			int num = Integer.parseInt(st.nextToken());
			int pos = Collections.binarySearch(arr, num);
			if (pos < 0)
				System.out.println(num);
			else
				arr.remove(pos);
		}
		
	}

}
