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

public class CallingCircles {
    static ArrayList<Integer>[] adjlist;
    static TreeMap<String, Integer> tm;
    static String[] names;
    static int n, dfsCounter;
    static int dfs_num[], dfs_low[];
    static Stack<Integer> stack;
    static boolean[] inSCC;
    static Stack<ArrayList<Integer>> res;

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	int t = 1;
	while(true) 
	{
	    int c = 0;
	    n = sc.nextInt();
	    int m = sc.nextInt();
	    if (n == 0 && m == 0) break;

	    if (t != 1)
		out.println();
	    adjlist = new ArrayList[n];
	    for (int i = 0; i < n; i++)
		adjlist[i] = new ArrayList<Integer>();
	    tm = new TreeMap<>();
	    names = new String[n];

	    for (int i = 0; i < m; i++)
	    {
		String first = sc.Next();
		String second = sc.Next();

		int u, v;
		if (!tm.containsKey(first)) 
		{
		    tm.put(first, c);
		    names[c] = first;
		    u = c++;
		}
		else
		    u = tm.get(first);

		if (!tm.containsKey(second)) 
		{
		    tm.put(second, c);
		    names[c] = second;
		    v = c++;
		}
		else
		    v = tm.get(second);
		adjlist[u].add(v);
	    }

	    dfs_num = new int[n];
	    dfs_low = new int[n];
	    stack = new Stack<>();
	    inSCC = new boolean[n];
	    dfsCounter = 0;
	    res = new Stack<>();
	    tarjan();

	    out.printf("Calling circles for data set %d:\n", t++);
	    while(!res.isEmpty())
	    {
		ArrayList<Integer> cur = res.pop();
		for (int i = 0; i < cur.size(); i++)
		{
		    if (i != 0)
			out.print(", ");
		    out.print(names[cur.get(i)]);
		}
		out.println();
	    }
	}

	out.flush();
	out.close();
    }

    public static void tarjan() {
	for (int i = 0; i < n; i++)
	    if (dfs_num[i] == 0)
		tarjan(i);
    }

    public static void tarjan(int u) {
	dfs_num[u] = dfs_low[u] = ++dfsCounter;
	stack.push(u);

	for(int v: adjlist[u]) 
	{
	    if(dfs_num[v] == 0)
		tarjan(v);
	    if(!inSCC[v])
		dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);	
	}
	if(dfs_num[u] == dfs_low[u]) 
	{
	    ArrayList<Integer> arr = new ArrayList<>();
	    while(true)
	    {
		int v = stack.pop();
		inSCC[v] = true;
		arr.add(v);
		if(v == u)
		    break;
	    }
	    res.push(arr);
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
