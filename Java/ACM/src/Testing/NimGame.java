package Testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NimGame {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
//			int M = Integer.parseInt(st.nextToken());
//			int X = Integer.parseInt(st.nextToken());
			
			boolean first = isWinning(N-1, true);
			boolean second = isWinning(N, false);
			
			if (first && second)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	
	public static boolean isWinning(int position,boolean prev){
		if (position == 0)
			return false;
		if (prev){
			int moves[] = {position,position-1};			
			
			if (!isWinning(moves[0], false)) return true;
			if (!isWinning(moves[1], true)) return true;
			
			return false;
		}else {
			int moves[] = {position-1,position-2};
			
			if (!isWinning(moves[0], false)) return true;
			if (!isWinning(moves[1], true)) return true;
			
			return false;
		}
	}

}
