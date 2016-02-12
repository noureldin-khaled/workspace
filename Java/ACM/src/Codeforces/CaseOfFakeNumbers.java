package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CaseOfFakeNumbers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		int arrCopy[] = new int[n];

		boolean done = true;
		for (int i = 0; i < n; i++){ 
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			arrCopy[i] = num;
			if (num != i)
				done = false;
		}

		if (done)
			System.out.println("Yes");
		else {
			while(true){
				boolean found = true;
				boolean cycled = true;

				for (int i = 0; i < arr.length; i++) {
					if ((i%2) == 0){ //even position
						if (arr[i] == (n-1))
							arr[i] = 0;
						else
							arr[i]++;
					}
					else { //odd position
						if (arr[i] == 0)
							arr[i] = n-1;
						else
							arr[i]--;
					}
					if (arr[i] != i)
						found = false;
					if (arr[i] != arrCopy[i])
						cycled = false;
				}
				if (found){
					System.out.println("Yes");
					break;
				}
				if (cycled){
					System.out.println("No");
					break;
				}
			}
		}
	}

}
