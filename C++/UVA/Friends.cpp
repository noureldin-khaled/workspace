#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

typedef vector<int> vi;

// Union-Find Disjoint Sets Library written in OOP manner, using both path compression and union by rank heuristics
class UnionFind {                                              // OOP style
public:
  vi p, rank, setSize;                       // remember: vi is vector<int>
  int numSets;
  UnionFind(int N) {
    setSize.assign(N, 1); numSets = N; rank.assign(N, 0);
    p.assign(N, 0); for (int i = 0; i < N; i++) p[i] = i; }
  int findSet(int i) { return (p[i] == i) ? i : (p[i] = findSet(p[i])); }
  bool isSameSet(int i, int j) { return findSet(i) == findSet(j); }
  void unionSet(int i, int j) { 
    if (!isSameSet(i, j)) { numSets--; 
    int x = findSet(i), y = findSet(j);
    // rank is used to keep the tree short
    if (rank[x] > rank[y]) { p[y] = x; setSize[x] += setSize[y]; }
    else                   { p[x] = y; setSize[y] += setSize[x];
                             if (rank[x] == rank[y]) rank[y]++; } } }
  int numDisjointSets() { return numSets; }
  int sizeOfSet(int i) { return setSize[findSet(i)]; }
  int largetSet() 
  {
  	int ans = 0;
  	for (int i = 0; i < setSize.size(); i++)
  		if (setSize[i] > 1)
  			ans = max(ans, setSize[i]);
  	return ans;
  }
};

int main()
{
	int t;
	scanf("%i",&t);

	while(t--)
	{
		int n, m;
		scanf("%i%i",&n,&m);

		UnionFind uf(n);
		for (int i = 0; i < m; i++)
		{
			int u, v;
			scanf("%i%i",&u,&v);
			uf.unionSet(u-1, v-1);
		}

		printf("%i\n", uf.largetSet());
	}
}
