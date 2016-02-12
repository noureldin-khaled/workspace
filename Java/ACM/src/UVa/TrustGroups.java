package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TrustGroups {
    static ArrayList<Integer>[] adjlist;
    static int[] dfs_num, dfs_low;
    static int dfsCounter;
    static boolean[] inSCC;
    static int SCCs;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	while(true) {
	    int p = sc.nextInt();
	    int t = sc.nextInt();
	    if (p == 0 && t == 0) break;

	    adjlist = new ArrayList[p];
	    for (int i = 0; i < p; i++) 
		adjlist[i] = new ArrayList<Integer>();

	    TreeMap<String, Integer> tm = new TreeMap<>();
	    for (int i = 0; i < p; i++) 
		tm.put(sc.nextLine(), i);

	    for (int i = 0; i < t; i++) {
		int u = tm.get(sc.nextLine());
		int v = tm.get(sc.nextLine());

		adjlist[u].add(v);
	    }
	    dfs_num = new int[p];
	    dfs_low = new int[p];
	    inSCC = new boolean[p];
	    dfsCounter = 0;
	    SCCs = 0;
	    stack = new Stack<Integer>();

	    for (int i = 0; i < p; i++)
		if (dfs_num[i] == 0)
		    tarjanSCC(i);

	    out.println(SCCs);
	}

	out.flush();
	out.close();

    }

    public static void tarjanSCC(int u) {
	dfs_num[u] = dfs_low[u] = ++dfsCounter;
	stack.push(u);

	for (int v : adjlist[u]) {
	    if (dfs_num[v] == 0)
		tarjanSCC(v);
	    if (!inSCC[v])
		dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
	}
	if (dfs_num[u] == dfs_low[u]) {
	    while(true) {
		int elem = stack.pop();
		inSCC[elem] = true;
		if (elem == u)
		    break;
	    }
	    SCCs++;
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
