package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TwoButtons {
    
    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	
	int start = sc.nextInt();
	int target = sc.nextInt();
	
	int dist[] = new int[100000];
	Arrays.fill(dist,-1);
	
	Queue<Integer> q = new LinkedList<Integer>();
	dist[start] = 0;
	q.add(start);
	while(!q.isEmpty()) {
	    int u = q.remove();
	    if (u == target) 
		break;
	    
	    int v = u*2;
	    
	    if (v <= 10010 && dist[v] == -1) {
		dist[v] = dist[u] + 1;
		q.add(v);
	    }
	    
	    v = u-1;
	    if (v > 0 && dist[v] == -1) {
		dist[v] = dist[u] + 1;
		q.add(v);
	    }
	}
	
	out.println(dist[target]);
	
	out.flush();
	out.close();
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
