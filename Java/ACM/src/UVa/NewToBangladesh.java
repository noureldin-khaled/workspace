package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NewToBangladesh {
    static final int INF = (int)1e9;
    
    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	
	int t = sc.nextInt();
	while(t-->0) {
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    
	    int [][] adjTime = new int[n][n];
	    int [][] adjDistance = new int[n][n];
	    
	    for (int i = 0; i < n; i++) 
		Arrays.fill(adjTime[i], INF);
	    
	    for (int i = 0; i < n; i++) 
		Arrays.fill(adjDistance[i], INF);
	    
	    for (int i = 0; i < n; i++) {
		adjTime[i][i] = 0;
		adjDistance[i][i] = 0;
	    }
	    
	    for (int i = 0; i < m; i++) {
		int u = sc.nextInt()-1;
		int v = sc.nextInt()-1;
		int time = sc.nextInt();
		int distance = sc.nextInt();
		
		if (adjTime[u][v] > time || (adjTime[u][v] == time && adjDistance[u][v] > distance)) {
		    adjTime[u][v] = adjTime[v][u] =  time;
		    adjDistance[u][v] = adjDistance[v][u] =  distance;
		}
	    }
	    
	    for(int k = 0; k < n; k++)
		    for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
			    if(adjTime[i][j] > adjTime[i][k] + adjTime[k][j]) {
				adjTime[i][j] = adjTime[i][k] + adjTime[k][j];
				adjDistance[i][j] = adjDistance[i][k] + adjDistance[k][j];
			    }
			    else if (adjTime[i][j] == adjTime[i][k] + adjTime[k][j] && adjDistance[i][j] > adjDistance[i][k] + adjDistance[k][j])
				adjDistance[i][j] = adjDistance[i][k] + adjDistance[k][j];
	    
	    int q = sc.nextInt();
	    while(q-->0) {
		int u = sc.nextInt()-1;
		int v = sc.nextInt()-1;
		
		if (adjTime[u][v] != INF && adjDistance[u][v] != INF)
		    out.printf("Distance and time to reach destination is %d & %d.\n",adjDistance[u][v], adjTime[u][v]);
		else
		    out.println("No Path.");
	    }
	    
	    if (t > 0)
		out.println();
	}
	
	out.flush();
	out.close();
    }
    
    static class Scanner {
	    BufferedReader br;
	    StringTokenizer st;

	    public Scanner(FileReader f) {
		br = new BufferedReader(f);
	    }

	    public Scanner(InputStream in) {
		br = new BufferedReader(new InputStreamReader(in));
	    }

	    public String Next() throws IOException {
		while (st == null || !st.hasMoreTokens())
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
