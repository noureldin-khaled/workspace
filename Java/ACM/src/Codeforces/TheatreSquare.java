package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class TheatreSquare {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long a = Long.parseLong(st.nextToken());
		
		long rows;
		rows = n /a;
		if (n%a != 0)
			rows++;
		
		long cols;
		cols = m/a;
		if (m%a != 0)
			cols++;
		
		System.out.println(rows*cols);
	}

}
