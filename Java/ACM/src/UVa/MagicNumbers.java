package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicNumbers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			br.readLine();
			long N = Long.parseLong(br.readLine());	
			for (long s2 = 1; s2*N <= 9876543210L; s2++) {

				long s1 = s2*N;
				if (isDistinct(s1) && isDistinct(s2))
					System.out.println((s1 + " / " + s2 + " = " + N));	
			}
			if (t > 0)
				System.out.println();
		}
	}



	public static boolean isDistinct(long num){
		int mask = 0;
		while(num != 0){
			long digit = num%10;
			if (((1 << digit) & mask) != 0)
				return false;

			mask = (1 << digit) | mask;
			num = num/10;
		}
		return true;
	}
}
