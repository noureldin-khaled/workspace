package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class VanyaAndBooks {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		
		long ans = 0L; 
		if (n < 10)
			ans = n;
		else if (n < 100)
			ans = 9 + (n-9)*2;
		else if (n < 1000)
			ans = 9 + (99-9)*2 + (n-99)*3;
		else if (n < 10000)
			ans = 9 + (99-9)*2 + (999-99)*3 + (n-999)*4;
		else if (n < 100000)
			ans = 9 + (99-9)*2 + (999-99)*3 + (9999-999)*4 + (n-9999)*5;
		else if (n < 1000000)
			ans = 9 + (99-9)*2 + (999-99)*3 + (9999-999)*4 + (99999-9999)*5 + (n-99999)*6;
		else if (n < 10000000)
			ans = 9 + (99-9)*2 + (999-99)*3 + (9999-999)*4 + (99999-9999)*5 + (999999-99999)*6 + (n-999999)*7;
		else if (n < 100000000)
			ans = 9 + (99-9)*2 + (999-99)*3 + (9999-999)*4 + (99999-9999)*5 + (999999-99999)*6 + (9999999-999999)*7 + (n-9999999)*8;
		else if (n < 1000000000)
			ans = 9 + (99-9)*2 + (999-99)*3 + (9999-999)*4 + (99999-9999)*5 + (999999-99999)*6 + (9999999-999999)*7 + (99999999-9999999)*8 + (n-99999999)*9;
		else {
			ans = 9 + (99-9)*2 + (999-99)*3	+ (9999-999)*4 + (99999-9999)*5 + (999999-99999)*6 + (9999999-999999)*7	+ (99999999-9999999)*8;
			long temp = (999999999-99999999)*9L + (n-999999999)*10; //because of the overflow!
			ans += temp;
		}
		System.out.println(ans);
	}

}
