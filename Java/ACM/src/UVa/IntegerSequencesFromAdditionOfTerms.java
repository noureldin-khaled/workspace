package UVa;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class IntegerSequencesFromAdditionOfTerms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Long> a = new ArrayList<Long>();
			while(st.hasMoreTokens())
				a.add(Long.parseLong(st.nextToken()));
			
			long d = Long.parseLong(br.readLine());
			int k = Integer.parseInt(br.readLine());
			
			ArrayList<Long> r = new ArrayList<Long>();
			for (int i = 1; i <= a.size(); i++) {
				long e = a.get(i-1);
				for (int j = 0; j < i*d; j++)
					r.add(e);
			}
			
			for (int i = 1; i <= r.size(); i++)
				if (i == k) {
					out.println(r.get(i-1));
					break;
				}
		}
		
		out.flush();
		out.close();
	}

}
