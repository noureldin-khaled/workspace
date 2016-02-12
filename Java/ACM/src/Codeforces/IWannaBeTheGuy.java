package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class IWannaBeTheGuy {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean [] arr = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		for (int i = 0; i < p; i++) 
			arr[Integer.parseInt(st.nextToken())] = true;
		
		
		st = new StringTokenizer(br.readLine());
		int q = Integer.parseInt(st.nextToken());
		for (int i = 0; i < q; i++) 
			arr[Integer.parseInt(st.nextToken())] = true;
		
		boolean possible = true;
		for (int i = 1; i < arr.length && possible; i++) {
			if (arr[i] == false)
				possible = false;
		}
		
		if (possible)
			System.out.println("I become the guy.");
		else 
			System.out.println("Oh, my keyboard!");
	}
}
