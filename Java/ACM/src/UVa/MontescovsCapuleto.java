package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MontescovsCapuleto {
    static ArrayList<Integer>[] adjlist;
    static int[] color;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	int t = sc.nextInt();

	while(t-->0) {
	    n = sc.nextInt();
	    adjlist = new ArrayList[n];
	    for (int i = 0; i < n; i++) 
		adjlist[i] = new ArrayList<>();

	    for (int u = 0; u < n; u++) {
		int p = sc.nextInt();
		while(p-->0) {
		    int v = sc.nextInt()-1;
		    if (v < 0 || v >= n) continue;
		    adjlist[u].add(v);
		    adjlist[v].add(u);
		}
	    }

	    long ans = 0;
	    visited = new boolean[n];
	    for(int i = 0; i < n; i++)
		if (!visited[i]) {
		    if (isBipartite(i)) {
			int zero = 0;
			int one = 0;
			for (int j = 0; j < n; j++) 
			    if (color[j] == 1)
				one++;
			    else if (color[j] == 0)
				zero++;
			
			ans += Math.max(one, zero);
		    }
		}
	    
	    out.println(ans);
	}

	out.flush();
	out.close();
    }

    static boolean isBipartite(int s) {
	color = new int[n];
	Arrays.fill(color, -1);

	Queue<Integer> q = new LinkedList<Integer>();
	q.add(s);
	color[s] = 0;
	boolean valid = true;
	
	while(!q.isEmpty()){
	    int parent = q.remove();
	    visited[parent] = true;
	    for (int child : adjlist[parent]) {
		if (color[child] == color[parent])
		    valid = false;

		if (color[child] == -1)
		    color[child] = 1 - color[parent];	

		if (!visited[child])
		    q.add(child);
	    }
	}
	
	return valid;
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
