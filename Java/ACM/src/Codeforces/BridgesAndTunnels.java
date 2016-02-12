package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BridgesAndTunnels {
    static ArrayList<MyNode> graph[];
    
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	int p = Integer.parseInt(st.nextToken());
	
	graph = new ArrayList[n];
	
	for (int i = 0; i < n; i++) 
	    graph[i] = new ArrayList<>();
	
	for (int i = 0; i < m; i++) {
	    st = new StringTokenizer(br.readLine());
	    int first = Integer.parseInt(st.nextToken());
	    int second = Integer.parseInt(st.nextToken());
	    int cost = Integer.parseInt(st.nextToken());
	    char c = st.nextToken().charAt(0);
	    
	    int time = 0;
	    int outtime = 0;
	    if (c == 'I') 
		time = cost;
	    else
		outtime = cost;
	    graph[first].add(new MyNode(second, time, outtime));
	    graph[second].add(new MyNode(first, time, outtime));
	}
	    while(p-->0){
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int outTime[] = new int[n];
		int totalTime[] = new int[n];
		Arrays.fill(outTime, -1);
		Arrays.fill(totalTime, -1);
		
		PriorityQueue<MyNode> pq = new PriorityQueue<MyNode>();
		pq.add(new MyNode(start, 0, 0));
		outTime[start] = 0;
		totalTime[start] = 0;

		while(!pq.isEmpty()) {
		    MyNode cur = pq.poll();
		    if (cur.outTime > outTime[cur.node])
			continue;
		    for (int i = 0; i < graph[cur.node].size(); i++) {
			MyNode child = graph[cur.node].get(i);
			if (outTime[child.node] == -1 || outTime[cur.node] + child.outTime < outTime[child.node] ||
				(outTime[cur.node] + child.outTime == outTime[child.node] && totalTime[cur.node] + child.time < totalTime[child.node])) {
			    outTime[child.node] = outTime[cur.node] + child.outTime;
			    totalTime[child.node] = totalTime[cur.node] + child.time;
			    pq.add(new MyNode(child.node, totalTime[child.node] , outTime[child.node]));
			}
		    }
		}
		
		out.println(outTime[end] + " " + totalTime[end]);
	    }
	    out.flush();
	    out.close();
    }

}

class MyNode implements Comparable<MyNode>{
    int node;
    int time;
    int outTime;
    public MyNode(int dest,int time,int outTime){
	this.node = dest;
	this.time = time;
	this.outTime = outTime;
    }
    @Override
    public int compareTo(MyNode o) {
	if (this.outTime - o.outTime != 0)
	    return this.outTime - o.outTime;
	else
	    return this.time - o.time;
    }
    
    
}
