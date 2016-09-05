#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define MAX 1001
#define INF 2e9

using namespace std;
struct Node
{
	int name, cost;
};

int n, m;
vector<Node> adjlist[MAX];
bool visited[MAX];

void dfs(int u);
int main()
{
	int t;
	scanf("%i",&t);

	int c = 1;
	while(t--)
	{
		printf("Case %d:", c++);
		scanf("%i%i",&n,&m);

		for (int i = 0; i < n; i++)
			adjlist[i].clear();

		for (int i = 0; i < m; i++)
		{
			int u, v, w;
			scanf("%i%i%i",&u,&v,&w);

			Node nd;nd.name = u;nd.cost = w;

			adjlist[v].push_back(nd);
		}

		int dist[n];
		memset(dist, INF, sizeof dist);
		dist[0] = 0;
		bool modified = true;
		for(int k = 0; modified && k < n - 1; ++k)
		{
			modified = false;
			for(int u = 0; u < n; ++u)
				for(int i = 0; i < adjlist[u].size(); i++)
				{
					Node nxt = adjlist[u][i];
					if(dist[u] + nxt.cost < dist[nxt.name])
					{
						modified = true;
						dist[nxt.name] = dist[u] + nxt.cost;
					}
				}
		}

		memset(visited, false, sizeof visited);
		bool flag = false;
		for(int u = 0; u < n; ++u)
			for(int i = 0; i < adjlist[u].size(); i++)
			{
				Node nxt = adjlist[u][i];
				if(dist[u] + nxt.cost < dist[nxt.name])
				{
					flag = true;
					dfs(u);
				}
			}

		if (!flag)
			printf(" impossible");
		else 
		{
			for (int i = 0; i < n; i++)
			{
				if (visited[i])
					printf(" %i", i);
			}
		}
		
		puts("");
	}
}

void dfs(int u)
{
	visited[u] = true;
	
	for (int i = 0; i < adjlist[u].size(); i++)
	{
		Node v = adjlist[u][i];
		if (!visited[v.name])
			dfs(v.name);
	}
}