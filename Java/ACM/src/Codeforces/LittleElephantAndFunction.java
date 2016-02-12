package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LittleElephantAndFunction {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.print(n);
		for (int i = 1; i <= n-1; i++) 
			System.out.print(" " + i);
		
	}

}
