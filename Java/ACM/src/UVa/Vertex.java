package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Vertex {

    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder ans = new StringBuilder();

	while(true){
	    int n = Integer.parseInt(in.readLine());

	    if (n == 0)
		break;

	    adj = new ArrayList[n];

	    for (int i = 0; i < n; i++) 
		adj[i] = new ArrayList<Integer>();

	    StringTokenizer s; 

	    while(true){
		String line = in.readLine();

		if(line.equals("0"))
		    break;

		s = new StringTokenizer(line);

		int src = Integer.parseInt(s.nextToken()) - 1;

		while(true){
		    int dist = Integer.parseInt(s.nextToken()) - 1;

		    if(dist == -1)
			break;

		    adj[src].add(dist);
		}
	    }

	    s = new StringTokenizer(in.readLine());

	    int v = Integer.parseInt(s.nextToken());


	    for (int i = 0; i < v; i++) {
		int count = 0;

		visited = new boolean[n];

		int node = Integer.parseInt(s.nextToken())-1;

		dfs(node);

		for (int j = 0; j < n; j++) 
		    if (!visited[j])
			count++;

		ans.append(count);

		for (int j = 0; j < n; j++) 
		    if (!visited[j])
			ans.append(" ").append(j + 1);

		ans.append("\n");

	    }
	}
	System.out.print(ans);
    }

    public static void dfs(int node) {

	for (int i = 0; i < adj[node].size(); i++) {
	    int dist = adj[node].get(i);
	    if (!visited[dist]) {
		visited[dist] = true;
		dfs(dist);
	    }
	}

    }
}
