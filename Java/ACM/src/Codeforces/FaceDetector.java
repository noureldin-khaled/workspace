package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class FaceDetector {

	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		result = 0;
		char [][] arr = new char[n][m];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) 
				arr[i][j] = line.charAt(j);	
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 'f')
					count(arr,i,j);
			}
		}
		System.out.println(result);
	}

	public static void count(char[][] arr,int i,int j){
		if (j < arr[i].length-1 && i < arr.length-1)
			if ((arr[i][j+1] == 'a' && arr[i+1][j] == 'c' && arr[i+1][j+1] == 'e') 
					|| (arr[i][j+1] == 'a' && arr[i+1][j] == 'e' && arr[i+1][j+1] == 'c')
					|| (arr[i][j+1] == 'c' && arr[i+1][j] == 'a' && arr[i+1][j+1] == 'e')
					|| (arr[i][j+1] == 'c' && arr[i+1][j] == 'e' && arr[i+1][j+1] == 'a')
					|| (arr[i][j+1] == 'e' && arr[i+1][j] == 'a' && arr[i+1][j+1] == 'c')
					|| (arr[i][j+1] == 'e' && arr[i+1][j] == 'c' && arr[i+1][j+1] == 'a'))
				result++;

		if (j > 0 && i < arr.length-1)
			if ((arr[i][j-1] == 'a' && arr[i+1][j] == 'c' && arr[i+1][j-1] == 'e') 
					|| (arr[i][j-1] == 'a' && arr[i+1][j] == 'e' && arr[i+1][j-1] == 'c')
					|| (arr[i][j-1] == 'c' && arr[i+1][j] == 'a' && arr[i+1][j-1] == 'e')
					|| (arr[i][j-1] == 'c' && arr[i+1][j] == 'e' && arr[i+1][j-1] == 'a')
					|| (arr[i][j-1] == 'e' && arr[i+1][j] == 'a' && arr[i+1][j-1] == 'c')
					|| (arr[i][j-1] == 'e' && arr[i+1][j] == 'c' && arr[i+1][j-1] == 'a'))
				result++;

		if (j < arr[i].length-1 && i > 0)
			if ((arr[i][j+1] == 'a' && arr[i-1][j] == 'c' && arr[i-1][j+1] == 'e') 
					|| (arr[i][j+1] == 'a' && arr[i-1][j] == 'e' && arr[i-1][j+1] == 'c')
					|| (arr[i][j+1] == 'c' && arr[i-1][j] == 'a' && arr[i-1][j+1] == 'e')
					|| (arr[i][j+1] == 'c' && arr[i-1][j] == 'e' && arr[i-1][j+1] == 'a')
					|| (arr[i][j+1] == 'e' && arr[i-1][j] == 'a' && arr[i-1][j+1] == 'c')
					|| (arr[i][j+1] == 'e' && arr[i-1][j] == 'c' && arr[i-1][j+1] == 'a'))
				result++;

		if (j > 0 && i > 0)
			if ((arr[i][j-1] == 'a' && arr[i-1][j] == 'c' && arr[i-1][j-1] == 'e') 
					|| (arr[i][j-1] == 'a' && arr[i-1][j] == 'e' && arr[i-1][j-1] == 'c')
					|| (arr[i][j-1] == 'c' && arr[i-1][j] == 'a' && arr[i-1][j-1] == 'e')
					|| (arr[i][j-1] == 'c' && arr[i-1][j] == 'e' && arr[i-1][j-1] == 'a')
					|| (arr[i][j-1] == 'e' && arr[i-1][j] == 'a' && arr[i-1][j-1] == 'c')
					|| (arr[i][j-1] == 'e' && arr[i-1][j] == 'c' && arr[i-1][j-1] == 'a'))
				result++;
	}

}
