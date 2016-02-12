package A2ojLadders;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BallonColors {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			String X = st.nextToken();
			String Y = st.nextToken();

			String[] arr = br.readLine().split(" ");
			if (arr[0].equals(X) && arr[arr.length-1].equals(Y))
				System.out.println("BOTH");
			else if (arr[0].equals(X))
				System.out.println("EASY");
			else if (arr[arr.length-1].equals(Y))
				System.out.println("HARD");
			else
				System.out.println("OKAY");
		}
	}

}
