package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BearAndThreeMusketeers {
    static boolean arr[][];
    static int knows[];
    static int min;

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());

	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());

	arr = new boolean[n][n];
	edge [] edges = new edge[m];
	knows = new int[n];

	for (int i = 0; i < m; i++) {
	    st = new StringTokenizer(br.readLine());
	    int first = Integer.parseInt(st.nextToken())-1;
	    int second = Integer.parseInt(st.nextToken())-1;
	    
	    edges[i] = new edge(first, second);
	    knows[first]++;
	    knows[second]++;
	    arr[first][second] = true;
	    arr[second][first] = true;
	}
	min = Integer.MAX_VALUE;
	for (int i = 0; i < edges.length; i++) {
	    for (int j = 0; j < n; j++) {
		if (arr[edges[i].start][j] && arr[j][edges[i].end])
		    min = Math.min(min, knows[edges[i].start] + knows[edges[i].end] + knows[j]);
	    }
	}
	if (min == Integer.MAX_VALUE)
	    System.out.println(-1);
	else
	    System.out.println(min-6);
    }

}

class edge {
    int start;
    int end;
    public edge(int start, int end){
	this.start = start;
	this.end = end;
    }
    
    public String toString(){
	return "(" + start + ", " + end + ")";
    }
}
