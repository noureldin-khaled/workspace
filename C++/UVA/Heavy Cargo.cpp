#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define MAX 201
#define INF 2e9

using namespace std;

class UnionFind {
	vector<int> p, rank, setSize;  
	int numSets;
public:
	UnionFind(int N) 
	{
		setSize.assign(N, 1); numSets = N; rank.assign(N, 0);
		p.assign(N, 0); for (int i = 0; i < N; i++) p[i] = i; 
	}
	int findSet(int i) 
	{ 
		return (p[i] == i) ? i : (p[i] = findSet(p[i])); 
	}
	bool isSameSet(int i, int j) 
	{ 
		return findSet(i) == findSet(j); 
	}
	void unionSet(int i, int j) { 
		if (!isSameSet(i, j))
		{ 
			numSets--; 
			int x = findSet(i), y = findSet(j);
			if (rank[x] > rank[y]) { 
				p[y] = x; setSize[x] += setSize[y]; 
			}
			else                   {
				p[x] = y; setSize[y] += setSize[x];
				if (rank[x] == rank[y]) rank[y]++;
			} 
		} 
	}
	int numDisjointSets() 
	{
		return numSets; 
	}
	int sizeOfSet(int i) 
	{
		return setSize[findSet(i)]; 
	}
};


struct Edge
{
	int from, to, cost;
};

struct cmp
{
	bool operator()(const Edge& s1, const Edge& s2)
	{
		if (s1.cost != s2.cost)
			return s1.cost > s2.cost;
		return s1.from > s2.from;
	}
};

int n, m;
map<string, int> mp;
Edge edgelist[200000];

int mst(int st, int tr);
int dfs(int u, int minSoFar, int p, int tr);
int main()
{
	fast

	int t = 1;
	while(true)
	{
		cin >> n >> m;
		if (n+m == 0) break;

		mp.clear();
		int k = 0;
		for (int i = 0; i < m; i++)
		{
			string s1, s2;
			int w;
			cin >> s1 >> s2 >> w;
			int u, v;

			if (mp.find(s1) != mp.end())
				u = mp.find(s1)->second;
			else
			{
				mp[s1] = k;
				u = k++;
			}

			if (mp.find(s2) != mp.end())
				v = mp.find(s2)->second;
			else
			{
				mp[s2] = k;
				v = k++;
			}

			Edge e; e.from = u; e.to = v; e.cost = w;
			edgelist[i] = e;
		}

		int st, tr;
		string s1, s2;
		cin >> s1 >> s2;

		st = mp.find(s1)->second;
		tr = mp.find(s2)->second;

		printf("Scenario #%i\n%i tons\n\n", t++, mst(st, tr));
	}
}

struct Node
{
	int name, cost;	
};

vector<Node> adjlist[MAX];
int mst(int st, int tr)
{
	sort(edgelist, edgelist+m, cmp());
	UnionFind uf(n);

	for (int i = 0; i < MAX; i++)
		adjlist[i].clear();

	for (int i = 0; i < m; i++)
	{
		Edge e = edgelist[i];
		if (!uf.isSameSet(e.from, e.to))
		{
			uf.unionSet(e.from, e.to);
			Node n1; n1.name = e.to; n1.cost = e.cost;
			Node n2; n2.name = e.from; n2.cost = e.cost;
			adjlist[e.from].push_back(n1);
			adjlist[e.to].push_back(n2);
		}
	}

	return dfs(st, 0, -1, tr);
}

int dfs(int u, int minSoFar, int p, int tr)
{
	if (u == tr)
		return minSoFar;

	int ans = INF;
	for (int i = 0; i < adjlist[u].size(); i++)
	{
		Node v = adjlist[u][i];
		if (v.name != p)
			ans = min(ans, dfs(v.name, p == -1 ? v.cost : min(minSoFar, v.cost), u, tr));
	}

	return ans;
}