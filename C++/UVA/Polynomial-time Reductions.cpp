#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

vector<int> adjlist[105];
int n, dfsCounter, SCC;
int dfs_low[105];
int dfs_num[105];
int SCC_id[105];
int SCC_size[105];
stack<int> st;
int adjmatrix[105][105];

void tarjanSCC();
void tarjanSCC(int u);
int main()
{
	fast

	int t = 1;
	int m;
	while(true)
	{
		cin >> n >> m;

		if (n+m == 0) break;
		for (int i = 0; i < n; i++)
			adjlist[i].clear();

		for (int i = 0; i < m; i++)
		{
			int u, v;
			cin >> u >> v;
			u--;v--;

			adjlist[u].push_back(v);
		}

		memset(dfs_num, 0, sizeof dfs_num);
		memset(dfs_low, 0, sizeof dfs_low);
		memset(SCC_size, 0, sizeof SCC_size);
		dfsCounter = 0;
		SCC = 0;
		tarjanSCC();

		memset(adjmatrix, 0, sizeof adjmatrix);

		for (int i = 0; i < n; i++)
			for (int j = 0; j < adjlist[i].size(); j++)
			{
				int v = adjlist[i][j];
				if (SCC_id[i] != SCC_id[v])
					adjmatrix[SCC_id[i]][SCC_id[v]] = 1;
			}

		for (int i = 0; i < SCC; i++)
			for (int j = 0; j < SCC; j++)
				for (int k = 0; k < SCC; k++)
					adjmatrix[i][j] |= (adjmatrix[i][k] & adjmatrix[k][j]);

		int ans = 0;
		for (int i = 0; i < SCC; i++)
			if (SCC_size[i] > 1)
				ans += SCC_size[i];

		for (int i = 0; i < SCC; i++)
			for (int j = 0; j < SCC; j++)
				if (adjmatrix[i][j])
				{
					bool important = true;
					for (int k = 0; k < SCC && important; k++)
						if (adjmatrix[i][k] & adjmatrix[k][j])
							important = false;

					if (important)
						ans++;
				}

		printf("Case %i: %i\n", t++, ans);
	}
}

void tarjanSCC()
{
	memset(SCC_id, -1, sizeof SCC_id);
	for(int i = 0; i < n; ++i)
	{
		if(dfs_num[i] == 0)
			tarjanSCC(i);
	}
}

void tarjanSCC(int u) 
{
	dfs_num[u] = dfs_low[u] = ++dfsCounter;
	st.push(u);

	for (int j = 0; j < adjlist[u].size(); j++) 
	{
		int v = adjlist[u][j];
		if (dfs_num[v] == 0)
			tarjanSCC(v);
		if (SCC_id[v] == -1)
			dfs_low[u] = min(dfs_low[u], dfs_low[v]);
	}

	if (dfs_num[u] == dfs_low[u]) 
	{
		while (true)
		{
			int v = st.top();st.pop();
			SCC_id[v] = SCC;
			SCC_size[SCC]++;
			if (v == u)
				break;
		}
		SCC++;
	}
}
