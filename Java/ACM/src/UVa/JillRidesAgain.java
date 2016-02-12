package UVa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JillRidesAgain {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		int r = Integer.parseInt(new StringTokenizer(line).nextToken());

		for (int i = 1; i <= r; i++) {
			int s = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			int arr[] = new int[s-1];
			for (int j = 0; j < s-1; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			Stop stops [] = new Stop[s-1];
			int prev = 1;
			int end = 2;
			for (int j = 0; j < s-1; j++) {
				stops[j] = new Stop(prev, end);
				prev = end;
				end++;
			}

			int max = 0;
			int sum = 0;
			int maxStart = 1;
			int maxEnd = 1;
			int tempStart = 1;
			for (int j = 0; j < s-1; j++) {
				sum += arr[j];
				if (sum < 0){
					sum = 0;
					tempStart = stops[j].to;
				}

				if (sum > max){
					max = sum;
					maxStart = tempStart;
					maxEnd = stops[j].to;
				}
				else if (sum == max){
					if ((stops[j].to - tempStart) > (maxEnd - maxStart)){
						maxStart = tempStart;
						maxEnd = stops[j].to;
					}
				}
			}
			if (max <= 0)
				System.out.print("Route " + i + " has no nice parts");
			else 
				System.out.print("The nicest part of route " + i +" is between stops " + maxStart + " and " + maxEnd);

				System.out.println();
		}
	
	}

}

class Stop{
	int from;
	int to;
	public Stop(int from,int to){
		this.from = from;
		this.to = to;
	}
	
	public String toString(){
		return "(" + from + ", " + to + ")";
	}
}
