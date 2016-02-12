package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FedorAndNewGame {
    static int k;

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	k = Integer.parseInt(st.nextToken());

	int arr[] = new int[m+1];
	for (int i = 0; i < m+1; i++) 
	    arr[i] = Integer.parseInt(br.readLine());

	int ans = 0;
	for (int i = 0; i < m; i++) {
		if (valid(arr[i],arr[m]))
		    ans++;
	}

	System.out.println(ans);
    }

    public static boolean valid(int a, int b) {
	int length = log(Math.max(a, b), 2)+1;
	int count = 0;
	for (int i = 0; i < length; i++) {
	    int first = a & (1 << i);
	    int second = b & (1 << i);

	    if (first != second)
		count++;
	    
	    if (count > k)
		return false;
	}
	return true;
    }

    public static int log(int x, int base)
    {
	return (int) (Math.log(x) / Math.log(base));
    }

}
