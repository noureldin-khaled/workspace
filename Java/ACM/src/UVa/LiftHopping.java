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

public class LiftHopping {
    static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	sc.waitForInput(3000);
	while(sc.Ready())
	{
	    int n = sc.nextInt();
	    int k = sc.nextInt();

	    int T[] = new int[n];
	    for (int i = 0; i < n; i++)
		T[i] = sc.nextInt();

	    Pair arr[][] = new Pair[101][n];
	    for (int i = 0; i < 101; i++)
		for (int j = 0; j < n; j++)
		    arr[i][j] = new Pair();

	    for (int i = 0; i < n; i++)
	    {
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		ArrayList<Integer> cur = new ArrayList<>();
		while(st.hasMoreTokens())
		    cur.add(Integer.parseInt(st.nextToken()));

		int size = cur.size();
		for (int j = 0; j < size; j++)
		{
		    if (j < size - 1)
			arr[cur.get(j)][i].next = cur.get(j+1);
		    if (j > 0)
			arr[cur.get(j)][i].previous = cur.get(j-1);
		}
	    }

	    int dist[][] = new int[101][n];
	    for (int i = 0; i < 101; i++)
		Arrays.fill(dist[i], INF);
	    
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	    for (int i = 0; i < n; i++)
		if (arr[0][i].next != -1)
		{
		    dist[0][i] = 0;
		    pq.add(new Node(0, i, 0));
		}
	    
	    int ans = -1;
	    while(!pq.isEmpty())
	    {
		Node cur = pq.remove();
		if (cur.name == k)
		{
		    ans = cur.cost;
		    break;
		}

		if (cur.cost > dist[cur.name][cur.elevator])
		    continue;

		for (int i = 0; i < n; i++)
		{
		    if (arr[cur.name][i].next != -1)
		    {
			int next_node = arr[cur.name][i].next;
			int next_cost = T[i] * Math.abs(next_node - cur.name);
			if (cur.elevator != i)
			    next_cost += 60;
			
			if (cur.cost + next_cost < dist[next_node][i])
			{
			    dist[next_node][i] = cur.cost + next_cost;
			    pq.add(new Node(next_node, i, dist[next_node][i]));
			}
		    }
		    
		    if (arr[cur.name][i].previous != -1)
		    {
			int next_node = arr[cur.name][i].previous;
			int next_cost = T[i] * Math.abs(next_node - cur.name);
			if (cur.elevator != i)
			    next_cost += 60;
			
			if (cur.cost + next_cost < dist[next_node][i])
			{
			    dist[next_node][i] = cur.cost + next_cost;
			    pq.add(new Node(next_node, i, dist[next_node][i]));
			}
		    }
		}
	    }

	    out.println(ans == -1 ? "IMPOSSIBLE" : ans);
	}

	out.flush();
	out.close();
    }
    
    static class Pair {
	int next;
	int previous;
	
	public Pair() {
	    next = -1;
	    previous = -1;
	}
	
	@Override
	public String toString() {
	    return "(" + next + ", " + previous + ")";
	}
    }

    static class Node implements Comparable<Node> {
	int name;
	int elevator;
	int cost;

	public Node(int n, int e, int c) {
	    name = n;
	    elevator = e;
	    cost = c;
	}

	@Override
	public int compareTo(Node o) {
	    return cost - o.cost;
	}
	
	@Override
	public String toString() {
	    return "(" + name + ", " + elevator + ", " + cost + ")";
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
