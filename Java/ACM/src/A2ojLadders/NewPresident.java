package A2ojLadders;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class NewPresident {
	static Pair[] res;
	
	public static void main(String[] args) throws NumberFormatException, IOException  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			int arr[][] = new int[V][C];

			for (int j = 0; j < V; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < C; j2++) {
					int entry = Integer.parseInt(st.nextToken());
					arr[j][j2] = entry;
					arr[j][j2]--;
				}
			}
			
			res = new Pair[C];
			for (int j = 0; j < C; j++) 
				res[j] = new Pair(0, j);
			
			for (int j = 0; j < V; j++) 
				res[arr[j][0]].first++;
			
			Arrays.sort(res);
			reverse(res);
			
			if (res[0].first > V/2){
				System.out.println(res[0].second + 1 + " " + 1);
				continue;
			}
			
			int i1 = res[0].second;
			int i2 = res[1].second;
			
			int c1 = 0,c2 =0;
			
			for (int j = 0; j < V; j++) {
				for (int j2 = 0; j2 < C; j2++) {
					if (arr[j][j2] == i1){
						c1++;
						break;
					}
					else if (arr[j][j2] == i2){
						c2++;
						break;
					}
				}
			}
			
			
			if (c1 > c2)
				System.out.println(i1+1 + " " + 2);
			else
				System.out.println(i2+1 + " " + 2);
		}

	}
	
	public static void reverse(Object[] arr){
		for (int i = 0; i < arr.length/2; i++) {
			Object temp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = temp;
		}
	}


}

class Pair implements Comparable<Pair>{
	int first;
	int second;
	
	public Pair(int first, int second){
		this.first = first;
		this.second = second;
	}
	
	public String toString(){
		return "("+first+", "+second+")";
	}

	public int compareTo(Pair o) {
		if (this.first > o.first)
			return 1;
		if (this.first < o.first)
			return -1;
		return 0;
	}
	
}
