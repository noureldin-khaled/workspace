package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class StreetDirections {
    static ArrayList<Integer> adjlist[];
    static ArrayList<Integer> res[];
    static int[] dfs_num, dfs_low, parent;
    static int dfsCounter;

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out  = new PrintWriter(System.out);

	int t = 1;
	while(true) {
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    if (n == 0 && m == 0) break;

	    adjlist = new ArrayList[n];
	    res = new ArrayList[n];
	    for (int i = 0; i < n; i++) {
		adjlist[i] = new ArrayList<>();
		res[i] = new ArrayList<>();
	    }

	    for (int i = 0; i < m; i++) {
		int u = sc.nextInt()-1;
		int v = sc.nextInt()-1;

		adjlist[u].add(v);
		adjlist[v].add(u);
	    }
	    dfs_num = new int[n];
	    dfs_low = new int[n];
	    parent = new int[n];
	    dfsCounter = 0;

	    dfs(0);

	    out.println(t++ + "\n");
	    for(int u = 0; u < n; u++) {
		Collections.sort(res[u]);
		for (int v : res[u])
		    out.printf("%d %d\n",u+1,v+1);
	    }
	    out.println("#");
	}

	out.flush();
	out.close();
    }

    public static void dfs(int u) {
	dfs_num[u] = dfs_low[u] = ++dfsCounter;

	for(int v : adjlist[u]) 
	    if (dfs_num[v] == 0) {
		parent[v] = u;
		res[u].add(v);
		dfs(v);

		if (dfs_low[v] > dfs_num[u]) 
		    res[v].add(u);
		dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
	    }
	    else
		if (parent[u] != v) {
		    if (dfs_num[u] > dfs_num[v])
			res[u].add(v);
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
