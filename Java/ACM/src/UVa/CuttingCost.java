package UVa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class CuttingCost {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int arr[] = new int[3];
			
			for (int j = 0; j < 3; j++) 
				arr[j] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(arr);
			
			System.out.println("Case " + i + ": " + arr[1]);
		}
	}

}
