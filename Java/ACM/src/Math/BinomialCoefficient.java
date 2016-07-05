package Math;

public class BinomialCoefficient {

	static long[][] comb; // we may need to use a TreeMap

	// Pascal's Rule (Top Down)
	public static long nCr1(int n, int k) {
		if (n < k)
			return 0;
		if (k == 0 || k == n) 
			return 1;
		if (comb[n][k] != -1) 
			return comb[n][k];

		if (n-k < k)
			return comb[n][k] = nCr1(n, n-k); // Since nCk = nC(n-k)
		return comb[n][k] = nCr1(n-1, k-1) + nCr1(n-1, k);
	}

	// Pascal's Rule (Bottom Up)
	public static void nCr2(int n) {
		comb = new long[n][n];
		comb[0][0] = 1;

		for (int i = 1; i < n; i++) {
			comb[i][0] = 1;
			for (int j = 1; j <= i; j++)
				comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
		}
	}

	// Multiplicative formula (Top Down)
	public static long nCr3(int n, int k) { // O(n*k)
		if (n < k)
			return 0;
		if (k == 0 || k == n) 
			return 1;
		if (k == 1)
			return n;
		if (comb[n][k] != -1) 
			return comb[n][k];

		if (n-k < k)
			return comb[n][k] = nCr3(n, n-k); // Since nCk = nC(n-k)
		return comb[n][k] = n * nCr3(n-1, k-1) / k;
	}

	// Multiplicative formula (Bottom Up)
	public static long nCr4(int n, int k) { // O(k)
		if (n < k)
			return 0;
		long res = 1;
		for (int i = 1; i <= k; i++)
			res = (n - k + i) * res / i;
		
		return res;
	}
	
	/*
	 * Catalan Numbers.
	 */
	
	public static long cat(int n) {
		return comb[n << 1][n] / (n+1);
	}
	
	static long SC[];
	public long superCat(int n) { // Recursive function starts with 1.
		if (n <= 2)
			return 1;
		if (SC[n] != -1)
			return SC[n];
		
		return SC[n] = (3*(2*n-3)*superCat(n-1) - (n-3)*superCat(n-2)) / n;
	}
}
