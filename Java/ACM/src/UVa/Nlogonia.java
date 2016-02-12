package UVa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Nlogonia {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			int queries = Integer.parseInt(br.readLine());
			if (queries == 0)
				break;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int divX = Integer.parseInt(st.nextToken());
			int divY = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < queries; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if (divX == x || divY == y)
					System.out.println("divisa");
				if (x > divX && y > divY)
					System.out.println("NE");
				if (x < divX && y > divY)
					System.out.println("NO");
				if (x > divX && y < divY)
					System.out.println("SE");
				if (x < divX && y < divY)
					System.out.println("SO");
			}
		}

	}

}
