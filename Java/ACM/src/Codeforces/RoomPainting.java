package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RoomPainting {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());

	int max = -1;
	int arr[] = new int[n];
	for (int i = 0; i < n; i++) {
	    arr[i] = Integer.parseInt(br.readLine());
	    max = Math.max(max, arr[i]);
	}

	Arrays.sort(arr);

	int answers[] = new int[max+1];

	int j = 0;
	for (int i = 1; i < max+1; i++) {
	    if (i > arr[j])
		j++;
	    answers[i] = arr[j];
	}
	
	int ans = 0;
	for (int i = 0; i < m; i++) {
	    int num = Integer.parseInt(br.readLine());
	    ans += answers[num] - num;
	}
	
	System.out.println(ans);
    }

}
