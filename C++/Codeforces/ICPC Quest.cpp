#include <bits/stdc++.h>
#define MAX 1001
#define INF 2e9

using namespace std;

int n, m;
int grid[MAX][MAX];
int dp[MAX][MAX];

int main()
{
	int t;
	scanf("%i", &t);

	for (int c = 1; c <= t; c++)
	{
		scanf("%i%i",&n,&m);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				scanf("%i", &grid[i][j]);

		dp[0][0] = grid[0][0];
		for (int i = 1; i < n ; i++)
			dp[i][0] = grid[i][0] + dp[i-1][0];

		for (int j = 1; j < m; j++)
		{
			for (int i = 0; i < n; i++)
			{
				if (i == 0)
					dp[i][j] = grid[i][j] + dp[i][j-1];
				else
					dp[i][j] = grid[i][j] + max(dp[i][j-1],dp[i-1][j]);
			}
		}

		printf("Case %i: %i\n", c, dp[n-1][m-1]);
	}
}
