package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ClawDecomposition {
    static ArrayList<Integer> arr[];
    static int[]color;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	while(true){
	    String line = br.readLine();
	    if (line.equals("0"))
		break;
	    int N = Integer.parseInt(line);

	    arr = new ArrayList[N];
	    for (int i = 0; i < arr.length; i++) 
		arr[i] = new ArrayList<>();

	    while(true){
		String edge = br.readLine();
		if (edge.equals("0 0"))
		    break;
		StringTokenizer st = new StringTokenizer(edge);
		int first = Integer.parseInt(st.nextToken())-1;
		int second = Integer.parseInt(st.nextToken())-1;

		arr[first].add(second);
		arr[second].add(first);
	    }

	    color = new int[N];
	    Arrays.fill(color, -1);
	    visited = new boolean[N];

	    Queue<Integer> q = new LinkedList<Integer>();
	    q.add(0);
	    color[0] = 0;

	    boolean isBipartite = true;
	    while(!q.isEmpty() && isBipartite){
		int parent = q.remove();
		visited[parent] = true;
		for (int i = 0; i < arr[parent].size(); i++) {
		    int child = arr[parent].get(i);
		    if (color[child] == color[parent]){
			isBipartite = false;
			break;
		    }
		    if (color[child] == -1)
			color[child] = 1 - color[parent];	

		    if (!visited[child])
			q.add(child);
		}
	    }

	    if (isBipartite)
		out.println("YES");
	    else
		out.println("NO");
	}
	out.flush();
	out.close();
    }

}
