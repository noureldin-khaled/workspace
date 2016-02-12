package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class BoysAndGirls {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		String input = "";
		for(int i = 0; i < line.length(); i++){
	        if (!contain(input,line.charAt(i)))
	            input += line.charAt(i);
	    }
		

		if (input.length()%2 == 0)
			System.out.println("CHAT WITH HER!");
		else 
			System.out.println("IGNORE HIM!");
			
		
		
	}
	
	public static boolean contain(String s, char c){
		for(int i = 0; i < s.length(); i++)
	        if (s.charAt(i) == c)
	            return true;

	    return false;
	}

}
