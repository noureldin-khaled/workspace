package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TransportationSystem {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	int t = Integer.parseInt(br.readLine());
	for (int i = 1; i <= t; i++) {
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int r = Integer.parseInt(st.nextToken());

	    MyPoint points[] = new MyPoint[n];

	    for (int j = 0; j < n; j++) {
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		points[j] = new MyPoint(x, y);
	    }

	    int size = (n*(n-1))/2;
	    MyPair edgeList[] = new MyPair[size];
	    int c = 0;
	    for (int j = 0; j < n; j++) {
		for (int k = j+1; k < n; k++) {
		    double dist = distance(points[j].x, points[j].y, points[k].x, points[k].y);
		    edgeList[c++] = new MyPair(dist, j, k);
		}
	    }

	    Arrays.sort(edgeList);
	    ArrayList<MyPair> MST = new ArrayList<>();
	    MyDisjointSets ds = new MyDisjointSets(n);
	    for (int j = 0; j < size; j++) {
		MyPair front = edgeList[j];
		if (!ds.inSameSet(front.first, front.second)){
		    MST.add(new MyPair(front.dist, front.first, front.second));
		    ds.union(front.first, front.second);
		}
	    }
	    
	    double roads = 0;
	    double railroads = 0;
	    int states = n;
	    for (int j = 0; j < MST.size(); j++) {
		MyPair front = MST.get(j);
		if (front.dist <= r) {
		    states--;
		    roads += front.dist;
		}
		else 
		    railroads += front.dist;
	    }
	    long resRoads = Math.round(roads);
	    long resRailRoads = Math.round(railroads); 
	    
	    out.printf("Case #%d: %d %d %d\n",i,states,resRoads,resRailRoads);
	}
	out.flush();
	out.close();
    }

    public static double distance(int x1, int y1, int x2, int y2) {
	return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }

}

class MyPoint {
    int x;
    int y;
    public MyPoint(int x, int y) {
	this.x = x;
	this.y = y;
    }
}

class MyPair implements Comparable<MyPair>{
    double dist;
    int first;
    int second;

    public MyPair(double dist, int first, int second){
	this.dist = dist;
	this.first = first;
	this.second = second;
    }

    public String toString(){
	return "("+dist+", ("+first+", " + second + "))";
    }

    public int compareTo(MyPair o) {
	if (this.dist > o.dist)
	    return 1;
	if (this.dist < o.dist)
	    return -1;
	return 0;
    }

}

class MyDisjointSets {
    int representative[];
    int rank[];

    public MyDisjointSets(int n) {
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