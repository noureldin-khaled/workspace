package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cifera {

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int k = Integer.parseInt(br.readLine());
	int l = Integer.parseInt(br.readLine());
	
	int ans = 1;
	long temp = k;
	while(true){
	    if (temp == l) {
		System.out.println("YES");
		System.out.println(ans-1);
		return;
	    }
	    if (temp > l){
		System.out.println("NO");
		return;
	    }
	    temp *= k;
	    ans++;
	}
    }
}