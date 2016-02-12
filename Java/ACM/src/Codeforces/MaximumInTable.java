package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MaximumInTable {
	static int arr[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i == 0 || j == 0)
					arr[i][j] = 1;
				else
					arr[i][j] = -1;
			}
		}
		System.out.println(solve(arr.length-1, arr[arr.length-1].length-1));
		
	}
	
	public static int solve(int i,int j){
		if (arr[i][j] == 1)
			return 1;
		if (arr[i-1][j] == -1)
			solve(i-1,j);
		if (arr[i][j-1] == -1)
			solve(i, j-1);
		
		return arr[i][j] = arr[i-1][j] + arr[i][j-1]; 
	}

}
