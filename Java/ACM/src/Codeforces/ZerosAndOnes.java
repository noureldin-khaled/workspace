package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ZerosAndOnes {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String line = br.readLine();
		int ones = 0;
		int zeros = 0;

		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '1')
				ones++;
			else
				zeros++;
		}
		System.out.println(Math.abs(ones-zeros));
	}
}
