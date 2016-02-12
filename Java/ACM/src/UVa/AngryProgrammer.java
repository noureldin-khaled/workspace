package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AngryProgrammer {
    static int[][] res;
    static int V;
    static int s, t;
    static final int IN = 0;
    static final int OUT = 1;
    static final int INF = (int)2e9;

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	while(true) {
	    int m = sc.nextInt();
	    int w = sc.nextInt();
	    if (m == 0 && w  == 0) break;

	    int arr[][] = new int[m][2];
	    int count = 0;
	    for (int i = 0; i < m; i++) 
		for (int j = 0; j < 2; j++) 
		    arr[i][j] = count++;

	    V = m*2;
	    s = 0;
	    t = V - 1;

	    res = new int[V][V];
	    for(int i = 0; i < m-2; i++) {
		int node = sc.nextInt()-1;
		int weight = sc.nextInt();

		res[arr[node][IN]][arr[node][OUT]] = weight;
		res[arr[node][OUT]][arr[node][IN]] = 0;
	    }
	    res[0][1] = INF;
	    res[1][0] = 0;
	    res[V-2][V-1] = INF;
	    res[V-1][V-2] = 0;

	    for(int i = 0; i < w; i++) {
		int u = sc.nextInt()-1;
		int v = sc.nextInt()-1;
		int weight = sc.nextInt();

		res[arr[u][OUT]][arr[v][IN]] = weight;
		res[arr[v][OUT]][arr[u][IN]] = weight;
		res[arr[u][IN]][arr[v][OUT]] = 0;
		res[arr[v][IN]][arr[u][OUT]] = 0;
	    }

	    long ans = pushRelabel();
	    out.println(ans);
	}
	out.flush();
	out.close();
    }


    static int pushRelabel() { 
	int[] level = new int[V], e = new int[V], flow[] = new int[V][V];
	level[s] = V - 1;

	Queue<Integer> q = new LinkedList<Integer>();
	boolean[] isActive = new boolean[V];
	for(int i = 0; i < V; ++i) {
	    flow[i][s] = -(flow[s][i] = e[i] = res[s][i]);
	    if(i != s && i != t && e[i] > 0) {
		isActive[i] = true;
		q.add(i);
	    }
	}

	while(!q.isEmpty()) {
	    int u = q.peek();
	    boolean pushed = false;
	    for(int v = 0; v < V && e[u] != 0; ++v)
		if(level[u] == level[v] + 1 &&  res[u][v] - flow[u][v] > 0) {
		    int df = Math.min(e[u], res[u][v] - flow[u][v]);
		    flow[u][v] += df; flow[v][u] -= df;
		    e[u] -= df; e[v] += df;
		    if(v != s && v != t && !isActive[v]) {
			isActive[v] = true;
			q.add(v);
		    }
		    pushed = true;
		}

	    if(e[u] == 0) {
		isActive[u] = false;
		q.remove();
	    }

	    if(!pushed) {
		level[u] = INF;
		for(int v = 0; v < V; ++v)
		    if(level[v] + 1 < level[u] && res[u][v] - flow[u][v] > 0)
			level[u] = level[v] + 1;
	    }
	}

	return e[t];
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
