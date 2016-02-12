package A2ojLadders;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Candies {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			String line = br.readLine();
			int max = 0;
			int maxIndex = 0;
			for (int j = 0; j < line.length(); j++) {
				int cur = 0;
				for (int j2 = j; j2 < line.length(); j2++) 
					if (line.charAt(j) == line.charAt(j2))
						cur++;
				if (cur > max || (cur == max && line.charAt(j) < line.charAt(maxIndex))){
					max = cur;
					maxIndex = j;
				}
			}
			System.out.println(max + " " + line.charAt(maxIndex));
		}
	}

}
