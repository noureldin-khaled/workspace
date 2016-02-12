package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KingOfThieves {
	static String line;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		line = br.readLine();

		boolean done = false;
		for (int i = 0; i < n && !done; i++) {
			if (line.charAt(i) == '*'){
				for (int j = i+1; j < n && !done; j++) {
					if (line.charAt(j) == '*'){
						int diff = j-i;
						if (isGood(j+diff,diff)){
							done = true;
							break;
						}
					}
				}
			}
		}

		if (done)
			System.out.println("yes");
		else
			System.out.println("no");

	}

	public static boolean isGood(int start,int diff){
		int count = 1;
		for (int i = start; i < n; i+=diff) {
			if (line.charAt(i) != '*')
				return false;
			count++;
			if (count == 4)
				return true;
		}
		return false;
	}

}
