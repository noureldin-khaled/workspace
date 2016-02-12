package Spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TheShortestPath {
    static ArrayList<Pairr> graph[];
    
    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	int t = Integer.parseInt(br.readLine());

	while(t-->0) {
	    TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
	    int n = Integer.parseInt(br.readLine());
	    
	    int count = 0;
	    graph = new ArrayList[n];
	    for (int i = 0; i < n; i++) 
		graph[i] = new ArrayList<>();
	    
	    for (int i = 0; i < n; i++) {
		String node = br.readLine();
		tm.put(node, count);
		int m = Integer.parseInt(br.readLine());
		for (int j = 0; j < m; j++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int dest = Integer.parseInt(st.nextToken())-1;
		    int weight = Integer.parseInt(st.nextToken());
		    
		    graph[count].add(new Pairr(dest, weight));
		}
		count++;
	    }
	    
	    int p = Integer.parseInt(br.readLine());
	    while(p-->0) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = tm.get(st.nextToken());
		int end = tm.get(st.nextToken());
		
		if (start == end) {
		    out.println(0);
		    continue;
		}

		int dist[] = new int[n];
		Arrays.fill(dist, -1);
		PriorityQueue<Pairr> pq = new PriorityQueue<Pairr>();
		pq.add(new Pairr(start, 0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
		    Pairr cur = pq.poll();
		    if (cur.weight > dist[cur.name])
			continue;
		    for (int i = 0; i < graph[cur.name].size(); i++) {
			Pairr child = graph[cur.name].get(i);
			if (dist[child.name] == -1 || dist[cur.name] + child.weight < dist[child.name]) {
			    dist[child.name] = dist[cur.name] + child.weight;
			    pq.add(new Pairr(child.name, dist[child.name]));
			}
		    }
		}
		
		out.println(dist[end]);
	    }
	    if (t > 0)
	    br.readLine();
	}
	out.flush();
	out.close();
    }

}

class Pairr implements Comparable<Pairr>{
    int name;
    int weight;
    public Pairr(int name, int weight) {
	this.name = name;
	this.weight = weight;
    }
    @Override
    public int compareTo(Pairr o) {
	if (this.weight > o.weight)
	    return 1;
	else if (this.weight < o.weight)
	    return -1;
	else
	    return 0;
    }
    
    
}
