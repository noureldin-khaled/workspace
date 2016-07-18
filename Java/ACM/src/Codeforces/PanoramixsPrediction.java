package Codeforces;

import java.util.Scanner;

public class PanoramixsPrediction {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		
		for (int i = n+1; i < m; i++)
			if (isPrime(i)) {
				System.out.println("NO");
				return;
			}
		
		if (isPrime(m))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	static boolean isPrime(int n) {
		for (int i = 2; i < n; i++)
			if (n%i == 0)
				return false;
		return true;
	}
}
