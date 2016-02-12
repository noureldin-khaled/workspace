package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CardsExchange {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			String line = br.readLine();
			if (line.equals("0 0"))
				break;
			StringTokenizer st = new StringTokenizer(line);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> arrA = new ArrayList<>();
			ArrayList<Integer> arrB = new ArrayList<>();
			
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < A; i++) {
				int num = Integer.parseInt(st.nextToken());
				if (!contains(arrA, num))
					arrA.add(num);
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < B; i++) {
				int num = Integer.parseInt(st.nextToken());
				if (!contains(arrB, num))
					arrB.add(num);
			}
			int c1 = 0;
			for (int i = 0; i < arrA.size(); i++) {
				if (!contains(arrB, arrA.get(i)))
					c1++;
			}
			
			int c2 = 0;
			for (int i = 0; i < arrB.size(); i++) {
				if (!contains(arrA, arrB.get(i)))
					c2++;
			}
			
			System.out.println(Math.min(c1, c2));
		}
	}
	
	public static boolean contains(ArrayList<Integer> arr, int num){
		int pos = Collections.binarySearch(arr, num);
		if (pos < 0)
			return false;
		else
			return true;
	}

}
