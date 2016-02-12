package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Towers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] bars = new int[1001];

		for (int i = 0; i < N; i++) {
			int barLength = Integer.parseInt(st.nextToken());
			bars[barLength]++;
		}

		int max = 0;
		int count = 0;
		for (int i = 0; i < bars.length; i++) {
			if (bars[i] != 0)
				count++;
			if (bars[i] > max)
				max = bars[i];
		}
		System.out.println(max + " " + count);
	}

}
