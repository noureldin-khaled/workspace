package Testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
public class t {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<test; t++) {
			int n = Integer.parseInt(br.readLine());
			int number = 0;
			String[] arr = new String[n];
			int[]sorted;
			t.DT[] array = new t.DT[n];
			ArrayList<Integer>values = new ArrayList<Integer>();

			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String k = st.nextToken();
				String p = st.nextToken();
				arr[i] = p;
				t gp = new t();
				t.DT dt = gp.new DT (Integer.parseInt(k),Integer.parseInt(p));
				array[i] = dt;
			}
			String[] unique = new HashSet<String>(Arrays.asList(arr)).toArray(new String[0]);
			sorted = new int[unique.length];
			for(int j=0;j<sorted.length; j++) {
				sorted[j] = Integer.parseInt(unique[j]);
			}
			Arrays.sort(sorted);
			for(int m=0; m<sorted.length; m++) {
				int counter=0;
				for(int l=0; l<n; l++) {
					if(array[l].value>=sorted[m])
						counter+=array[l].key;
				}
				int result = counter*sorted[m];
				values.add(result);
			}

			Collections.sort(values);
			int max = values.get(values.size()-1);
			sb.append("Case "+ (t+1) + ": " + max + '\n');

		}
		System.out.println(sb);
	}

	public class DT {
		int key;
		int value;
		public DT(int key, int value) {
			this.key = key;
			this.value=value;
		}
	}
}

