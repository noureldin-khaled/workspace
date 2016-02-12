package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ExactSum {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	int t = 1;
	while(br.ready()) {
	    String line = br.readLine();
	    if (line == null)
		break;
	    if (line.isEmpty())
		continue;
	    
	    int n = Integer.parseInt(line);
	    if (t != 1) 
		out.println();

	    int occ[] = new int[1000001];
	    int arr[] = new int[n];

	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < n; i++) {
		int num = Integer.parseInt(st.nextToken());
		arr[i] = num;
		occ[num]++;
	    }

	    int m = Integer.parseInt(br.readLine());

	    int ans1 = -1;
	    int ans2 = -1;
	    
	    for(int i = 0; i < n; i++) {
		occ[arr[i]]--;
		if (occ[m-arr[i]] > 0) {
		    if ((ans1 == -1 && ans2 == -1) || Math.abs(m - 2*arr[i]) < Math.abs(ans2-ans1)) {
			ans1 = arr[i];
			ans2 = m-arr[i];
		    }
		}
		occ[arr[i]]++;
	    }
	    
	    int small = Math.min(ans1, ans2);
	    int large = Math.max(ans1, ans2);
	    

	    out.printf("Peter should buy books whose prices are %d and %d.\n",small,large);
	    t++;
	}
	out.flush();
	out.close();
    }
}
