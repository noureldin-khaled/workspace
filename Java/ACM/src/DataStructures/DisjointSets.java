package DataStructures;

public class DisjointSets {
	int[] representative, rank, setSize;
	int numSets;

	public DisjointSets(int n) {
		representative = new int[numSets = n];
		rank = new int[n];
		setSize = new int[n];
		for (int i = 0; i < n; i++) {
			representative[i] = i;
			setSize[i] = 1;
		}
	}

	int findSet(int x) {
		if (x == representative[x])
			return x;
		return representative[x] = findSet(representative[x]);
	}

	boolean inSameSet(int x,int y){
		return findSet(x) == findSet(y);
	}

	void union(int x, int y) {
		if (inSameSet(x, y))
			return;
		numSets--;
		int x1 = findSet(x);
		int y1 = findSet(y);
		
		if (rank[x1] > rank[y1]) {
			representative[y1] = x1;
			setSize[x1] += setSize[y];
		} else {
			representative[x1] = y1;
			setSize[y1] += setSize[x1];
			if (rank[x1] == rank[y1])
				rank[y1]++;
		}
	}
	
	public int numDisjointSets() { return numSets; }

	public int sizeOfSet(int i) { return setSize[findSet(i)]; }
}

