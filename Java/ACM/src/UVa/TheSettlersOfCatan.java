package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheSettlersOfCatan {
    static boolean arr[][];
    static boolean visited[][];
    static int n;
    
    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	
	while(true) {
	    n = sc.nextInt();
	    int m = sc.nextInt();
	    if (n == 0 && m == 0)
		break;
	    
	    arr = new boolean[n][n];
	    visited = new boolean[n][n];
	    
	    for (int i = 0; i < m; i++) {
		int s = sc.nextInt();
		int e = sc.nextInt();
		
		arr[s][e] = true;
		arr[e][s] = true;
	    }
	    
	    int ans = 0;
	    for (int i = 0; i < n; i++) 
		ans = Math.max(ans, rec(i));
	    
	    out.println(ans);
	}
	
	out.flush();
	out.close();
    }
   

    public static int rec(int node) {
	int max = 0;
	
	for (int i = 0; i < n; i++) {
	    if (arr[node][i] && !visited[node][i]) {
		visited[node][i] = true;
		visited[i][node] = true;
		
		max = Math.max(max, 1+rec(i));
		visited[node][i] = false;
		visited[i][node] = false;
	    }
	}
	
	return max;
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

	public String nextLine() throws IOException {
	    return br.readLine();
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

	public void waitForInput(long time) {
	    long ct = System.currentTimeMillis();
	    while(System.currentTimeMillis() - ct < time) {};
	}

    }

}
