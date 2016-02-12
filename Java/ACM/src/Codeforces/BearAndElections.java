package Codeforces;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class BearAndElections {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int limakVotes = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> greaterVotes = new ArrayList<Integer>();
		for (int i = 0; i < n-1; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num >= limakVotes)
				greaterVotes.add(num);
		}
		
		int size = greaterVotes.size();
		int ans = 0;
		while (true){
			int max = 0;
			int maxIndex = -1;
			for (int i = 0; i < size; i++) {
				if (greaterVotes.get(i) > max){
					max = greaterVotes.get(i);
					maxIndex = i;
				}
			}
			if (limakVotes > max)
				break;
			greaterVotes.set(maxIndex, greaterVotes.get(maxIndex)-1);
			limakVotes++;
			ans++;
		}
		
		System.out.println(ans);
	}

}
