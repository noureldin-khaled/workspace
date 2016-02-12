package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BearAndPrimeNumbers {

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	int n = Integer.parseInt(br.readLine());

	int occ[] = new int[10000001];
	StringTokenizer st = new StringTokenizer(br.readLine());
	int max = 0;
	for (int i = 0; i < n; i++) {
	    int num = Integer.parseInt(st.nextToken());
	    occ[num]++;
	    max = Math.max(num, max);
	}

	int f[] = new int[max+1];
	
	boolean arr[] = new boolean[max+1];

	for(int i = 2; i <= max; i++)
	{
	    if (!arr[i])
	    {
		f[i] += occ[i];
		for(int j = i*2; j <= max; j += i) {
		    arr[j] = true;
		    f[i] += occ[j];
		}
	    }
	}
	
	for (int i = 1; i < max+1; i++) 
	    f[i] += f[i-1];
	
	int m = Integer.parseInt(br.readLine());
	for (int i = 0; i < m; i++) {
	    st = new StringTokenizer(br.readLine());
	    int first = Integer.parseInt(st.nextToken());
	    int second = Integer.parseInt(st.nextToken());
	    
	    if (first > max){
		out.println(0);
		continue;
	    }
	    
	    int length = Math.min(second, max);
	    out.println(f[length]-f[first-1]);
	}

	out.flush();
	out.close();
    }

}
