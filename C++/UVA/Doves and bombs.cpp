#include <bits/stdc++.h>
#define MAX 10050

using namespace std;

vector<int> adjlist[MAX];
int dfs_num[MAX];
int dfs_low[MAX];
int parent[MAX];
int n, dfsCounter, root, rootChildren;
int groups[MAX];

void tarjan();
void dfs(int u);

bool cmp(pair<int, int> a, pair<int, int> b)
{
	if (a.first != b.first)
    	return a.first > b.first;
    return a.second < b.second;
}

int main()
{
	while(true)
	{
		int m;
		scanf("%i %i",&n, &m);
		
		if (n == 0 && m == 0) break;

		for (int i = 0; i < MAX; i++)
			adjlist[i].clear();

		while(true)
		{
			int u, v;
			scanf("%i %i",&u, &v);

			if (u == -1 && v == -1) break;

			adjlist[u].push_back(v);
			adjlist[v].push_back(u);
		}
		memset(dfs_num, 0, sizeof dfs_num);
		memset(dfs_low, 0, sizeof dfs_low);
		memset(parent, -1, sizeof parent);
		memset(groups, 0, sizeof groups);
		dfsCounter = 0;

		tarjan();

		pair<int, int> res[n];
		for (int i = 0; i < n; i++)
			res[i] = make_pair(groups[i], i);

		sort(res, res+n, cmp);
		for (int i = 0; i < m; i++)
			printf("%i %i\n",res[i].second, res[i].first);
		puts("");
	}
	

}

void tarjan()
{
	for (int i = 0; i < n; i++)
	{
		if (dfs_num[i] == 0)
		{
			root = i;
			rootChildren = 0;
			dfs(i);
			for (int j = 0; j < n; j++)
				if (j != root)
					groups[j]++;
		}
	}
}

void dfs(int u)
{
	dfs_num[u] = dfs_low[u] = ++dfsCounter;

	for (int i = 0; i < adjlist[u].size(); i++)
	{
		int v = adjlist[u][i];
		if (dfs_num[v] == 0)
		{
			parent[v] = u;
			if (u == root)
				rootChildren++;
			dfs(v);
			if (dfs_low[v] >= dfs_num[u])
				groups[u]++;
			dfs_low[u] = min(dfs_low[v], dfs_low[u]);
		}
		else 
			if (parent[u] != v)
				dfs_low[u] = min(dfs_low[u], dfs_num[v]);

	}
}
