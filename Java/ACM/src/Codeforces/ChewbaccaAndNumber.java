package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChewbaccaAndNumber {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder num = new StringBuilder(br.readLine());
	
	if ((num.charAt(0)-'0') >= 5 && (num.charAt(0)-'0') != 9) {
	    num.setCharAt(0, ((9-(num.charAt(0)-'0')+"").charAt(0)));
	}
	
	for (int i = 1; i < num.length(); i++) {
	    if ((num.charAt(i)-'0') >= 5) {
		num.setCharAt(i, ((9-(num.charAt(i)-'0')+"").charAt(0)));
	    }
	}
	
	System.out.println(num);
    }

}
