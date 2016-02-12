package Spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ShakeShakeShaky {
    static int arr[];
    static int n;
    static long k;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	
	int t = Integer.parseInt(br.readLine());
	while(t-->0) {
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    k = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    arr = new int[n];
	    for (int i = 0; i < n; i++) 
		arr[i] = Integer.parseInt(st.nextToken());
	    
	    int low = 1;
	    int high = 1000000000;
	    int ans = 0;
	    while(low <= high) {
		int mid = low + (high-low)/2;
		
		if (valid(mid)) {
		    ans = mid;
		    low = mid+1;
		}
		else
		    high = mid-1;
	    }
	    out.println(ans);
	}
	
	out.flush();
	out.close();
    }

    public static boolean valid(int num) {
	int count = 0;
	for (int i = 0; i < n; i++) {
		count += arr[i]/num;
	}
	return count >= k;
    }
}
