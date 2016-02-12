package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SoldierAndBananas {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int total = 0;
		for (int i = 1; i <= w; i++) 
			total += i*k;
		
		int rem = total - n;
		if (rem > 0)
			System.out.println(rem);
		else 
			System.out.println(0);
	}

}
