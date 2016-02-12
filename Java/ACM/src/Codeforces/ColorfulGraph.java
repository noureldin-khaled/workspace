package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ColorfulGraph {
    static ArrayList<Integer> adjlist[];
    static int color[];
    static boolean visited[];
    static TreeSet<Integer> Q[];
    
    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	
	int n = sc.nextInt();
	int m = sc.nextInt();
	
	color = new int[n];
	adjlist = new ArrayList[n];
	for (int i = 0; i < n; i++) 
	    adjlist[i] = new ArrayList<Integer>();
	
	for (int i = 0; i < n; i++)
	    color[i] = sc.nextInt();
	
	for (int i = 0; i < m; i++) {
	    int u = sc.nextInt() - 1;
	    int v = sc.nextInt() - 1;
	    
	    adjlist[u].add(v);
	    adjlist[v].add(u);
	}
	
	visited = new boolean[n];
	Q = new TreeSet[100005];
	for (int i = 0; i < 100005; i++) 
	    Q[i] = new TreeSet<>();
	
	for (int i = 0; i < n; i++)
	    if (!visited[i])
		dfs(i);
	
	
	int ans = -1;
	long max = -1;
	Arrays.sort(color);
	for (int i = 0; i < n; i++) {
	    int s = Q[color[i]].size();
	    if (s > max) {
		max = s;
		ans = color[i];
	    }
	}
	System.out.println(ans);
    }
    
    public static void dfs(int u) {
	visited[u] = true;
	
	for (int v : adjlist[u]) {
	    if (color[v] != color[u] && !Q[color[u]].contains(color[v]))
		Q[color[u]].add(color[v]);
	    if (!visited[v])
		dfs(v);
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
