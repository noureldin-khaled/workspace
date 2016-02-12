package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class DarkRoads {
    static ArrayList<Edge> edgelist;
    static int n;

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	while(true) {
	    n = sc.nextInt();
	    int m = sc.nextInt();
	    if (n == 0 && m == 0) break;
	    
	    edgelist = new ArrayList<>();
	    long total_cost = 0;
	    for (int i = 0; i < m; i++) {
		int u = sc.nextInt();
		int v = sc.nextInt();
		int cost = sc.nextInt();

		edgelist.add(new Edge(u, v, cost));
		total_cost += cost;
	    }

	    long min_cost = kruskal();
	    out.println(total_cost - min_cost);
	}

	out.flush();
	out.close();
    }

    public static long kruskal() {
	long min_cost = 0;
	
	Collections.sort(edgelist);
	DisjointSets ds = new DisjointSets(n);
	for (Edge e : edgelist) 
	    if (!ds.inSameSet(e.from, e.to)) {
		min_cost += e.cost;
		ds.union(e.from, e.to);
	    }
	
	return min_cost;
    }

    static class DisjointSets {
	int representative[];
	int rank[];

	public DisjointSets(int n) {
	    representative = new int[n];
	    rank = new int[n];
	    for (int i = 0; i < representative.length; i++)
		representative[i] = i;
	    Arrays.fill(rank, 1);
	}

	int findSet(int x) {
	    if (x == representative[x])
		return x;
	    return representative[x] = findSet(representative[x]);
	}

	boolean inSameSet(int x,int y){
	    return (findSet(x) == findSet(y));
	}

	void union(int x, int y) {
	    int x1 = findSet(x);
	    int y1 = findSet(y);
	    if (x1 != y1)
		if (rank[x1] > rank[y1]) {
		    representative[y1] = x1;
		} else if (rank[x1] < rank[y1]) {
		    representative[x1] = y1;
		} else {
		    representative[x1] = y1;
		    rank[y1]++;
		}
	}
    }


    static class Edge implements Comparable<Edge>{
	int from;
	int to;
	int cost;

	public Edge(int f, int t, int c) {
	    from = f;
	    to = t;
	    cost = c;
	}

	@Override
	public int compareTo(Edge o) {
	    return cost - o.cost;
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
