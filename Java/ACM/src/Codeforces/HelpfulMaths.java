package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class HelpfulMaths {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Integer> arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(),"+");

		while(st.hasMoreTokens())
			arr.add(Integer.parseInt(st.nextToken()));

		Collections.sort(arr);

		for (int i = 0; i < arr.size(); i++) {
			if (i == arr.size()-1)
				System.out.print(arr.get(i));
			else
				System.out.print(arr.get(i) + "+");
		}
	}
}
