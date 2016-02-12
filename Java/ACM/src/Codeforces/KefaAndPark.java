package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class KefaAndPark {
    static ArrayList<Integer> arr[];
    static boolean visited[];
    static boolean cats[];
    static int m;
    static int count;

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());

	cats = new boolean[n];

	st = new StringTokenizer(br.readLine());
	for (int i = 0; i < n; i++) {
	    if (Integer.parseInt(st.nextToken()) == 1)
		cats[i] = true;
	}

	arr = new ArrayList[n];
	for (int i = 0; i < n; i++) 
	    arr[i] = new ArrayList<Integer>();


	for (int i = 0; i < n-1; i++) {
	    st = new StringTokenizer(br.readLine());
	    int first = Integer.parseInt(st.nextToken())-1;
	    int second = Integer.parseInt(st.nextToken())-1;

	    arr[first].add(second);
	    arr[second].add(first);
	}

	visited = new boolean[n];
	count = 0;
	int c = 0;
	if (cats[0]) c++;
	dfs(0,c);

	System.out.println(count);
    }
    public static void dfs(int node,int c) {
	visited[node] = true;
	if (c <= m) {
	    int size = arr[node].size();
	    if (size == 1 && visited[arr[node].get(0)])
		count++;
	    else{
		for (int i = 0; i < size; i++) {
		    int dist = arr[node].get(i);
		    if (!visited[dist]) {
			if (cats[dist])
			    dfs(dist, c+1);
			else
			    dfs(dist, 0);
		    }
		}
	    }
	}
    }

}
