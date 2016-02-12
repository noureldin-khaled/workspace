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

public class HeavyCycleEdges {

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	
	while(true)
	{
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    if (n == 0 && m == 0) break;
	    
	    Edge edgelist[] = new Edge[m];
	    
	    for (int i = 0; i < m; i++)
	    {
		int u = sc.nextInt();
		int v = sc.nextInt();
		int w = sc.nextInt();
		
		edgelist[i] = new Edge(u, v, w);
	    }
	    
	    Arrays.sort(edgelist);
	    ArrayList<Integer> res = new ArrayList<>();
	    
	    DisjointSets ds = new DisjointSets(n);
	    for (Edge e : edgelist)
		if (!ds.inSameSet(e.from, e.to))
		    ds.union(e.from, e.to);
		else
		    res.add(e.weight);
	    
	    Collections.sort(res);
	    boolean forest = true;
	    for (int i = 0; i < res.size(); i++)
	    {
		forest = false;
		if (i != 0)
		    out.print(" ");
		out.print(res.get(i));
	    }
	    
	    if (forest)
		out.print("forest");
	    out.println();
	}
	
	out.flush();
	out.close();
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
	int weight;
	
	public Edge(int f, int t, int w) {
	    from = f;
	    to = t;
	    weight = w;
	}

	@Override
	public int compareTo(Edge o) {
	    if (this.weight > o.weight)
		return 1;
	    if (this.weight < o.weight)
		return -1;
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
