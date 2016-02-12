package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GarbageHeap {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());

		while(t-->0){
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			long arr[][][] = new long[a][b][c];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < a; i++) 
				for (int j = 0; j < b; j++) 
					for (int k = 0; k < c; k++) 
						if (st.hasMoreTokens())
							arr[i][j][k] = Long.parseLong(st.nextToken());
						else {
							st = new StringTokenizer(br.readLine());
							k--;
						}
			
			long commulative[][][] = new long[a][b][c];
			for (int i = 0; i < a; i++) 
				for (int j = 0; j < b; j++) 
					for (int k = 0; k < c; k++) {
						commulative[i][j][k] = arr[i][j][k];
						if (i > 0)
							commulative[i][j][k] += commulative[i-1][j][k];
						if (j > 0)
							commulative[i][j][k] += commulative[i][j-1][k];
						if (k > 0)
							commulative[i][j][k] += commulative[i][j][k-1];

						if (i > 0 && j > 0)
							commulative[i][j][k] -= commulative[i-1][j-1][k];
						if (i > 0 && k > 0)
							commulative[i][j][k] -= commulative[i-1][j][k-1];
						if (j > 0 && k > 0)
							commulative[i][j][k] -= commulative[i][j-1][k-1];

						if (i > 0 && j > 0 && k > 0)
							commulative[i][j][k] += commulative[i-1][j-1][k-1];
					}

			long max = Integer.MIN_VALUE;
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {
					for (int k = 0; k < c; k++) {
						max = Math.max(max, commulative[i][j][k]);
						for (int i2 = i; i2 < a; i2++) {
							for (int j2 = j; j2 < b; j2++) {
								for (int k2 = k; k2 < c; k2++) {
									long sum = commulative[i2][j2][k2];
									if (i > 0)
										sum -= commulative[i-1][j2][k2];
									if (j > 0)
										sum-=  commulative[i2][j-1][k2];
									if (k > 0)
										sum -= commulative[i2][j2][k-1];

									if (i > 0 && j > 0)
										sum += commulative[i-1][j-1][k2];
									if (i > 0 && k > 0)
										sum += commulative[i-1][j2][k-1];
									if (j > 0 && k > 0)
										sum += commulative[i2][j-1][k-1];

									if (i > 0 && j > 0 && k > 0)
										sum -= commulative[i-1][j-1][k-1];
									max = Math.max(max, sum);
								}
							}
						}
					}
				}
			}

			out.println(max);
			if (t > 0)
				out.println();
		}
		out.flush();
		out.close();
	}

}
