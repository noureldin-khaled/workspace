package A2ojLadders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Supermarket {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Integer.parseInt(st.nextToken());
		long S = Integer.parseInt(st.nextToken());
		
		BigInteger sum = new BigInteger("0");
		int i = 0;
		while(i < N){
			if (st.hasMoreTokens()){
				sum = sum.add(new BigInteger(st.nextToken()));
				i++;
			}
			else
				st = new StringTokenizer(br.readLine());
		}
		
		System.out.println(sum.compareTo(new BigInteger(S +"")) <= 0 ? "Yes" : "No");
	}

}
