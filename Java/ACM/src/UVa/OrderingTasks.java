package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class OrderingTasks {
    static ArrayList<Integer> arr[];
    static boolean [] visited;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	while(true){
	    String line = br.readLine();
	    if (line.equals("0 0"))
		break;

	    StringTokenizer st = new StringTokenizer(line);
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());

	    arr = new ArrayList[n];
	    for (int i = 0; i < n; i++) 
		arr[i] = new ArrayList<Integer>();

	    for (int i = 0; i < m; i++) {
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken())-1;
		int second = Integer.parseInt(st.nextToken())-1;

		arr[second].add(first);
	    }

	    visited = new boolean[n];

	    q = new LinkedList<Integer>();
	    for (int i = 0; i < visited.length; i++) {
		if (!visited[i])
		    dfs(i);
	    }

	    int size = q.size();
	    for (int i = 0; i < size; i++) {
		if (i == size-1)
		    System.out.print(q.remove()+1);
		else
		    System.out.print(q.remove()+1 + " ");
	    }
	    System.out.println();
	}
    }

    public static void dfs(int node) {
	visited[node] = true;

	for (int i = 0; i < arr[node].size(); i++) {
	    int distination = arr[node].get(i);
	    if (!visited[distination])
		dfs(distination);
	}

	q.add(node);

    }

}
