package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GameWithSticks {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	
	int arr[][] = new int[n][m];
	int turn = 0;
	for (int i = 0; i < arr.length; i++) {
	    for (int j = 0; j < arr[i].length; j++) {
		if (arr[i][j] != -1){
		    for (int k = j; k < arr[i].length; k++) 
			arr[i][k] = -1;
		    
		    for (int r = i; r < arr.length; r++) 
			arr[r][j] = -1;
		    turn = 1-turn;
		}
	    }
	}
	
	System.out.println(turn == 1? "Akshat" : "Malvika");
    }

}
