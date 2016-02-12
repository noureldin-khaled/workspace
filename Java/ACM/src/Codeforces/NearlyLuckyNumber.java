package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class NearlyLuckyNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		
		int luckyCount = 0;
		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i) == '4' || number.charAt(i) == '7')
				luckyCount++;
		}
		
		if (luckyCount == 4 || luckyCount == 7)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
