package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MaximumSubSequenceProduct {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while(br.ready()){
			ArrayList<Integer> arr = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(true){
				if (st.hasMoreTokens()){
					String token = st.nextToken();
					if (token.equals("-999999"))
						break;
					arr.add(Integer.parseInt(token));
				}
				else
					st = new StringTokenizer(br.readLine());
			}
			int size = arr.size();
			BigInteger commulative[] = new BigInteger[size];

			for (int i = 0; i < size; i++) {
				if (i == 0)
					commulative[i] = new BigInteger(arr.get(i) + "");
				else
					commulative[i] = commulative[i-1].multiply(new BigInteger(arr.get(i)+ ""));
			}
			
			BigInteger max = new BigInteger(-999999+"");
			for (int i = 0; i < commulative.length; i++) {
				if (commulative[i].compareTo(max) > 0)
					max = commulative[i];
				for (int j = i+1; j < commulative.length; j++) {
					if (commulative[i].compareTo(new BigInteger(0+"")) == 0){
						BigInteger prod = new BigInteger("1");
						for (int k = i+1; k <= j; k++) 
							prod = prod.multiply(new BigInteger(arr.get(k) + ""));
						if (prod.compareTo(max) > 0)
							max = prod;
					}
					else {
						BigInteger prod = commulative[j].divide(commulative[i]);
						if (prod.compareTo(max) > 0)
							max = prod;
					}
				}
			}
			out.println(max);
		}
		out.flush();
		out.close();
	}

}
