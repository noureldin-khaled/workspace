package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SpongebobAndJoke {
    static class element {
	int occ;
	int index;
	public element(int occ, int index) {
	    this.occ = occ;
	    this.index = index;
	}
    }

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());

	element arr[] = new element[n+1];
	for (int i = 0; i < n+1; i++) 
	    arr[i] = new element(0, -1);

	st = new StringTokenizer(br.readLine());
	for (int i = 1; i <= n; i++) {
	    int num = Integer.parseInt(st.nextToken());
	    arr[num].occ++;
	    arr[num].index = i;
	}

	st = new StringTokenizer(br.readLine());
	int b[] = new int[m];
	for (int i = 0; i < m; i++) 
	    b[i] = Integer.parseInt(st.nextToken());
	
	for (int i = 0; i < m; i++) {
	    if (arr[b[i]].occ == 0) {
		System.out.println("Impossible");
		return;
	    }
	}
	
	for (int i = 0; i < m; i++) {
	    if (arr[b[i]].occ > 1) {
		System.out.println("Ambiguity");
		return;
	    }
	}
	
	out.println("Possible");
	for (int i = 0; i < m; i++) {
	    out.print(arr[b[i]].index + " ");
	}
	out.flush();
	out.close();
    }

}
