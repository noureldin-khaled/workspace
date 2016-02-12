package A2ojLadders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheMissingDate {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int birthYear = Integer.parseInt(st.nextToken());
			int birthMonth = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int ageYear = Integer.parseInt(st.nextToken());
			int ageMonth = Integer.parseInt(st.nextToken());
			
			int curMonth = birthMonth+ageMonth;
			int curYear = birthYear+ageYear;
			
			if (curMonth > 12){
				curYear++;
				curMonth-=12;
			}
			
			System.out.println(curYear + " " + curMonth);
		}
	}

}
