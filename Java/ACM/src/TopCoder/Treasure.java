package TopCoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Treasure {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		treasure(s, 0, 0);
		//System.out.println(s.substring(0, 1)+s.substring(2, s.length()));
	}

	public static void treasure(String s, int count1, int count2) {
		for (int i = 0; i < s.length(); i++) {
			if (count2 > count1)
				return;
			if (s.charAt(i) == '(')
				count1++;
			if (s.charAt(i) == ')')
				count2++;
			if (s.charAt(i) == '#'){
				for (int j = 1; j <= count1; j++) {
					String c = s.substring(0, i);
					int k;
					for (k = 1; k <= j; k++)
						c += ")";
					treasure(c+s.substring(i+1, s.length()), 0, 0);
					if (count2 == count1)
						System.out.println(k);
				}
			}	
		}
	}
}