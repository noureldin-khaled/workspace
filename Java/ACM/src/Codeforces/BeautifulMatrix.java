package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeautifulMatrix {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[][] = new int[5][5];
		
		int startX = -1;
		int startY = -1;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					startX = i;
					startY = j;
				}
				arr[i][j] = num;
			}
		}
		
		System.out.println(Math.abs(startX - 2) + Math.abs(startY - 2));
	}

}
