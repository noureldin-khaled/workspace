package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Elections {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int canadites[] = new int[n];
		for (int i = 0; i < m; i++) {
			int max = arr[i][0];
			int maxIndex = 0;
			for (int j = 1; j < n; j++) {
				if (arr[i][j] > max){
					max = arr[i][j];
					maxIndex = j;
				}
			}
			canadites[maxIndex]++;
		}
		
		int max = canadites[0];
		int canad = 0;
		for (int i = 1; i < canadites.length; i++) {
			if (canadites[i] > max){
				max = canadites[i];
				canad = i;
			}
		}
		
		out.print(canad+1);
		out.flush();
		out.close();
	}

}
