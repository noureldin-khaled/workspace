package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Dijkstra {
    static ArrayList<Node> adjList[];

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int e = Integer.parseInt(st.nextToken());

	adjList = new ArrayList[n];

	for (int i = 0; i < adjList.length; i++) 
	    adjList[i] = new ArrayList<Node>();


	for (int i = 0; i < e; i++) {
	    st = new StringTokenizer(br.readLine());
	    int first = Integer.parseInt(st.nextToken())-1;
	    int second = Integer.parseInt(st.nextToken())-1;
	    int w = Integer.parseInt(st.nextToken());

	    adjList[first].add(new Node(second, w));
	    adjList[second].add(new Node(first, w));
	}

	long dist[] = new long[n];
	Arrays.fill(dist, -1);
	
	int parent[] = new int[n];

	PriorityQueue<Node> pq = new PriorityQueue<Node>();
	pq.add(new Node(0, 0));
	dist[0] = 0;

	Arrays.fill(parent, -1);

	while(!pq.isEmpty()) {
	    Node cur = pq.poll();
	    if (cur.weight > dist[cur.name])
		continue;
	    for (int i = 0; i < adjList[cur.name].size(); i++) {
		Node child = adjList[cur.name].get(i);
		if (dist[child.name] == -1 || dist[cur.name] + child.weight < dist[child.name]) {
		    dist[child.name] = dist[cur.name] + child.weight;
		    parent[child.name] = cur.name;
		    pq.add(new Node(child.name, dist[child.name]));
		}
	    }
	}
	if (parent[n-1] == -1)
	    System.out.println(-1);
	else {
	    Stack<Integer> s = new Stack<>();
	    int tmp = n-1;
	    while(tmp != -1) {
		s.push(tmp);
		tmp = parent[tmp];
	    }

	    while(!s.isEmpty()) {
		System.out.print(s.pop()+ 1 + " ");
	    }

	}
    }

}


class Node implements Comparable<Node>{
    int name;
    long weight;
    public Node(int name,long weight) {
	this.name = name;
	this.weight = weight;
    }
    @Override
    public int compareTo(Node o) {
	if (this.weight < o.weight)
	    return -1;
	if (this.weight > o.weight)
	    return 1;
	return this.name-o.name;
    }

    public String toString() {
	return "(" + name + ", " + weight + ")";
    }
}
