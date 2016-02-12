package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GeraldIsIntoArt {
	static int x;
	static int y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());

		boolean b = check(x1,x2,y1,y2) || check(x1, y2, y1, x2) || check(y1, x2, x1, y2) || check(y1,y2, x1, x2);
		
		if (b)
          System.out.println("YES");
      else
          System.out.println("NO");

	}
	public static boolean check(int x1,int x2,int y1,int y2){
		return ((x1 + x2 <= x && y1 <= y && y2 <= y) || (x1 + x2 <= y && y1 <= x && y2 <= x))
				|| ((y1 + y2 <= y && x1 <= x && x2 <= x) || (y1 + y2 <= x && x1 <= y && x2 <= y));
	}
}