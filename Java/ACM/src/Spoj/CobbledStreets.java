package Spoj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class MyPair implements Comparable<MyPair>{
    int weight;
    int first;
    int second;

    public MyPair(int weight, int first, int second){
	this.weight = weight;
	this.first = first;
	this.second = second;
    }

    public String toString(){
	return "("+weight+", ("+first+", " + second + "))";
    }

    public int compareTo(MyPair o) {
	if (this.weight > o.weight)
	    return 1;
	if (this.weight < o.weight)
	    return -1;
	return 0;
    }

}

class DisjointSets {
    int representative[];
    int rank[];

    public DisjointSets(int n) {
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
public class CobbledStreets { 
    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(br.readLine());
	while(t-->0){
	    long p = Long.parseLong(br.readLine());
	    int n = Integer.parseInt(br.readLine());
	    int m = Integer.parseInt(br.readLine());

	    MyPair edgeList[] = new MyPair[m];

	    for (int i = 0; i < m; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken())-1;
		int b = Integer.parseInt(st.nextToken())-1;
		int w = Integer.parseInt(st.nextToken());

		edgeList[i] = new MyPair(w, a, b);
	    }
	    Arrays.sort(edgeList);

	    long min_length = 0;
	    DisjointSets ds = new DisjointSets(n);
	    for (int i = 0; i < m; i++) {
		MyPair front = edgeList[i];
		if (!ds.inSameSet(front.first, front.second)){
		    min_length+=front.weight;
		    ds.union(front.first, front.second);
		}
	    }
	    
	    System.out.println(min_length*p);
	}
    }
}
