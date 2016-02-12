package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class SetOfStrings {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		String q = br.readLine();

		ArrayList<Character> used = new ArrayList<Character>();
		ArrayList<String> ans = new ArrayList<String>();
		String curString = q.charAt(0) + "";
		used.add(q.charAt(0));

		for (int i = 1; i < q.length(); i++) {
			if (used.contains(q.charAt(i)))
				curString += q.charAt(i);
			else {
				ans.add(curString);
				used.add(curString.charAt(0));
				curString = q.charAt(i) + "";
				used.add(q.charAt(i));
			}
		}	
		if (!curString.isEmpty())
			ans.add(curString);

		if (ans.size() > k){
			String accumulator = "";

			for (int i = ans.size()-1-(ans.size()-k); i < ans.size(); i++) {
				accumulator += ans.get(i);
				ans.remove(i);
				i--;
			}
			ans.add(accumulator);
			System.out.println("YES");
			for (int i = 0; i < ans.size(); i++) 
				System.out.println(ans.get(i));
		}
		else if (ans.size() < k)
			System.out.println("NO");
		else {
			System.out.println("YES");
			for (int i = 0; i < ans.size(); i++) 
				System.out.println(ans.get(i));
		}
	}

}
