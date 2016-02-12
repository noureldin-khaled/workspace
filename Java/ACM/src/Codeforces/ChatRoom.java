package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatRoom {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		System.out.println(valid(line) ? "YES" : "NO");
	}

	public static boolean valid(String line) {
		String hello = "hello";
		int index = 0;
		
		for (int i = 0; i < line.length(); i++) {
			if (index == 5)
				return true;
			if (line.charAt(i) == hello.charAt(index))
				index++;
		}
		if (index == 5)
			return true;
		return false;
	}
	

}
