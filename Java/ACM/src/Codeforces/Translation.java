package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Translation {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String s1 = br.readLine();
	StringBuilder s2 = new StringBuilder(br.readLine());
	s2 = s2.reverse();
	System.out.println(s1.toString().equals(s2.toString()) ? "YES" : "NO");
    }

}
