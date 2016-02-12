package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LengtheningSticks {
	static int ways;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		ways = 0;
		for (int i = 0; i < 8; i++) {
			switch(i){
			case 0: //0 0 0
				if (valid(a, b, c))
					ways++;
				break;
			case 1: //0 0 1
			case 2: //0 1 0
			case 4: //1 0 0
				for (int j = 1; j <= l; j++) {
					if (i == 1){
						c += j;
						if (valid(a, b, c))
							ways++;
						c -= j;
					}
					else if (i == 2){
						b += j;
						if (valid(a, b, c))
							ways++;
						b -= j;
					}
					else {
						a += j;
						if (valid(a, b, c))
							ways++;
						a -= j;
					}
				}
				break;
			case 3: //0 1 1
			case 5: //1 0 1
			case 6: //1 1 0
				for (int j = 1; j <= l; j++) {
					if (i == 3){
						b += j;
					}
					else if (i == 5){
						a += j;
					}
					else {
						a += j;
					}
					for (int k = 1; k <= l-j; k++) {
						if (i == 3){
							c += k;
							if (valid(a, b, c))
								ways++;
							c -= k;
						}
						else if (i == 5){
							c += k;
							if (valid(a, b, c))
								ways++;
							c -= k;
						}
						else {
							b += k;
							if (valid(a, b, c))
								ways++;
							b -= k;
						}
					}
					if (i == 3){
						b -= j;
					}
					else if (i == 5){
						a -= j;
					}
					else {
						a -= j;
					}
				}
				break;
			case 7: //1 1 1
				for (int j = 1; j < l; j++) {
					a += j;
					for (int k = 1; k <= l-j; k++) {
						b += k;
						for (int r = 1; r <= l-j-k; r++) {
							c += r;
							if (valid(a, b, c))
								ways++;
							c -= r;
						}
						b -= k;
					}
					a -= j;
				}
				break;
			}

		}
		out.print(ways);
		out.flush();
		out.close();
	}

	public static boolean valid(int a,int b, int c) {
		return (a < b + c && b < a + c && c < a + b);
	}
}
