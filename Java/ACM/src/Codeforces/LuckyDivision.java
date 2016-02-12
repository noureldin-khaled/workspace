package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuckyDivision {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			int num = n/i;
			if (n%i == 0 && isLucky((int)num))
			{
				System.out.println("YES");
				return;
			}
		}
		
		System.out.println("NO");
	}

	public static boolean isLucky(int num) {
		while(num != 0){
			int digit = num%10;
			if (digit != 4 && digit != 7)
				return false;
			num/=10;
		}
		return true;
	}

}
