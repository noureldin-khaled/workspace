package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PresentFromLena {

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	int n = Integer.parseInt(br.readLine());
	int size = n*2+1;
	char arr[][] = new char[size][size];
	
	int spaces = n;
	for (int i = 0; i < size/2; i++,spaces--) {
	    int j = 0;
	    for (; j < spaces; j++) {
		arr[i][j] = ' ';
		arr[size-1-i][j] = ' ';
	    }
	    
	    for (int c = 0; c <= i; c++,j++) {
		arr[i][j] = (c + "").charAt(0);
		arr[i][size-1-j] = (c + "").charAt(0);
		arr[size-1-i][j] = (c + "").charAt(0);
		arr[size-1-i][size-1-j] = (c + "").charAt(0);
	    }
	}
	
	for (int i = 0; i < size/2; i++) {
	    arr[n][i] = (i + "").charAt(0);
	    arr[n][size-1-i] = (i + "").charAt(0);
	}
	arr[n][n] = (n + "").charAt(0);
	
	for (int i = 0; i < size; i++) {
	    for (int j = 0; j < size; j++) {
		if ((j+1 < size && arr[i][j+1] == '\u0000') || j == size-1) {
		    out.print(arr[i][j]);
		    break;
		}
		else
		    out.print(arr[i][j] + " ");
		    
	    }
	    out.println();
	}
	out.flush();
	out.close();
    }

}
