package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Gukiz {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];
		int arrCopy[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			arr[i] = a;
			arrCopy[i] = a;
		}
		
		Arrays.sort(arrCopy);
		arrCopy = arrayReverse(arrCopy);
		
		int postions[] = new int[n];
		
		arrCopy = arrayRemoveDups(arrCopy);
		int c = 1;

		for (int i = 0; i < arrCopy.length; i++) {
			int increase = 0;
			for (int j = 0; j < arr.length && arrCopy[i] != 0; j++) {
				if (arrCopy[i] == arr[j]){
					postions[j] = c;
					increase++;
				}
			}
			c += increase;
		}
		
		for (int i = 0; i < postions.length; i++) 
			if (i != postions.length-1)
				System.out.print(postions[i] + " ");
			else 
				System.out.print(postions[i]);
	}
	

	public static int[] arrayReverse(int [] a){
		int res[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			res[i] = a[a.length-1-i];
			res[a.length-1-i] = a[i];
		}
		return res;
	}
	
	
	public static int[] arrayRemoveDups(int [] a){
		int res[] = new int[a.length];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			boolean found = false;
			for (int j = 0; j < res.length && !found; j++) {
				if (res[j] == a[i])
					found = true;
			}
			if (!found){
				res[k] = a[i];
				k++;
			}
		}
		return res;
	}
}
