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

public class FullTank {
    static final int INF = (int)2e9;

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	sc.waitForInput(3000);

	while(sc.Ready())
	{
	    int n = sc.nextInt();
	    int m = sc.nextInt();

	    int[] costs = new int[n];
	    for (int i = 0; i < n; i++)
		costs[i] = sc.nextInt();

	    ArrayList<Edge>[] adjList = new ArrayList[n];
	    for (int i = 0; i < n; i++) 
		adjList[i] = new ArrayList<>();


	    for (int i = 0; i < m; i++) 
	    {
		int src = sc.nextInt();
		int dest = sc.nextInt();
		int length = sc.nextInt();

		adjList[src].add(new Edge(dest, length));
		adjList[dest].add(new Edge(src, length));
	    }

	    int q = sc.nextInt();
	    while(q-->0) 
	    {
		int capacity = sc.nextInt();
		int src = sc.nextInt();
		int dest = sc.nextInt();

		//dijksa
		
		int[][] dist = new int[n][capacity+1];
		for (int i = 0; i < n; i++)
		    	Arrays.fill(dist[i], INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		dist[src][0] = 0;
		pq.add(new Node(src, 0, 0));
		
		int ans = INF;
		while(!pq.isEmpty())
		{
		    Node cur = pq.remove();
		    
		    if (cur.name == dest)
		    {
			ans = cur.cost;
			break;
		    }
		    
		    if (cur.cost > dist[cur.name][cur.liters])
			continue;
		    
		    for (Edge nxt : adjList[cur.name])
		    {
			if (cur.liters >= nxt.length) // edge of weight 0 between cur and nxt
			{
			    if (cur.cost < dist[nxt.name][cur.liters - nxt.length]) 
			    {
				dist[nxt.name][cur.liters - nxt.length] = cur.cost;
				pq.add(new Node(nxt.name, cur.liters - nxt.length, dist[nxt.name][cur.liters - nxt.length]));
			    }
			}
		    }
		    
		    int i = 1;
		    while(cur.liters + i <= capacity)
		    {
			if (cur.cost + i*costs[cur.name] < dist[cur.name][cur.liters+i])
			{
			    dist[cur.name][cur.liters + i] = cur.cost + i*costs[cur.name];
			    pq.add(new Node(cur.name, cur.liters + i, dist[cur.name][cur.liters + i]));
			}
			i++;
		    }
		}
		
		out.println(ans == INF ? "impossible" : ans);
	    }

	    out.flush();
	    out.close();
	}
    }
    
    private static class Node implements Comparable<Node> {
	int name, liters, cost;

	public Node(int name, int liters, int cost){
	    this.name = name;
	    this.liters = liters;
	    this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
	    if (this.cost > o.cost)
		return 1;
	    else if (this.cost < o.cost)
		return -1;
	    return this.name - o.name;
	}

	@Override
	public String toString() {
	    return "(" + name + ", " + liters + ", " + cost + ")";
	}
    }

    private static class Edge {
	int name, length;

	public Edge(int name, int length){
	    this.name = name;
	    this.length = length;
	}

	@Override
	public String toString() {
	    return "(" + name + ", " + length + ")";
	}
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
