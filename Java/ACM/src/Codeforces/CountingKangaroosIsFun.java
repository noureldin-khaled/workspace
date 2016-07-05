package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CountingKangaroosIsFun {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		int ans = n;
		int i = 0;
		int j = n%2 == 0 ? n/2 : n/2 + 1;
		int limit = n%2 == 0 ? n/2 : n/2 + 1;
		while(i < limit && j < n) {
			int small = arr[i];
			int large = arr[j];
			
			if (large >= (small<<1)) {
				ans--;
				i++;
				j++;
			}
			else 
				j++;
		}
		
		System.out.println(ans);
	}
	
	static class Scanner {
	    BufferedReader br;
	    StringTokenizer st;

	    public Scanner(FileReader f) {
	        br = new BufferedReader(f);
	    }

	    public Scanner(InputStream in) {
	        br = new BufferedReader(new InputStreamReader(in));
	    }

	    public String next() throws IOException {
	        while (st == null || !st.hasMoreTokens())
	            st = new StringTokenizer(br.readLine());
	        return st.nextToken();
	    }

	    public String nextLine() throws IOException {
	        return br.readLine();
	    }

	    public int nextInt() throws IOException {
	        return Integer.parseInt(next());
	    }

	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }

	    public double nextDouble() throws IOException {
	        return Double.parseDouble(next());
	    }

	    public boolean Ready() throws IOException {
	        return br.ready();
	    }

	    public void waitForInput(long time) {
	        long ct = System.currentTimeMillis();
	        while(System.currentTimeMillis() - ct < time) {};
	    }

	}

}