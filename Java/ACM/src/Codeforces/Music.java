package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Music {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int count = 1;
		int i = 0;
		while(true){
			i += q;
			S += q-1;
			if (S >= T)
				break;
			if (i >= S){
				i = 0;
				count++;
			}
			
		}
		
		out.print(count);
		out.flush();
		out.close();
	}

}
