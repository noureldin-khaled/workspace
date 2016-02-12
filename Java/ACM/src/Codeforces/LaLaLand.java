package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class LaLaLand {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer> negative = new ArrayList<Integer>();
		ArrayList<Integer> negativeClone = new ArrayList<Integer>();
		ArrayList<Integer> positive = new ArrayList<Integer>();
		ArrayList<Integer> positiveClone = new ArrayList<Integer>();
		ArrayList<Integer> negativePrices = new ArrayList<Integer>();
		ArrayList<Integer> positivePrices = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());
			if (num < 0){
				negative.add(num);
				negativeClone.add(num);
				negativePrices.add(Integer.parseInt(st.nextToken()));
			}
			else {
				positive.add(num);
				positiveClone.add(num);
				positivePrices.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		Collections.sort(positiveClone);
		
		Collections.sort(negativeClone);
		Collections.reverse(negativeClone);

		int apples = 0;

		int i = 0;
		int j = 0;
		
		
		if (negativeClone.size() > positiveClone.size()){
			boolean choose = false;
			while(true){
				if (choose){ //take from +ve side
					if (j < positiveClone.size()){
						apples += positivePrices.get(positive.indexOf(positiveClone.get(j)));
						j++;
						choose = false;
					}
					else 
						break;
				}
				else {	//take from -ve side
					if (i < negative.size()){
						apples += negativePrices.get(negative.indexOf(negativeClone.get(i)));
						i++;
						choose = true;
					}
					else 
						break;
				}
			}
		}
		else {
			boolean choose = true;
			while(true){
				if (choose){ //take from +ve side
					if (j < positive.size()){
						apples += positivePrices.get(positive.indexOf(positiveClone.get(j)));
						j++;
						choose = false;
					}
					else 
						break;
				}
				else {	//take from -ve side
					if (i < negative.size()){
						apples += negativePrices.get(negative.indexOf(negativeClone.get(i)));
						i++;
						choose = true;
					}
					else 
						break;
				}
			}
		}
		
		System.out.println(apples);
	}

}
