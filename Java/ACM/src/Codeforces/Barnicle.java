package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Barnicle {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine(), ".");
		
		int a = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(st.nextToken(), "e");
		String d = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		
		int len = d.length();
		out.print(a);
		if (b >= len) {
			out.print(d);
			b -= len;
			while(b-->0)
				out.print(0);
		}
		else {
			int i = 0;
			for (; i < b; i++)
				out.print(d.charAt(i));
			StringBuilder sb = new StringBuilder();
			sb.append('.');
			for (; i < len; i++)
				sb.append(d.charAt(i));
			if (!sb.toString().equals(".0"))
				out.print(sb);
		}
		out.println();
		
		out.flush();
		out.close();
	}
}
