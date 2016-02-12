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

public class PlaceTheGuards {
    static ArrayList<Integer> arr[];

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	int t = Integer.parseInt(br.readLine());
	while(t-->0) {
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int v = Integer.parseInt(st.nextToken());
	    int e = Integer.parseInt(st.nextToken());

	    arr = new ArrayList[v];
	    for (int i = 0; i < v; i++) 
		arr[i] = new ArrayList<>();

	    for (int i = 0; i < e; i++) {
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());

		arr[first].add(second);
		arr[second].add(first);	
	    }
	    int color[] = new int[v];
	    Arrays.fill(color, -1);

	    boolean visited[] = new boolean[v];

	    int ans = 0;
	    boolean valid = true;
	    for (int i = 0; i < v && valid; i++) {
		if (color[i] == -1 && !visited[i]) {
		    Queue<Integer> q = new LinkedList<>();
		    q.add(i);
		    color[i] = 0;

		    boolean isBipartite = true;
		    while(!q.isEmpty() && isBipartite) {
			int parent = q.remove();
			visited[parent] = true;
			for (int j = 0; j < arr[parent].size(); j++) {
			    int child = arr[parent].get(j);
			    if (color[child] == color[parent]) {
				isBipartite = false;
				break;
			    }
			    if (color[child] == -1)
				color[child] = 1 - color[parent];

			    if (!visited[child])
				q.add(child);
			}
		    }
		    
		    if (isBipartite) {
			int count1 = 0;
			int count0 = 0;
			for (int j = 0; j < v; j++) {
			    if (color[j] == 1)
				count1++;
			    else if (color[j] == 0)
				count0++;
			    color[j] = -1;
			}
			if (count0 == 0)
			    ans += count1;
			else if(count1 == 0)
			    ans += count0;
			else
			    ans += Math.min(count1, count0);
		    }
		    else 
			valid = false;
		}
	    }

	    if (!valid)
		out.println(-1);
	    else
		out.println(ans);

	}
	out.flush();
	out.close();
    }

}
