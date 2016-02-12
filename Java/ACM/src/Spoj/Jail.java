package Spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Jail {
	static boolean found = false;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		int rows = Integer.parseInt(s.nextToken());
		int columns = Integer.parseInt(s.nextToken());
		while (rows != -1 && columns != -1){
			char [][] arr = new char[rows+2][columns+2];
			for (int i = 0; i < arr.length; i++) 
				for (int j = 0; j < arr[i].length; j++) 
					Arrays.fill(arr[i], 'E');
			int posI = 0;
			int posJ = 0;
			for (int i = 1; i < arr.length-1; i++) {
				String line = in.readLine();
				for (int j = 1; j < arr[i].length-1; j++) {
					arr[i][j] = line.charAt(j-1);
					if(line.charAt(j-1) == 'H'){
						posI = i;
						posJ = j;
					}
				}
			}
			escape(arr,posI,posJ,posI,posJ,false,-1);

			if (found == false)
				System.out.println(-1);

			s = new StringTokenizer(in.readLine());
			rows = Integer.parseInt(s.nextToken());
			columns = Integer.parseInt(s.nextToken());
		}
	}
	public static void escape(char [][] arr,int i,int j,int lasti, int lastj,boolean door, int steps) {
		//System.out.println(i + " " + j);
		if (arr[i][j] == 'W' || (arr[i][j] == 'D' && door == false))
			return;
		if (arr[i][j] == 'E' && found == false){
			found = true;
			if (steps >= 0)
				steps++;
			System.out.println(steps);
			return;
		}
		if (found == false){
		if (arr[i][j] == 'O')
			door = true;
		if (arr[i][j] == 'C')
			door = false;

		if ((i-1 != lasti && i-1 >=0) || arr[i][j] == 'O')
			escape(arr,i-1,j,i,j,door,steps+1);

		if ((i+1 != lasti && i+1 <arr.length) || arr[i][j] == 'O')
			escape(arr,i+1,j,i,j,door,steps+1);

		if ((j-1 != lastj && j-1 >=0) || arr[i][j] == 'O')
			escape(arr,i,j-1,i,j,door,steps+1);

		if ((j+1 != lastj && j+1 <arr[i].length) || arr[i][j] == 'O')
			escape(arr,i,j+1,i,j,door,steps+1);
		}
	}
}

















