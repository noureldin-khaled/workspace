#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define MAX 1001
#define INF 1e9

using namespace std;

struct Edge
{
	int from, to;	
};

vector<int> adjlist[MAX];
int adjmatrix[MAX][MAX];

void bfs(int s);
int main()
{
	fast

	int t;
	cin >> t;

	while(t--)
	{
		int n;
		cin >> n;

		for (int i = 0; i < n; i++)
			adjlist[i].clear();

		vector<Edge> edgelist;

		for (int i = 0; i < n; i++)
		{
			int u, m;
			cin >> u >> m;
			u--;

			for (int j = 0; j < m; j++)
			{
				int v;
				cin >> v;
				v--;

				adjlist[u].push_back(v);
				adjlist[v].push_back(u);
				Edge e;
				e.from = u;
				e.to = v;
				edgelist.push_back(e);
			}
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				adjmatrix[i][j] = -1;

		int ans = INF;
		for (int i = 0; i < n; i++)
		{
			bfs(i);
			int maximum = 0;
			for (int j = 0; j < n; j++)
				maximum = max(maximum, adjmatrix[i][j]);
			ans = min(ans, 2*maximum);
		}

		for (int i = 0; i < edgelist.size(); i++)
		{
			int maximum = 0;
			for (int j = 0; j < n; j++)
				maximum = max(maximum, min(adjmatrix[edgelist[i].from][j], adjmatrix[edgelist[i].to][j]));
			ans = min(ans, 2*maximum + 1);
		}

		cout << ans << endl;
	}
}

void bfs(int s)
{
	queue<int> q;
	q.push(s);
	adjmatrix[s][s] = 0;

	while(!q.empty())
	{
		int cur = q.front();q.pop();
		for (int i = 0; i < adjlist[cur].size(); i++)
		{
			int nxt = adjlist[cur][i];
			if (adjmatrix[s][nxt] == -1)
			{
				adjmatrix[s][nxt] = adjmatrix[s][cur] + 1;
				q.push(nxt);
			}
		}
	}
}