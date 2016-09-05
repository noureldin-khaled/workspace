#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define MAX 101

using namespace std;

const int dx[] = {1,0,-1,0,1,1,-1,-1};
const int dy[] = {0,1,0,-1,1,-1,1,-1};

int n, m;
char grid[MAX][MAX];
bool visited[MAX][MAX];

void dfs(int i, int j);
bool valid(int i, int j);
int main()
{
	while(true)
	{
		scanf("%i%i",&n,&m);

		if (n+m == 0) break;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				scanf(" %c", &grid[i][j]);

		memset(visited, 0, sizeof visited);
		int ans = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (!visited[i][j] && grid[i][j] == '@')
				{
					dfs(i, j);
					ans++;
				}

		printf("%i\n", ans);
	}
}

void dfs(int i, int j)
{
	visited[i][j] = true;

	for (int k = 0; k < 8; k++)
	{
		int newI = i + dx[k];
		int newJ = j + dy[k];

		if (valid(newI, newJ) && grid[newI][newJ] == '@' && !visited[newI][newJ])
			dfs(newI, newJ);
	}
}

bool valid(int i, int j)
{
	return i >= 0 && i < n && j >= 0 && j < m;
}