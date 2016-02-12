package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RACING {
    static Edge[] edgelist;
    static int n;
    
    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	int t = sc.nextInt();
	while(t-->0) 
	{
	    n = sc.nextInt();
	    int m = sc.nextInt();

	    edgelist = new Edge[m];

	    int total = 0;
	    for (int i = 0; i < m; i++)
	    {
		int u = sc.nextInt() - 1;
		int v = sc.nextInt() - 1;
		int w = sc.nextInt();

		edgelist[i] = new Edge(u, v, w);
		total += w;
	    }

	    int min_cost = kruskal();
	    out.println(total - min_cost);
	}

	out.flush();
	out.close();
    }

    public static int kruskal() {
	int min_cost = 0;
	Arrays.sort(edgelist);
	DisjointSets ds = new DisjointSets(n);
	
	for (Edge e : edgelist)
	    if (!ds.inSameSet(e.from, e.to))
	    {
		min_cost += e.weight;
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

    static class Edge implements Comparable<Edge> {
	int from;
	int to;
	int weight;

	public Edge(int from, int to, int weight) {
	    this.from = from;
	    this.to = to;
	    this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
	    if (this.weight > o.weight)
		return -1;
	    if (this.weight < o.weight)
		return 1;
	    return 0;
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
