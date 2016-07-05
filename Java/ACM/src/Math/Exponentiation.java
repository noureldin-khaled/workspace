package Math;

import java.math.BigInteger;

public class Exponentiation {
	
	/*
	 * All Algorithms are O(log e)
	 */
	
	// Binary Exponentiation
	public static int pow(int a, int e) {
		int res = 1;
		while(e > 0)
		{
			if((e & 1) == 1)
				res *= a;
			a *= a;
			e >>= 1;
		}
		return res;
	}
	
	// Fast Exponentiation (Same as Binary Exponentiation but with big numbers)
	public static int bigMod(int a, int e, int mod) {
		a %= mod;
		int res = 1;
		while(e > 0)
		{
			if((e & 1) == 1)
				res = (res * a) % mod;
			a = (a * a) % mod;
			e >>= 1;
		}
		return res;
	}

	// Fast Exponentiation with BigInteger (recursive)
	public static BigInteger power(BigInteger base, BigInteger e) {
		if (e.compareTo(BigInteger.valueOf(0)) == 0)
			return BigInteger.ONE;
		if (e.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0) {
			BigInteger ans = power(base, e.divide(BigInteger.valueOf(2)));
			return ans.multiply(ans);
		}
		else {
			return power(base, e.subtract(BigInteger.ONE)).multiply(base);
		}
	}
	
	// Fast Exponentiation with doubles (recursive)
	public static double pow(double base, double e) {
		if (e == 0)
			return 1.0;
		if (e%2 == 0) {
			double ans = pow(base, e/2);
			return ans * ans;
		}
		else {
			return pow(base, e-1)*base;
		}
	}
}
