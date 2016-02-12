package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Team {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int petya = Integer.parseInt(st.nextToken());
			int vasya = Integer.parseInt(st.nextToken());
			int tonya = Integer.parseInt(st.nextToken());
			
			if ((petya == 1 && vasya == 1) || (petya == 1 && tonya == 1) || (vasya == 1 && tonya == 1))
				count++;
		}
		System.out.println(count);
	}

}
