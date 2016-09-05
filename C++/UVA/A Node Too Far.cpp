#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

int m;
vector<int> adjlist[35];
int main()
{
	int t = 1;
	while(true)
	{
		scanf("%i",&m);
		if (m == 0) break;

		for (int i = 0; i < 35; i++)
			adjlist[i].clear();

		map<int, int> mp;
		int k = 0;
		for (int i = 0; i < m; i++)
		{
			int u, v;
			scanf("%i%i",&u,&v);

			if (mp.find(u) != mp.end())
				u = mp.find(u)->second;
			else
			{
				mp[u] = k;
				u = k++;
			}

			if (mp.find(v) != mp.end())
				v = mp.find(v)->second;
			else
			{
				mp[v] = k;
				v = k++;
			}

			adjlist[u].push_back(v);
			adjlist[v].push_back(u);
		}

		while(true)
		{
			int node, TTL;
			scanf("%i%i",&node,&TTL);
			if (node + TTL == 0) break;

			int tmp = node;
			if (mp.find(node) != mp.end())
				node = mp.find(node)->second;
			else
			{
				printf("Case %i: %i nodes not reachable from node %i with TTL = %i.\n", t++, k, tmp, TTL);
				continue;
			}

			int dist[35];
			memset(dist, -1, sizeof dist);
			queue<int> q;
			if (0 <= TTL)
			{
				q.push(node);
				dist[node] = 0;
			}

			while(!q.empty())
			{
				int cur = q.front();q.pop();
				for (int i = 0; i < adjlist[cur].size(); i++)
				{
					int nxt = adjlist[cur][i];
					if (dist[nxt] == -1 && dist[cur] + 1 <= TTL)
					{
						dist[nxt] = dist[cur] + 1;
						q.push(nxt);
					}
				}
			}

			int ans = 0;
			for (int i = 0; i < k; i++)
			{
				if (dist[i] == -1)
					ans++;
			}

			printf("Case %i: %i nodes not reachable from node %i with TTL = %i.\n", t++, ans, tmp, TTL);
		}
	}
}