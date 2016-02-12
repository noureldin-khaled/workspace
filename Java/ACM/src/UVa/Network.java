package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Network {
    static boolean[][] adjMat;
    static int[] dfs_num, dfs_low, parent;
    static int dfsNumberCounter, n;
    static boolean[] articulationPoint;
    static int root, rootChildren;

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	while(true) {
	    n = sc.nextInt();
	    if (n == 0)
		break;

	    adjMat = new boolean[n][n];

	    while(true) {
		String line = sc.nextLine();
		if (line.equals("0")) break;

		StringTokenizer st = new StringTokenizer(line);
		int u = Integer.parseInt(st.nextToken())-1;

		while(st.hasMoreTokens()) {
		    int v = Integer.parseInt(st.nextToken())-1;
		    adjMat[u][v] = adjMat[v][u] = true;
		}
	    }

	    dfs_low = new int[n];
	    dfs_num = new int[n];
	    parent = new int[n];
	    dfsNumberCounter = 0;
	    articulationPoint = new boolean[n];

	    for(int i = 0; i < n; i++) 
		if (dfs_num[i] == 0) { 
		    root = i;
		    rootChildren = 0;
		    dfs(i);
		    if (rootChildren <= 1)
			articulationPoint[i] = false;
		}


	    int ans = 0;
	    for (int i = 0; i < n; i++) 
		if (articulationPoint[i])
		    ans++;

	    out.println(ans);
	}

	out.flush();
	out.close();
    }

    public static void dfs(int u) {
	dfs_num[u] = dfs_low[u] = ++dfsNumberCounter;

	for(int v = 0; v < n; v++) {
	    if (adjMat[u][v]) 
		if (dfs_num[v] == 0) {
		    parent[v] = u;
		    if (u == root)
			rootChildren++;
		    dfs(v);
		    if (dfs_low[v] >= dfs_num[u])
			articulationPoint[u] = true;
		    dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
		}
		else 
		    if (parent[u] != v)
			dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
	}
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
