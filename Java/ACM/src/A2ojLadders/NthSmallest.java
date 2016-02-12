package A2ojLadders;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class NthSmallest {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			String[] split = br.readLine().split(" ");
			int[] out = new int[split.length];
			for (int j = 0; j < split.length; j++) 
				out[j] = Integer.parseInt(split[j]);
				
			Arrays.sort(out);
			System.out.println(out[1]);
		}
	}


}
