package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Coder {
	static boolean board[][];
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		n = Integer.parseInt(br.readLine());
		board = new boolean[n][n];
		
		int count = n;
		for (int i = 0; i < n; i++) 
			board[i][i] = true;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!board[i][j] && canPlace(i,j)){
					board[i][j] = true;
					count++;
				}
			}
		}
		
		out.println(count);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j])
					out.print("C");
				else
					out.print(".");
			}
			out.println();
		}
		out.flush();
		out.close();
		
	}

	public static boolean canPlace(int i, int j) {
		if (i > 0)
			if (board[i-1][j])
				return false;
		if (i < n-1)
			if (board[i+1][j])
				return false;
		if (j > 0)
			if (board[i][j-1])
				return false;
		if (j < n-1)
			if (board[i][j+1])
				return false;
		return true;
	}

}
