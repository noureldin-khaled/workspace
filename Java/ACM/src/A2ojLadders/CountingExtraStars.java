package A2ojLadders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class CountingExtraStars {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> arr = new ArrayList<String>();
		for (int i = n*2-1; i >= 1; i-=2) {
			String line = "";
			for (int j = 0; j < i; j++) {
				line+="*";
			}
			arr.add(line);
		}
		
		Collections.reverse(arr);
		int spaces = (n*2-1)/2;
		for (int i = 0; i < arr.size(); i++) {
			String line = "";
			for (int j = 0; j < spaces; j++) {
				line += " ";
			}
			line += arr.get(i);
			System.out.println(line);
			spaces--;
		}
	}

}
