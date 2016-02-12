package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PetyaAndStrings {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String first = br.readLine().toLowerCase();
		String second = br.readLine().toLowerCase();
		
		System.out.println(first.compareTo(second) > 0? 1 : first.compareTo(second) < 0? -1 : 0);
	}

}
