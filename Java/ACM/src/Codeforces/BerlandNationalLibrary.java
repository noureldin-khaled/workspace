package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BerlandNationalLibrary {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<String> justEntered = new ArrayList<String>();
		ArrayList<String> input = new ArrayList<String>();
		int initialEntries = 0;
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			input.add(line);
			
			String sign = st.nextToken();
			String ID = st.nextToken();
			
			if (sign.equals("+"))
				justEntered.add(ID);
			else {
				if (!justEntered.contains(ID))
					initialEntries++;
			}
		}
		
		int maxValueReached = initialEntries;
		int count = initialEntries;
		for (int i = 0; i < input.size(); i++) {
			StringTokenizer st = new StringTokenizer(input.get(i));
			String sign = st.nextToken();
			
			if (sign.equals("+"))
				count++;
			else
				count--;
			
			if (count > maxValueReached)
				maxValueReached = count;
			
		}
		
		System.out.println(maxValueReached);
		
	}

}
