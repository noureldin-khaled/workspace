package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class RoughRoads {
    static ArrayList<Edge> adjlist[];
    static long dist[][];
    static int n;
    static final int WALKING = 0;
    static final int BIKE = 1;

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	sc.waitForInput(3000);
	int set = 1;
	while(sc.Ready()) {
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
		adjlist[v].add(new Edge(u, cost));
	    }

	    dijksra();
	    out.printf("Set #%d\n",set++);
	    out.println(dist[n-1][BIKE] == -1 ? "?" : dist[n-1][BIKE]);

	}

	out.flush();
	out.close();
    }

    public static void dijksra() {
	PriorityQueue<Node> pq = new PriorityQueue<>(2*n + 100);
	dist = new long[n][2];
	for (int i = 0; i < n; i++) 
	    Arrays.fill(dist[i], -1);

	dist[0][BIKE] = 0;
	pq.add(new Node(0, 0, BIKE));

	while(!pq.isEmpty()) {
	    Node cur = pq.remove();
	    if(cur.name == n-1 && cur.method == BIKE)
		break;
	    if(cur.cost > dist[cur.name][cur.method])
		continue;
	    int newMethod = 1 - cur.method;
	    for(Edge nxt: adjlist[cur.name])
		if(dist[nxt.node][newMethod] == -1 || dist[cur.name][cur.method] + nxt.cost < dist[nxt.node][newMethod]) {
		    dist[nxt.node][newMethod] = dist[cur.name][cur.method] + nxt.cost;
		    pq.add(new Node(nxt.node, dist[nxt.node][newMethod], newMethod));
		}
	}
    }

    static class Node implements Comparable<Node>{
	int name;
	long cost;
	int method;

	public Node(int n, long c, int m) {
	    name = n;
	    cost = c;
	    method = m;
	}

	@Override
	public int compareTo(Node o) {
	    if(cost != o.cost)
		return Long.compare(cost, o.cost);
	    return name - o.name;
	}
    }

    static class Edge{
	int node;
	long cost;

	public Edge(int n, long c) {
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
