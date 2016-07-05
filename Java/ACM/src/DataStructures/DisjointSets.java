package DataStructures;

import java.util.Arrays;

public class DisjointSets {
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

