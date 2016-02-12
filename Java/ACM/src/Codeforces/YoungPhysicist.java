package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class YoungPhysicist {

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int n = Integer.parseInt(br.readLine());
	int x[] = new int[n];
	int y[] = new int[n];
	int z[] = new int[n];
	
	for (int i = 0; i < n; i++) {
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    x[i] = Integer.parseInt(st.nextToken());
	    y[i] = Integer.parseInt(st.nextToken());
	    z[i] = Integer.parseInt(st.nextToken());
	}
	
	int sumX = 0;
	int sumY = 0;
	int sumZ = 0;
	for (int i = 0; i < n; i++) {
	    sumX += x[i];
	    sumY += y[i];
	    sumZ += z[i];
	}
	
	System.out.println((sumX == 0 && sumY == 0 && sumZ == 0)? "YES" : "NO");
    }

}
