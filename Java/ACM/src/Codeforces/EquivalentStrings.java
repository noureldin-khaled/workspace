package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class EquivalentStrings {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		boolean ans = rec(s1,s2);
		if (ans)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	public static boolean rec(String s1,String s2){
		int length = s1.length();
		if (s1.equals(s2))
			return true;
		if ((length%2) != 0)
			return false;
		
		String s1FirstHalf = s1.substring(0,length/2);
		String s1SecondHalf = s1.substring(length/2);
		
		String s2FirstHalf = s2.substring(0,length/2);
		String s2SecondHalf = s2.substring(length/2);
		
		if (rec(s1FirstHalf,s2FirstHalf) && rec(s1SecondHalf,s2SecondHalf))
			return true;
		else if (rec(s1SecondHalf,s2FirstHalf) && rec(s1FirstHalf,s2SecondHalf))
			return true;
		else
			return false;
	}

}
