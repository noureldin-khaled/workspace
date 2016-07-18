package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ExpertEnough {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int t = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		while(t-- > 0) {
			int D = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			F arr[] = new F[D];
			for (int i = 0; i < D; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				int l = Integer.parseInt(st.nextToken());
				int h = Integer.parseInt(st.nextToken());

				arr[i] = new F(s,l,h);
			}
			int Q = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

			while(Q-- > 0) {
				int P = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

				int count = 0;
				String car = "";
				for (int i = 0; i < D; i++) {
					if (P >= arr[i].l && P <= arr[i].h) {
						count++;
						car = arr[i].s;
					}
				}

				if (count == 1)
					out.print(car);
				else
					out.print("UNDETERMINED");
				out.println();
			}
			if (t > 0)
				out.println();
		}

		out.flush();
		out.close();

	}

}

class F{
	String s;
	int l;
	int h;
	public F(String s,int l,int h) {
		this.s = s;
		this.l = l;
		this.h = h;
	}
}
