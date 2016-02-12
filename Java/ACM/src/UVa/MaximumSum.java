package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MaximumSum {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	while(br.ready()){
	    int n = Integer.parseInt(br.readLine());
	    int a[][] = new int[n][n];
	    int rows = 0;
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for (int i = 0; i < n*n; i+=n) {
		int columns = 0;
		for (int j = 0; j < n; j++) {
		    if (st.hasMoreTokens())
			a[rows][columns++] = Integer.parseInt(st.nextToken());
		    else{
			st = new StringTokenizer(br.readLine());
			j--;
		    }
		}
		rows++;
	    }

	    int b[][] = new int[n][n];
	    for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
		    if (j > 0)
			b[i][j] = a[i][j] + b[i][j-1];
		    else
			b[i][j] = a[i][j];
		}
	    }


	    boolean allNegative = true;
	    int max2 = -1270000;
	    for (int i = 0; i < n; i++) 
		for (int j = 0; j < n; j++) {
		    if (a[i][j] > 0)
			allNegative = false;
		    if (a[i][j] > max2)
			max2 = a[i][j];
		}

	    if (allNegative)
		out.println(max2);
	    else {
		int max = -1270000;
		for (int i = 0; i < n; i++) {
		    for (int j = i; j < n; j++) {
			int sum = 0;
			for (int row = 0; row < n; row++) {
			    if (i > 0) 
				sum += b[row][j] - b[row][i-1];
			    else
				sum += b[row][j];

			    if (sum < 0)
				sum = 0;
			    max = Math.max(sum, max);
			}
		    }
		}

		out.println(max);
	    }
	}
	out.flush();
	out.close();
    }

}
