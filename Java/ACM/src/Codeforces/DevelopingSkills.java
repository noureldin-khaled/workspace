package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DevelopingSkills {

    public static void main(String[] args) throws IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int k = Integer.parseInt(st.nextToken());

	MyInteger arr[] = new MyInteger[n];
	st = new StringTokenizer(br.readLine());
	for (int i = 0; i < n; i++) {
	    arr[i] = new MyInteger(Integer.parseInt(st.nextToken()));
	}

	Arrays.sort(arr);

	for (int i = 0; i < n; i++) {
	    while(arr[i].num%10 != 0 && arr[i].num < 100 && k > 0) {
		arr[i].num++;
		k--;
	    }
	    if (k == 0) break;
	}

	for (int i = 0; i < n && k > 0; i++) {
	    if (arr[i].num < 100) {
		arr[i].num += k;
		if (arr[i].num > 100) {
		    k = arr[i].num-100;
		    arr[i].num = 100;
		}
		else break;
	    }
	}


	int sum = 0;
	for (int i = 0; i < n; i++) 
	    sum += arr[i].num/10;

	System.out.println(sum);
    }
    
}

class MyInteger implements Comparable<MyInteger>{
    int num;
    public MyInteger(int num){
	this.num = num;
    }
    @Override
    public int compareTo(MyInteger o) {
	int a = this.num%10;
	int b = o.num%10;

	if (a > b)
	    return -1;
	else if (b > a)
	    return 1;
	else return 0;
    }

    public String toString(){
	return num + "";
    }

}
