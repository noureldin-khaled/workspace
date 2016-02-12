package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Presents {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int first[] = new int[n+1];
		int second[] = new int[n+1];
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			first[i] = num;
			second[num] = i;
		}
		
		for (int i = 1; i < second.length; i++) {
			if (i == second.length-1)
				System.out.print(second[i]);
			else
				System.out.print(second[i] + " ");
		}
	}

}
