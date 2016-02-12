package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class OhanaCleansUp {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<String> input = new ArrayList<>(); 
		for (int i = 0; i < n; i++) 
			input.add(br.readLine());
		
		int max = 0;
		for (int i = 0; i < input.size(); i++) {
			String cur = input.get(i);
			int curCount = 1;
			for (int j = i+1; j < input.size(); j++) {
				if (input.get(j).equals(cur))
					curCount++;
			}
			if (curCount > max)
				max = curCount;
		}
		
		System.out.println(max);
	}

}
