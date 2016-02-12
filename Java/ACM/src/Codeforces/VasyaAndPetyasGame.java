package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class VasyaAndPetyasGame {

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int n = Integer.parseInt(br.readLine());

	ArrayList<Integer> arr = new ArrayList<Integer>();
	for(int i = 2; i <= n; i*=2)
	    arr.add(i);
	for(int i = 3; i <= n; i+=2){
	    if (isPrime(i)){
		for(int j = 1; Math.pow(i,j) <= n; j++) 
		    arr.add((int)Math.pow(i,j));
	    }
	}
	
	int sizee = arr.size();
	System.out.println(sizee);
	
	for (int i = 0; i < sizee; i++) 
	    System.out.print((i == sizee-1) ? arr.get(i):arr.get(i) + " ");
	
    }
    public static boolean isPrime(int number) {
	int i;
	for (i=2; i*i<=number; i++) {
	    if (number % i == 0) return false;
	}
	return true;
    }
}
