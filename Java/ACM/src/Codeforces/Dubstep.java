package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dubstep {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split = br.readLine().split("WUB");
	
		for (int i = 0; i < split.length; i++) {
			if (split[i].isEmpty())
				continue;
			if (i == split.length-1)
				System.out.print(split[i]);
			else
				System.out.print(split[i] + " ");
		}
	}

}
