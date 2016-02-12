package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Inventory {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		boolean used[] = new boolean[n+1];
		int occ[] = new int[n+1];
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num <= n){
				used[num] = true;
				occ[num]++;
			}
			arr[i] = num;
		}

		ArrayList<Integer> q = new ArrayList<Integer>();
		for (int i = 1; i < used.length; i++) {
			if (!used[i])
				q.add(i);
		}

		int k =0;
		for (int i = 0; i < arr.length; i++) {
			int element = arr[i];
			if (element > n || occ[element] > 1){
				arr[i] = q.get(k++);
				if (element <= n)
					occ[element]--;
			}
		}

		for (int i = 0; i < n; i++) {
			if (i == n-1)
				out.print(arr[i]);
			else
				out.print(arr[i] + " ");
		}

		out.flush();
		out.close();
	}

}















