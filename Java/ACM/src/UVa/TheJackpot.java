package UVa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheJackpot {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true){
			String line = br.readLine();
			
			if (line.isEmpty())
				continue;
			if (line.equals("0"))
				break;
			
			int n = Integer.parseInt(line);

			int arr[] = new int[n];
			int k = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(k < n) {
				if (st.hasMoreTokens())
					arr[k++] = Integer.parseInt(st.nextToken());
				else
					st = new StringTokenizer(br.readLine());
			}
			int max = 0;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += arr[i];
				if (sum < 0)
					sum = 0;
				max = Math.max(sum, max);
			}
			if (max <= 0)
				out.println("Losing streak.");
			else 
				out.println("The maximum winning streak is " + max + ".");
		}
		out.flush();
		out.close();
	}

}
