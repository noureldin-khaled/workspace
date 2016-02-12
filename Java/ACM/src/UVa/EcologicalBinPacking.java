package UVa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class EcologicalBinPacking {

	public static boolean nextPerm(char[] arr){
		int length = arr.length;
		int i = length - 2;
		for (; i >= 0; i--) {
			if (arr[i] < arr[i+1]){
				break;
			}
		}

		if (i == -1)
			return false;

		for (int j = length - 1; j > i; j--) {
			if (arr[j] > arr[i]){
				char tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
				break;
			}
		}

		int s = i+1;
		int e = length -1;

		while (s < e){
			char tmp = arr[s];
			arr[s] = arr[e];
			arr[e] = tmp;
			s++;
			e--;
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(br.ready()){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int []bin1 = new int[3];
			int []bin2 = new int[3];
			int []bin3 = new int[3];

			bin1[0] = Integer.parseInt(st.nextToken());
			bin1[1] = Integer.parseInt(st.nextToken());
			bin1[2] = Integer.parseInt(st.nextToken());

			bin2[0] = Integer.parseInt(st.nextToken());
			bin2[1] = Integer.parseInt(st.nextToken());
			bin2[2] = Integer.parseInt(st.nextToken());

			bin3[0] = Integer.parseInt(st.nextToken());
			bin3[1] = Integer.parseInt(st.nextToken());
			bin3[2] = Integer.parseInt(st.nextToken());

			char[] colorBins = {'B','C','G'};
			int minCost = 2147483647;
			char minFirst = ' ';
			char minSecond = ' ';
			char minThird = ' ';
			
			do{
				int curCost = 0;
				char curFirst;
				char curSecond;
				char curThird;
				
				//first bin
				if (colorBins[0] == 'B'){
					curCost+=bin1[1] + bin1[2];
					curFirst = 'B';
				}
				else if (colorBins[0] == 'C'){
					curCost+=bin1[1] + bin1[0];
					curFirst = 'C';
				}
				else { // == 'G'
					curCost+=bin1[0] + bin1[2];
					curFirst = 'G';
				}
				
				//second bin
				if (colorBins[1] == 'B'){
					curCost+=bin2[1] + bin2[2];
					curSecond = 'B';
				}
				else if (colorBins[1] == 'C'){
					curCost+=bin2[1] + bin2[0];
					curSecond = 'C';
				}
				else { // == 'G'
					curCost+=bin2[0] + bin2[2];
					curSecond = 'G';
				}
				
				//third bin
				if (colorBins[2] == 'B'){
					curCost+=bin3[1] + bin3[2];
					curThird = 'B';
				}
				else if (colorBins[2] == 'C'){
					curCost+=bin3[1] + bin3[0];
					curThird = 'C';
				}
				else { // == 'G'
					curCost+=bin3[0] + bin3[2];
					curThird = 'G';
				}
				
				if (curCost < minCost){
					minCost = curCost;
					minFirst = curFirst;
					minSecond = curSecond;
					minThird = curThird;
				}
				
			}while(nextPerm(colorBins));
			
			System.out.println("" + minFirst + minSecond + minThird + " " + minCost);
			
		}

	}

}
