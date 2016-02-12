package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LittlePonyAndCrystalMine {

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	int n = Integer.parseInt(br.readLine());
	
	int stars = n/2;
	int Ds = 1;
	for (int i = 0; i < n/2; i++,stars--,Ds+=2) {
	    for (int j = 0; j < stars; j++) 
		out.print('*');
	    
	    for (int j = 0; j < Ds; j++) 
		out.print('D');
	    
	    for (int j = 0; j < stars; j++) 
		out.print('*');
	    out.println();
	}
	
	for (int i = 0; i < n; i++) 
	    out.print('D');
	out.println();
	
	stars = 1;
	Ds = n-2;
	
	for (int i = 0; i < n/2; i++,stars++,Ds-=2) {
	    for (int j = 0; j < stars; j++) 
		out.print('*');
	    
	    for (int j = 0; j < Ds; j++) 
		out.print('D');
	    
	    for (int j = 0; j < stars; j++) 
		out.print('*');
	    out.println();
	}
	out.flush();
	out.close();
    }

}
