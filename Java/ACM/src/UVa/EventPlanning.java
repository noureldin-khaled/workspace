package UVa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class EventPlanning {
	static int arr[];
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(br.ready()){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			arr = new int[W];
			int minOffer = B + 1;
			
			for (int i = 0; i < H; i++) {
				int cost = Integer.parseInt(br.readLine());
				int curOffer = cost*N;
				
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) 
					arr[j] = Integer.parseInt(st.nextToken());
				
				
				if (curOffer < B && curOffer < minOffer && canHoldAll()){
					minOffer = curOffer;
				}
			}
			
			if (minOffer > B)
				System.out.println("stay home");
			else
				System.out.println(minOffer);
			
		}
	}
	
	public static boolean canHoldAll(){
		boolean valid = false;
		for (int i = 0; i < arr.length && !valid; i++) {
			if (arr[i] >= N)
				valid = true;
		}
		
		return valid;
	}

}
