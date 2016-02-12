package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AmrAndMusic {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int k = Integer.parseInt(st.nextToken());
	
	MyNumber arr[] = new MyNumber[n];
	st = new StringTokenizer(br.readLine());
	
	for (int i = 0; i < n; i++) 
	    arr[i] = new MyNumber(Integer.parseInt(st.nextToken()), i+1);
	
	Arrays.sort(arr);
	int ans = 0;
	for (int i = 0; i < n; i++) {
	    k -= arr[i].num;
	    if (k < 0)
		break;
	    out.print(arr[i].index + " ");
	    ans++;
	}
	System.out.println(ans);
	out.flush();
	out.close();
    }

}

class MyNumber implements Comparable<MyNumber>{
    int num;
    int index;
    public MyNumber(int num,int index) {
	this.num = num;
	this.index = index;
    }
    @Override
    public int compareTo(MyNumber o) {
	return this.num - o.num;
    }
    
    public String toString(){
	return num + " " + index;
    }
    
}
