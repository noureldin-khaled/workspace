package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class CoinRobbery {
    static final int INF = (int)1e9;
    static ArrayList<Node> original[];
    static int[][] res;
    static int[] dist_going;
    static int[] dist_coming;
    static int n;
    static int V;
    static int[][] arr;
    static final int IN = 0;
    static final int OUT = 1;
    static int s, t;

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	n = sc.nextInt();
	int m = sc.nextInt();

	original = new ArrayList[n];
	for (int i = 0; i < n; i++)
	    original[i] = new ArrayList<>();

	for (int i = 0; i < m; i++)
	{
	    int u = sc.nextInt();
	    int v = sc.nextInt();
	    int w = sc.nextInt();

	    original[u].add(new Node(v, w));
	    original[v].add(new Node(u, w));
	}

	dijkstra();

	int mf = pushRelabel();
	if (mf >= INF)
	    System.out.println("IMPOSSIBLE");
	else
	    System.out.println(mf);
    }

    public static int pushRelabel() {
	int level[] = new int[V];
	int e[] = new int[V];
	int flow[][] = new int[V][V];

	level[s] = V-1;

	Queue<Integer> q = new LinkedList<>();
	boolean isActive[] = new boolean[V];
	for (int i = 0; i < n; i++)
	{
	    flow[i][s] = -(flow[s][i] = e[i] = res[s][i]);
	    if(i != s && i != t && e[i] > 0) 
	    {
		isActive[i] = true;
		q.add(i);
	    }
	}

	while(!q.isEmpty())
	{
	    int u = q.peek();
	    boolean pushed = false;
	    for (int v = 0; v < V && e[u] != 0; v++)
		if (level[u] == level[v] + 1 && res[u][v] - flow[u][v] > 0)
		{
		    int df = Math.min(e[u], res[u][v] - flow[u][v]);
		    flow[u][v] += df; flow[v][u] -= df;
		    e[u] -= df; e[v] += df;
		    if(v != s && v != t && !isActive[v]) 
		    {
			isActive[v] = true;
			q.add(v);
		    }
		    pushed = true;
		}

	    if(e[u] == 0) 
	    {
		isActive[u] = false;
		q.remove();
	    }
	    
	    if (!pushed)
	    {
		level[u] = INF;
		for (int v = 0; v < V; v++)
		    if(level[v] + 1 < level[u] && res[u][v] - flow[u][v] > 0)
			level[u] = level[v] + 1;
	    }
	}
	return e[t];
    }

    public static void dijkstra() 
    {
	dist_going = new int[n];
	Arrays.fill(dist_going, INF);
	PriorityQueue<Node> pq = new PriorityQueue<>();
	dist_going[0] = 0;
	pq.add(new Node(0, 0));

	while(!pq.isEmpty()) 
	{
	    Node cur = pq.remove();
	    if (cur.name == n-1)
		break;
	    if (cur.cost > dist_going[cur.name])
		continue;

	    for (Node nxt : original[cur.name])
		if (cur.cost + nxt.cost < dist_going[nxt.name])
		{
		    dist_going[nxt.name] = cur.cost + nxt.cost;
		    pq.add(new Node(nxt.name, dist_going[nxt.name]));
		}
	}

	int shortest_weight = dist_going[n-1];

	dist_coming = new int[n];
	Arrays.fill(dist_coming, INF);
	pq = new PriorityQueue<>();
	dist_coming[n-1] = 0;
	pq.add(new Node(n-1, 0));

	while(!pq.isEmpty())
	{
	    Node cur = pq.remove();
	    if (cur.name == 0)
		break;
	    if (cur.cost > dist_coming[cur.name])
		continue;

	    for (Node nxt : original[cur.name])
		if (cur.cost + nxt.cost < dist_coming[nxt.name])
		{
		    dist_coming[nxt.name] = cur.cost + nxt.cost;
		    pq.add(new Node(nxt.name, dist_coming[nxt.name]));
		}
	}

	ArrayList<Integer> temp[] = new ArrayList[n];
	for (int i = 0; i < n; i++)
	    temp[i] = new ArrayList<>();

	for (int u = 0; u < n; u++)
	    for (Node v : original[u])
	    {
		if (dist_going[u] + dist_coming[v.name] + v.cost == shortest_weight)
		{
		    temp[u].add(v.name);
		    temp[v.name].add(u);
		}
	    }

	V = n*2;
	
	res = new int[V][V];
	int arr[][] = new int[n][2];
	int c = 0;
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < 2; j++)
		arr[i][j] = c++;

	s = arr[0][IN];
	t = arr[n-1][OUT];
	
	for (int u = 0; u < n; u++)
	    for (int i = 0; i < temp[u].size(); i++)
	    {
		int v = temp[u].get(i);
		res[arr[u][OUT]][arr[v][IN]] = INF;
	    }

	for (int i = 0; i < n; i++)
	    res[arr[i][IN]][arr[i][OUT]] = 1;

	res[arr[0][IN]][arr[0][OUT]] = INF;
	res[arr[n-1][IN]][arr[n-1][OUT]] = INF;

    }

    static class Node implements Comparable<Node> {
	int name, cost;

	public Node(int n, int c) {
	    name = n;
	    cost = c;
	}

	@Override
	public int compareTo(Node o) {
	    if (cost != o.cost)
		return cost - o.cost;
	    return name - o.cost;
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


