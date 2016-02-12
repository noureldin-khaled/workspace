package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FrozenRivers {
    static class Node {
	int name;
	long time;

	public Node(int name, long time) {
	    this.name = name;
	    this.time = time;
	}
	@Override
	public String toString() {
	    return "(" + name + ", " + time + ")";
	}
    }

    static ArrayList<Node> arr[];
    static ArrayList<Long> leaves;
    static long T[];

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	int t = Integer.parseInt(br.readLine());

	while(t-->0) {
	    int n = Integer.parseInt(br.readLine());
	    arr = new ArrayList[n];
	    for (int i = 0; i < n; i++) 
		arr[i] = new ArrayList<>();

	    for (int i = 0; i < n-1; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int parent = Integer.parseInt(st.nextToken())-1;
		int weight = Integer.parseInt(st.nextToken());

		arr[parent].add(new Node(i+1, weight));
	    }
	    
	    leaves = new ArrayList<Long>();
	    T = new long[n];
	    T[0] = 0;
	    
	    Queue<Node> q = new LinkedList<>();
	    q.add(new Node(0, 0));
	    //bfs
	    while(!q.isEmpty()) {
		Node parent = q.remove();
		Node min = null;
		int size = arr[parent.name].size();
		for (int i = 0; i < size; i++) {
		    Node child = arr[parent.name].get(i);
		    q.add(child);
		    if (min == null || child.time < min.time)
			min = child;
		}
		if (min != null) {
		    T[min.name] = T[parent.name] + min.time;
		    for (int i = 0; i < size; i++) {
			Node child = arr[parent.name].get(i);
			T[child.name] = T[parent.name] + min.time + (child.time-min.time)*2;
		    }
		}
		else
		    leaves.add(T[parent.name]);
	    }

	    Collections.sort(leaves);
	    int queries = Integer.parseInt(br.readLine());
	    
	    while(queries-->0) {
		long query_time = Long.parseLong(br.readLine());
		int low = 0;
		int high = leaves.size()-1;
		
		int ans = -10;
		while(low <= high) {
		    int mid = low + (high-low)/2;

		    if (leaves.get(mid) == query_time) {
			ans = mid + 1;
			low = mid + 1;
		    }
		    else if (leaves.get(mid) > query_time) 
			high = mid - 1;
		    else
			low = mid + 1;
		}
		if (ans == -10)
		    ans = high + 1;
		
		out.println(ans);
	    }
	}

	out.flush();
	out.close();
    }

}
