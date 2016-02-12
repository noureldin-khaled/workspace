package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class DivisibilitybyEight {
	static TreeMap<String, String>[]dp;
	static int[]num; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		int len = line.length();
		String num = "";
		boolean done = false;
		for (int i = 0; i < len && !done; i++) {
			String temp = line.charAt(i)+"";

			if (Integer.parseInt(temp)%8 == 0){
				num = temp;
				done = true;
			}
			for (int j = i+1; j < len && !done; j++) {
				String temp2 = temp + line.charAt(j);

				if (Integer.parseInt(temp2)%8 == 0){
					num = temp2;
					done = true;
				}
				for (int k = j+1; k < len && !done; k++) {
					String temp3 = temp2 + line.charAt(k) + "";

					if (Integer.parseInt(temp3)%8 == 0){
						num = temp3;
						done = true;
					}
				}
			}
		}
		if (num.isEmpty())
			System.out.println("NO");
		else{
			System.out.println("YES");
			System.out.println(num);
		}
		
	}
}
