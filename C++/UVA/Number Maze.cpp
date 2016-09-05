#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define MAX 1000
#define INF 2e9

using namespace std;

int n, m;
int grid[MAX][MAX];

int dx[4] = {-1,0,1, 0};
int dy[4] = { 0,1,0,-1};

bool valid(int i, int j);
int main()
{
	int t;
	scanf("%i",&t);

	while(t--)
	{
		scanf("%i\n%i",&n,&m);

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				scanf("%i",&grid[i][j]);

		int dist[n][m];
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j<  m; j++)
				dist[i][j] = INF;
		}

		priority_queue<pair<int, pair<int, int> >, vector<pair<int, pair<int, int> > >, greater<pair<int, pair<int, int> > > > pq;
		dist[0][0] = grid[0][0];
		pq.push(make_pair(dist[0][0], make_pair(0, 0)));
		while (!pq.empty())
		{
			pair<int, pair<int, int> > cur = pq.top();pq.pop();

			if (cur.second.first == n-1 && cur.second.second == m-1)
				break;

			if (cur.first > dist[cur.second.first][cur.second.second])
				continue;
			for (int k = 0; k < 4; k++) 
			{
				int newI = cur.second.first + dx[k];
				int newJ = cur.second.second + dy[k];

				if (valid(newI, newJ) && cur.first + grid[newI][newJ] < dist[newI][newJ])
				{
					dist[newI][newJ] = cur.first + grid[newI][newJ];
					pq.push(make_pair(dist[newI][newJ], make_pair(newI, newJ)));
				}
			}
		}

		printf("%i\n", dist[n-1][m-1]);
	}
}

bool valid(int i, int j)
{
	return i >= 0 && i < n && j >= 0 && j < m;
}