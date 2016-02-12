package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StringTask {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		String res = "";
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			//"A", "O", "Y", "E", "U", "I"
			if (c != 'a' && c != 'o' && c != 'y' && c != 'e' && c != 'u' && c != 'i' 
				&& c != 'A' && c != 'O' && c != 'Y' && c != 'E' && c != 'U' && c != 'I')
			{
				res += ".";
				String temp = c + "";
				if (c >= 'A' && c <= 'Z')
					temp = temp.toLowerCase();
				res += temp;
			}
				
		}
		
		System.out.println(res);
	}
}
