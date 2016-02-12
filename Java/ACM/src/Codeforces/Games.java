package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Games {

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int n = Integer.parseInt(br.readLine());
	int homeColors[] = new int[n];
	int guestColors[] = new int[n];
	
	for (int i = 0; i < n; i++) {
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    homeColors[i] = Integer.parseInt(st.nextToken());
	    guestColors[i] = Integer.parseInt(st.nextToken());
	}
	
	int count = 0;
	for (int i = 0; i < homeColors.length; i++) {
	    for (int j = 0; j < guestColors.length; j++) {
		if (homeColors[i] == guestColors[j])
		    count++;
	    }
	}
	
	System.out.println(count);
    }

}
