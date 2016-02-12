package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Caps {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String res = "";
		
		String temp = input.charAt(0) + "";
		if (input.charAt(0) >= 'a' && input.charAt(0) <= 'z')
			res += temp.toUpperCase();
		else 
			res += temp.toLowerCase();
		
		
		boolean flag = false;
		for (int i = 1; i < input.length() && !flag; i++) {
			if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'){
				String temp2 = input.charAt(i) + "";
				res += temp2.toLowerCase();
			}else 
				flag = true;
		}
		
		if (flag)
			System.out.println(input);
		else 
			System.out.println(res);
		
	}

}
