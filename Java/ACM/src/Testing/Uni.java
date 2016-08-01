package Testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.TreeSet;

public class Uni {

	public static void main(String[] args) throws NumberFormatException, IOException {
		PrintWriter out = new PrintWriter("out.txt");
		System.out.println(BigInteger.valueOf(4).modInverse(BigInteger.valueOf(7)));
		System.out.println(Math.pow(4, 7-2) % 7);
	}
	
	static void rec(int n) {
		if (n <= 0)
			return;
		rec(n-1);
	}
	 
	public static int get(int a) {
		return BigInteger.valueOf(a-1).toString(7).length();
	}

	static class Sorter implements Comparator<Integer>
	{
		public int compare(Integer x1, Integer x2)
		{
			return x2 - x1;
		}
	}
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

	static void shuffle(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = (int) (Math.random() * (n-i)) + i;
			int tmp = a[i];
			a[i] = a[r];
			a[r] = tmp;
		}
	}

	static final int INF = (int)1e9;

	static void mergeSort(int[] a, int b, int e) {
		if (b < e) {
			int mid = (b + e) / 2;
			mergeSort(a, b, mid);
			mergeSort(a, mid+1, e);
			merge(a, b, mid, e);
		}
	}

	static int inversionIndex;
	static void merge(int[] a, int b, int mid, int e) {
		int n1 = mid - b + 1, n2  = e - mid; // e-(mid+1)+1

		int[] L = new int[n1+1];
		int[] R = new int[n1+1];

		for (int i = 0; i < n1; i++) L[i] = a[b + i];

		for (int i = 0; i < n2; i++) R[i] = a[mid + 1 + i];

		L[n1] = R[n2] = INF;

		for (int i = 0, j = 0, k = b; k <= e; k++)
			if (L[i] <= R[i])
				a[k] = L[i++];
			else {
				inversionIndex += n1 - i;
				a[k] = R[j++];
			}	
	}

	static long[][] comb;

	static void nCr(int MAXN)
	{
		comb = new long[MAXN][MAXN];
		comb[0][0] = 1;
		for (int i = 1; i < MAXN; i++)
		{
			comb[i][0] = 1;
			for (int j = 1; j <= i; j++)
				comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
		}
	}

}
