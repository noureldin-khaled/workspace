package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheArrays {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(br.readLine());
		int sizeA = Integer.parseInt(st.nextToken());
		int sizeB = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int first = 0;
		for (int i = 0; i < sizeA; i++) {
			if (i == k-1)
				first = Integer.parseInt(st.nextToken());
			else
				st.nextToken();
		}

		st = new StringTokenizer(br.readLine());
		int second = 0;
		for (int i = 0; i < sizeB; i++) {
			if (i == sizeB-m)
				second = Integer.parseInt(st.nextToken());
			else
				st.nextToken();
		}

		if (first < second)
			out.print("YES");
		else
			out.print("NO");

		out.flush();
		out.close();
	}

}
