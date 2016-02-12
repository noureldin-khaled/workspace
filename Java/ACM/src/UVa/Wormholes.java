package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Wormholes {
    static final int INF = (int)1e9;
    static ArrayList<Edge> adjlist[];
    static int dist[];
    static int n;

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	int t = sc.nextInt();
	while(t-->0) {
	    n = sc.nextInt();
	    int m = sc.nextInt();

	    adjlist = new ArrayList[n];
	    for (int i = 0; i < n; i++) 
		adjlist[i] = new ArrayList<>();

	    for (int i = 0; i < m; i++) {
		int u = sc.nextInt();
		int v = sc.nextInt();
		int cost = sc.nextInt();

		adjlist[u].add(new Edge(v, cost));
	    }

	    dist = new int[n];
	    Arrays.fill(dist, INF);
	    boolean possible = false;
	    for (int i = 0; i < n && !possible; i++) 
		if (dist[i] == INF)
		    if (bellmanford(i))
			possible = true;

	    out.println(possible ? "possible" : "not possible");
	}

	out.flush();
	out.close();
    }

    public static boolean bellmanford(int s) {
	dist[s] = 0;
	boolean modified = true;
	for(int i = 0; modified && i < n-1; i++) {
	    modified = false;
	    for (int u = 0; u < n; u++) 
		for (Edge next : adjlist[u]) 
		    if (dist[u] + next.cost < dist[next.node]) {
			modified = true;
			dist[next.node] = dist[u] + next.cost;
		    }
	}

	boolean negative_cycle_exists = false;
	for(int u = 0; u < n; u++)
	    for(Edge nxt: adjlist[u])
		if(dist[u] + nxt.cost < dist[nxt.node])
		    negative_cycle_exists = true;
	return negative_cycle_exists;
    }

    static class Edge {
	int node, cost;
	public Edge(int n, int c) {
	    node = n;
	    cost = c;
	}

	@Override
	public String toString() {
	    return "(" + node + ", " + cost + ")";
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
