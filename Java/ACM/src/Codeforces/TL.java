package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class TL {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int correctMax = 0;
		int correctMin = 101;
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num > correctMax)
				correctMax = num;
			if (num < correctMin)
				correctMin = num;
		}
		
		st = new StringTokenizer(br.readLine());
		int incorrectMin = 101;
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num < incorrectMin)
				incorrectMin= num;
		}
		
		boolean found = false;
		for (; correctMax < incorrectMin && !found; correctMax++) {
			if (correctMin*2 <= correctMax){
				found = true;
				System.out.println(correctMax);
			}
		}
		if (!found)
			System.out.println(-1);
		
	}

}
