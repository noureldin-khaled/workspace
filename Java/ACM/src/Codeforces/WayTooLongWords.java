package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class WayTooLongWords {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		while (n-->0){
			String word = br.readLine();
			if (word.length() > 10)
				System.out.println("" + word.charAt(0) + (word.length()-2) + word.charAt(word.length()-1));
			else
				System.out.println(word);
		}
	}

}
