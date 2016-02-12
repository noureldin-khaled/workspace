package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ItIsAllAboutWisdom {
    static class Node implements Comparable<Node> {
	int name;
	long cost;
	int wisdom;

	public Node(int name, long cost, int wisdom) {
	    this.name = name;
	    this.cost = cost;
	    this.wisdom = wisdom;
	}

	@Override
	public int compareTo(Node o) {
	    if (this.cost > o.cost)
		return 1;
	    else if (this.cost < o.cost)
		return -1;
	    else 
		return 0;
	}

	@Override
	public String toString() {
	    return "(" + name + ", " + cost + ", " + wisdom + ")";
	}
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	int t = Integer.parseInt(br.readLine());
	while(t-->0) {
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());

	    ArrayList<Node> arr[] = new ArrayList[n];
	    for (int i = 0; i < n; i++) 
		arr[i] = new ArrayList<>();

	    int max = 0;
	    for (int i = 0; i < m; i++) {
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken())-1;
		int second = Integer.parseInt(st.nextToken())-1;
		int cost = Integer.parseInt(st.nextToken());
		int wisdom = Integer.parseInt(st.nextToken());

		arr[first].add(new Node(second, cost, wisdom));
		arr[second].add(new Node(first, cost, wisdom));	

		max = Math.max(max, wisdom);
	    }

	    int low = 1;
	    int high = max;
	    int ans = -1;

	    while(low <= high) {
		int mid = low + (high-low)/2;

		//Dijksra
		long dist[] = new long[n];
		Arrays.fill(dist, -1);
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(0, 0, 0));
		dist[0] = 0;

		while(!pq.isEmpty()) {
		    Node cur = pq.poll();
		    if (cur.cost > dist[cur.name])
			continue;
		    for (int i = 0; i < arr[cur.name].size(); i++) {
			Node child = arr[cur.name].get(i);
			if (child.wisdom <= mid && (dist[child.name] == -1 || dist[cur.name] + child.cost < dist[child.name])) {
			    if (dist[cur.name] + child.cost < k) {
				dist[child.name] = dist[cur.name] + child.cost;
				pq.add(new Node(child.name, dist[child.name], child.wisdom));
			    }
			}
		    }
		}
		boolean valid = (dist[n-1] != -1);
		
		if (valid) {
		    ans = mid;
		    high = mid-1;
		}
		else 
		    low = mid + 1;
	    }

	    out.println(ans);
	}

	out.flush();
	out.close();
    }

}
