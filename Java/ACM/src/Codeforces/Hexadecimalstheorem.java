package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hexadecimalstheorem {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int f[] = new int[46];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i < 46; i++)
			f[i] = f[i-1] + f[i-2];

		int n = Integer.parseInt(br.readLine());
		if (n == 0)
			System.out.println("0 0 0");
		else if (n == 1)
			System.out.println("0 0 1");
		else {
			int idx = -1;
			for (int i = 0; i < 46; i++)
				if (f[i] == n) {
					idx = i;
					break;
				}
			System.out.println(f[idx-2] + " " + f[idx-2] + " " + f[idx-3]);
		}
	}
}
