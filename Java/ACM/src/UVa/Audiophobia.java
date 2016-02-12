package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Audiophobia {
    static ArrayList<MyPointt> arr[];
    static int c2;
    static boolean visited[];
    static boolean found;

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	int t = 1;
	while(true) {
	    String line = br.readLine();
	    if (line.equals("0 0 0"))
		break;
	    if (t != 1)
		out.println();
	    StringTokenizer st = new StringTokenizer(line);
	    int C = Integer.parseInt(st.nextToken());
	    int S = Integer.parseInt(st.nextToken());
	    int Q = Integer.parseInt(st.nextToken());

	    MyPairr edgeList[] = new MyPairr[S];
	    for (int i = 0; i < S; i++) {
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken())-1;
		int second = Integer.parseInt(st.nextToken())-1;
		int weight = Integer.parseInt(st.nextToken());

		edgeList[i] = new MyPairr(weight, first, second);
	    }
	    Arrays.sort(edgeList);

	    DisjointSetss ds = new DisjointSetss(C);
	    arr = new ArrayList[C];
	    for (int i = 0; i < C; i++) 
		arr[i] = new ArrayList<>();

	    for (int i = 0; i < S; i++) {
		MyPairr front = edgeList[i];
		if (!ds.inSameSet(front.first, front.second)){
		    arr[front.first].add(new MyPointt(front.second, front.weight));
		    arr[front.second].add(new MyPointt(front.first, front.weight));
		    ds.union(front.first, front.second);
		}
	    }

	    out.println("Case #" + t);
	    while(Q-->0) {
		st = new StringTokenizer(br.readLine());
		int c1 = Integer.parseInt(st.nextToken())-1;
		c2 = Integer.parseInt(st.nextToken())-1;

		if (!ds.inSameSet(c1, c2)) {
		    out.println("no path");
		    continue;
		}

		visited = new boolean[C];
		found = false;
		int ans = dfs(c1,-1);
		out.println(ans);
	    }
	    t++;
	}
	out.flush();
	out.close();
    }

    public static int dfs(int node, int curMax) {
	visited[node] = true;

	for (int i = 0; i < arr[node].size(); i++) {
	    MyPointt dist = arr[node].get(i);
	    if (!visited[dist.name]) {
		curMax = Math.max(curMax, dist.weight);
		if (dist.name == c2) {
		    found = true;
		    return curMax;
		}
		int ans = dfs(dist.name, curMax);
		if (found)
		    return ans;
	    }
	}
	return 0;
    }

}

class MyPairr implements Comparable<MyPairr>{
    int weight;
    int first;
    int second;

    public MyPairr(int weight, int first, int second){
	this.weight = weight;
	this.first = first;
	this.second = second;
    }

    public String toString(){
	return "("+weight+", ("+first+", " + second + "))";
    }

    public int compareTo(MyPairr o) {
	if (this.weight > o.weight)
	    return 1;
	if (this.weight < o.weight)
	    return -1;
	return 0;
    }

}

class DisjointSetss {
    int representative[];
    int rank[];

    public DisjointSetss(int n) {
	representative = new int[n];
	rank = new int[n];
	for (int i = 0; i < representative.length; i++)
	    representative[i] = i;
	Arrays.fill(rank, 1);
    }

    int findSet(int x) {
	if (x == representative[x])
	    return x;
	return representative[x] = findSet(representative[x]);
    }

    boolean inSameSet(int x,int y){
	return (findSet(x) == findSet(y));
    }

    void union(int x, int y) {
	int x1 = findSet(x);
	int y1 = findSet(y);
	if (x1 != y1)
	    if (rank[x1] > rank[y1]) {
		representative[y1] = x1;
	    } else if (rank[x1] < rank[y1]) {
		representative[x1] = y1;
	    } else {
		representative[x1] = y1;
		rank[y1]++;
	    }
    }
}

class MyPointt {
    int name;
    int weight;
    public MyPointt(int name,int weight) {
	this.name = name;
	this.weight = weight;
    }

    public String toString() {
	return "(" + name + ", " + weight + ")";
    }
}
