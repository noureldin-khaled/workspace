package UVa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class TwentyThreeOutOfFive {
	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true){
			String line = br.readLine();
			if (line.equals("0 0 0 0 0"))
				break;
			StringTokenizer st = new StringTokenizer(line);
			arr = new int[5];
			for (int i = 0; i < 5; i++) 
				arr[i] = Integer.parseInt(st.nextToken());

			boolean f = false;
			Arrays.sort(arr);
			do{
			boolean ans = p(1,arr[0]);
			
			if (ans)
				f = true;
			
			}while(nextPerm(arr) && !f);
			
			if (f)
				System.out.println("Possible");
			else
				System.out.println("Impossible");
		}	
	}

	public static boolean p(int i, int sum){
		if (i == 5){
			if (sum == 23)
				return true;
			else
				return false;
		}
		
		return p(i+1,sum + arr[i]) || p(i+1,sum - arr[i]) || p(i+1,sum * arr[i]);
	}
	
	public static boolean nextPerm(int[] arr){
		int length = arr.length;
		int i = length - 2;
		for (; i >= 0; i--) {
			if (arr[i] < arr[i+1]){
				break;
			}
		}

		if (i == -1)
			return false;

		for (int j = length - 1; j > i; j--) {
			if (arr[j] > arr[i]){
				int tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
				break;
			}
		}

		int s = i+1;
		int e = length -1;

		while (s < e){
			int tmp = arr[s];
			arr[s] = arr[e];
			arr[e] = tmp;
			s++;
			e--;
		}

		return true;
	}
	
}
