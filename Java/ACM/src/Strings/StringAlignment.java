package Strings;

public class StringAlignment {
	
	public static void main(String[] args) {
		char[] A = "ACAATCC".toCharArray(), B = "AGCATGC".toCharArray();
		System.out.println(NeedlemanWunschs(A, B));
	}
	
	static int NeedlemanWunschs(char[] A, char[] B) {
		int n = A.length, m = B.length;
		int table[][] = new int[n+1][m+1];
		for (int i = 1; i <= n; i++)
			table[i][0] = i * score(A[i-1], ' ');
		for (int i = 1; i <= m; i++)
			table[0][i] = i * score(' ', B[i-1]);
		
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++) {
				int option1 = table[i-1][j-1] + score(A[i-1], B[j-1]);
				int option2 = table[i-1][j] + score(A[i-1], ' ');
				int option3 = table[i][j-1] + score(' ', B[j-1]);
				
				table[i][j] = Math.max(option1, Math.max(option2, option3));
			}
		
		return table[n][m];
	}
	
	static int score(char c1, char c2) {
		if (c1 == ' ' || c2 == ' ')
			return -1; // Gap
		if (c1 == c2)
			return 2; // Match
		return -1; // Mismatch
	}
}
