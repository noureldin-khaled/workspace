package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Beverages {
    static ArrayList<Integer> []arr;
    static boolean [] visited;

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	int t = 0;
	while(br.ready()){
	    int N = Integer.parseInt(br.readLine());
	    arr = new ArrayList[N];

	    for (int i = 0; i < arr.length; i++) 
		arr[i] = new ArrayList<>();

	    TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
	    String [] tmRev = new String[N];
	    int count = 0;
	    for (int i = 0; i < N; i++) {
		String line = br.readLine();
		tmRev[count] = line;
		tm.put(line, count++);
	    }

	    int M = Integer.parseInt(br.readLine());
	    for (int i = 0; i < M; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		String first = st.nextToken();
		String second = st.nextToken();

		arr[tm.get(first)].add(tm.get(second));
	    }


	    int indegrees[] = new int[N];
	    for (int i = 0; i < arr.length; i++) 
		for (int j = 0; j < arr[i].size(); j++) 
		    indegrees[arr[i].get(j)]++;

	    Queue<Integer> tsort_queue = new LinkedList<>();
	    ArrayList<Integer> sorted = new ArrayList<>();

	    for (int i = 0; i < indegrees.length; i++) {
		if (indegrees[i] == 0){
		    tsort_queue.add(i);
		    break;
		}
	    }

	    visited = new boolean[N];
	    while(!tsort_queue.isEmpty()){
		int front = tsort_queue.remove();
		sorted.add(front);
		visited[front] = true;
		for (int i = 0; i < arr[front].size(); i++) {
		    int child = arr[front].get(i);
		    indegrees[child]--;
		}
		for (int i = 0; i < indegrees.length; i++) 
		    if (indegrees[i] == 0 && !visited[i]){
			tsort_queue.add(i);
			break;
		    }

	    }

	    t++;
	    out.print("Case #" + t + ": Dilbert should drink beverages in this order:");
	    for (int i = 0; i < sorted.size(); i++) 
		out.print(" " + tmRev[sorted.get(i)]);
	    out.println(".");
	    out.println();
	    br.readLine();
	}
	out.flush();
	out.close();
    }

}
