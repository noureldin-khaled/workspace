package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WateringGrass {

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	while(sc.Ready()) {
	    int n = sc.nextInt();
	    int l = sc.nextInt();
	    int w = sc.nextInt();

	    Pair arr[] = new Pair[n];
	    for (int i = 0; i < n; i++) {
		int x = sc.nextInt();
		int r = sc.nextInt();

		double dx = Math.sqrt((double)r*r - (w*w) /4.0);
		arr[i] = new Pair(x-dx, x+dx);
	    }
	    Arrays.sort(arr);
	    
	    int i = 0;
	    int ans = 0;
	    boolean valid = true;
	    double curEnd = 0;
	    while(curEnd < l && valid) {
		double maxEnd = curEnd;
		int j = i;
		valid = false;
		
		for (; j < n && arr[j].first <= curEnd; j++) {
		    valid = true;
		    maxEnd = Math.max(maxEnd, arr[j].second);
		}
		if (maxEnd != curEnd)
		    ans++;
		curEnd = maxEnd;
		i = j;
	    }
	    
	    if (valid)
		out.println(ans);
	    else
		out.println(-1);
	}

	out.flush();
	out.close();
    }

    private static class Pair implements Comparable<Pair> {
	double first;
	double second;
	public Pair(double first, double second) {
	    this.first = first;
	    this.second = second;
	}

	@Override
	public String toString() {
	    return "(" + first + ", " + second + ")";
	}

	public int compareTo(Pair o) {
	    if (Double.compare(first, o.first) != 0)
		return Double.compare(first, o.first);
	    else
		return Double.compare(o.second, second);
	}
    }


    private static class Scanner {
	BufferedReader br;
	StringTokenizer st;

	public Scanner(FileReader f) {
	    br = new BufferedReader(f);
	}

	public Scanner(InputStream in) {
	    br = new BufferedReader(new InputStreamReader(in));
	}

	public String Next() throws IOException {
	    if (st == null || !st.hasMoreTokens())
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException {
	    return Integer.parseInt(Next());
	}

	public long nextLong() throws IOException {
	    return Long.parseLong(Next());
	}

	public double nextDouble() throws IOException {
	    return Double.parseDouble(Next());
	}

	public boolean Ready() throws IOException {
	    return br.ready();
	}

    }

}
