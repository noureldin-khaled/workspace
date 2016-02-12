package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class FindingTeamMember {

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	
	int n = Integer.parseInt(br.readLine());
	
	ArrayList<P> edgeList = new ArrayList<>();
	
	boolean visited[] = new boolean[2*n];
	int arr[] = new int[2*n];
	for (int i = 1; i < 2*n; i++) {
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for (int j = 0; j < i; j++) 
		edgeList.add(new P(i, j, Integer.parseInt(st.nextToken())));
	}
	Collections.sort(edgeList);
	Collections.reverse(edgeList);
	
	for (int i = 0; i < edgeList.size(); i++) {
	    P edge = edgeList.get(i);
	    if (!visited[edge.startNode] && !visited[edge.endNode]) {
		visited[edge.startNode] = true;
		visited[edge.endNode] = true;
		arr[edge.startNode] = edge.endNode;
		arr[edge.endNode] = edge.startNode;
	    }
	}
	for (int i = 0; i < 2*n; i++) {
	    if (i == (2*n-1))
		out.print(arr[i]+1);
	    else 
		out.print(arr[i]+1 + " ");
	}
	out.flush();
	out.close();
    }

}

class P implements Comparable<P>{
    int startNode;
    int endNode;
    int weight;
    
    public P(int startNode,int endNode,int weight){
	this.startNode = startNode;
	this.endNode = endNode;
	this.weight = weight;
    }
    
    public int compareTo(P o) {
	if (this.weight > o.weight)
	    return 1;
	if (this.weight < o.weight)
	    return -1;
	return 0;
    }
    
    public String toString(){
	return "((" + startNode + ", " + endNode + "), " + weight + ")";
    }
}
