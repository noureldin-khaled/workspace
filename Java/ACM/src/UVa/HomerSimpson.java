package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HomerSimpson {
    static int arr[];
    static final int INF = 15000;
    
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	
//	while(br.ready()) {
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int m = Integer.parseInt(st.nextToken());
	    int n = Integer.parseInt(st.nextToken());
	    int t = Integer.parseInt(st.nextToken());
	    
	    arr = new int[2];
	    arr[0] = m;
	    arr[1] = n;
	    ThisPair ans = rec(0,t);
	    String res = ans.count + "";
	    if (t-ans.timeTaken > 0)
		res += " " + (t-ans.timeTaken);
	    out.println(res);
//	}
	
	out.flush();
	out.close();
    }

    public static ThisPair rec(int index, int time) {
	if (time <= 0)
	    return new ThisPair(0, 0);
	if (index == 2)
	    return new ThisPair(-INF, 0);
	
	ThisPair take = rec(index, time - arr[index]);
	take.count++;
	take.timeTaken += arr[index];
	ThisPair leave = rec(index+1, time);
	
	if (take.count > leave.count)
	    return take;
	else if (take.count < leave.count)
	    return leave;
	else if (take.timeTaken > leave.timeTaken)
	    return take;
	else
	    return leave;
    }

}

class ThisPair {
    int count;
    int timeTaken;
    public ThisPair(int count, int timeTaken) {
	this.count = count;
	this.timeTaken = timeTaken;
    }
}