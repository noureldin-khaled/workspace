package A2ojLadders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Magdy {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		System.out.println(n < 1 ? "Don't be lazy, it takes only few minutes, you can do it." : n == 1 ? "Good Job" : "You Rocks Man");
	}

}
