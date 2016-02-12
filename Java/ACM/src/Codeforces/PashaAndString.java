package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PashaAndString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder line = new StringBuilder(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int len = line.length();
		int [] reverses = new int[len/2];
		for (int i = 0; i < m; i++) {
			int index = Integer.parseInt(st.nextToken()) - 1; 
			reverses[index]++;
		}
		
		int sum[] = new int [len/2];
		int count = 0;
		
		for (int i = 0; i < reverses.length; i++) {
			count += reverses[i];
			sum[i] = count;
		}
		
		for (int i = 0; i < sum.length; i++) {
			if (sum[i]%2 != 0){
				char temp = line.charAt(i);
				int end = len-i-1;
				line.setCharAt(i, line.charAt(end));
				line.setCharAt(end, temp);
			}
		}
		
		System.out.println(line);
	}
}
