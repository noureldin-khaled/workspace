package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Sequence {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		
		int arr[] = new int[4];
		while (st.hasMoreTokens()){
			arr[Integer.parseInt(st.nextToken())]++;
		}
		
		int max = arr[1];
		for (int i = 2; i < arr.length; i++) 
			if (arr[i] > max)
				max = arr[i];
		
		System.out.println(n-max);
	}

}
