package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PerfectHash {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	
	int t = 1;
	while(br.ready()) {
	    if (t != 1)
		out.println();
	    String line = br.readLine();
	    StringTokenizer st = new StringTokenizer(line);
	    ArrayList<Integer> arr = new ArrayList<>();
	    while(st.hasMoreTokens()) {
		String s = st.nextToken();
		int len = s.length();
		int sum = 0;
		int count = 0;
		for (int j = len-1; j >= 0; j--)
		{

		    sum += (((int)s.charAt(j)) - 96)*Math.pow(32, count);
		    count++;
		}
		arr.add(sum);
	    }
	    System.out.println(arr);

	    int size = arr.size();
	    int c = 1;
	    boolean done = false;
	    while(!done) {
		int maxConflict = -1;

		for (int i = 0; i < size; i++) {
		    for (int j = i+1; j < size; j++) {
			int first = (c/arr.get(i))%size;
			int second = (c/arr.get(j))%size;

			if (first == second)
			{
			    int temp = Math.min(((c/arr.get(i)) + 1) * arr.get(i),((c/arr.get(j)) + 1) * arr.get(j));
			    maxConflict = Math.max(maxConflict, temp);
			}
		    }
		}

		if (maxConflict == -1)
		    done = true;
		else
		    c = maxConflict;
	    }
	    
	    out.println(line);
	    out.println(c);

	    t++;
	}
	out.println();
	out.flush();
	out.close();
    }
}

