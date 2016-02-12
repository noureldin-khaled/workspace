package A2ojLadders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheStonesGame {
	static int X;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			boolean ans = s(1,N,true);
			
			if (ans)
				System.out.println("YES");
			else
				System.out.println("NO");

		}

	}
	
	
	public static boolean s(int p, int stones, boolean prev){
		if (prev){ //(0,1)
			if (p == X){
				if (stones == 1) 
					return true;
				int newP = p+1;
				if (newP > M)
					newP = 1;

				return s(newP, stones, false) || s(newP, stones-1, true);
			}
			else {
				if (stones == 1)
					return false;
				int newP = p+1;
				if (newP > M)
					newP = 1;

				return s(newP, stones, false) && s(newP, stones-1, true);
			}
		}
		else { //(1,2)
			if (p == X){
				if (stones == 1 || stones == 2)
					return true;
				int newP = p+1;
				if (newP > M)
					newP = 1;

				return s(newP, stones-1, false) || s(newP, stones-2, true);
			}
			else {
				if (stones == 1 || stones == 2)
					return false;
				int newP = p+1;
				if (newP > M)
					newP = 1;

				return s(newP, stones-1, false) && s(newP, stones-2, true);
			}
		}
	}
} 
