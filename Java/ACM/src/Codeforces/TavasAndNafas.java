package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TavasAndNafas {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.parseInt(br.readLine());

		if (s < 20)
			System.out.println(convert(s));
		else{
			String out = convert(s);
			int lastdigit = s%10;
			if (lastdigit != 0)
				out += "-" + convert(lastdigit);
			
			System.out.println(out);
		}

	}

	public static String convert(int x){
		if (x < 20){
			switch(x){
			case 0: return "zero";
			case 1: return "one";
			case 2: return "two";
			case 3: return "three";
			case 4: return "four";
			case 5: return "five";
			case 6: return "six";
			case 7: return "seven";
			case 8: return "eight";
			case 9: return "nine";
			case 10: return "ten";
			case 11: return "eleven";
			case 12: return "twelve";
			case 13: return "thirteen";
			case 14: return "fourteen";
			case 15: return "fifteen";
			case 16: return "sixteen";
			case 17: return "seventeen";
			case 18: return "eighteen";
			case 19: return "nineteen";
			}
		}
		else if (x < 30)
			return "twenty";
		else if (x < 40)
			return "thirty";
		else if (x < 50)
			return "forty";
		else if (x < 60)
			return "fifty";
		else if (x < 70)
			return "sixty";
		else if (x < 80)
			return "seventy";
		else if (x < 90)
			return "eighty";
		else if (x < 100)
			return "ninety";
		return null;
	}

}
