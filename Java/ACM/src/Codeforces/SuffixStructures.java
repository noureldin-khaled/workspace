package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuffixStructures {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	String s = br.readLine();
	String t = br.readLine();
	
	int tLength = t.length();
	int index = 0;
	boolean auto = false;
	for (int i = 0; i < s.length() && !auto; i++) {
	    if (s.charAt(i) == t.charAt(index))
		index++;
	    if (index == tLength)
		auto = true;
	}
	if (auto)
	    System.out.println("automaton");
	else {
	    StringBuilder s1 = new StringBuilder(s);
	    StringBuilder t1 = new StringBuilder(t);
	    
	    for (int i = 0; i < tLength; i++) {
		boolean found = false;
		for (int j = 0; j < s1.length() && !found; j++) {
		    if (s1.charAt(j) == t1.charAt(i)) {
			found = true;
			s1.setCharAt(j, '1');
			t1.setCharAt(i, '1');
		    }
		}
		if (!found) {
		    System.out.println("need tree");
		    return;
		}
	    }
	    
	    if (s.length() == tLength)
		System.out.println("array");
	    else
		System.out.println("both");
	}
    }

}
