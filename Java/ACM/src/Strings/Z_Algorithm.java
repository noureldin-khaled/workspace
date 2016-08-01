package Strings;

import java.util.Arrays;

public class Z_Algorithm {

	static int[] z(String s) {
		int L = 0;
		int R = 0;
		int n = s.length();
		int z[] = new int[n];
		z[0] = -1;

		for (int i = 1; i < n; i++) {
			if (i > R) { // exceeded the Z-box
				L = R = i;
				while(R < n && s.charAt(R-L) == s.charAt(R))
					R++;
				z[i] = R-L;
				R--;
			}
			else {
				int k = i-L;
				if (i + z[k] <= R)
					z[i] = z[k];
				else {
					L = i;
					while (R < n && s.charAt(R-L) == s.charAt(R))
						R++;
					z[i] = R-L;
					R--;
				}
			}
		}
		return z;
	}


	public static void main(String[] args) {
		System.out.println(Arrays.toString(z("ababax")));
	}
}
