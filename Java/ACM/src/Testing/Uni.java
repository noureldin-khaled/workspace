package Testing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class Uni {
	static String s1, s2;
	static int n1, n2;
	static int[] z1, z2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("in.txt"));
		s1 = br.readLine();
		s2 = br.readLine();
		n1 = s1.length();
		n2 = s2.length();
		
		z1 = z(s1 + "#" + s1);
		z2 = z(s1 + "#" + s2);
		
//		System.out.println(Arrays.toString((s1 + "#" + s1).toCharArray()));
//		System.out.println(Arrays.toString(z1));
//		System.out.println(Arrays.toString((s1 + "#" + s2).toCharArray()));
//		System.out.println(Arrays.toString(z2));
		int ans = 0;
		for (int i = 1; i <= n1; i++) 
			if (valid1(i) && valid2(i)) 
				ans++;
		
		System.out.println(ans);
	}
	
	static boolean valid1(int i) {
		if (n1%i != 0) return false;
		
		int idx = n1 - i + n1 + 1;
		int tmp = i;
		while(idx > n1) {
			if (z1[idx] != tmp) return false;
			tmp += i;
			idx -= i;
		}
		
		return true;
	}

	static boolean valid2(int i) {
		if (n2%i != 0) return false;
		
		int idx = n2 - i + n1 + 1;
		int tmp = i;
		while(idx > n1) {
			if (z2[idx] != tmp) return false;
			tmp = Math.min(n1, tmp + i);
			idx -= i;
		}
		
		return true;
	}
	
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
