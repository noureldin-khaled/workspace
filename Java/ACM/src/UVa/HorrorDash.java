package UVa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class HorrorDash {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			int max = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= N-1; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num > max)
					max = num;
			}
			
			System.out.println("Case " + i + ": " + max);
		}
	}

}


