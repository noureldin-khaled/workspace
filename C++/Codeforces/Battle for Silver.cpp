#include <bits/stdc++.h>

using namespace std;

int n, m, u, v;
int a[500];
int adjmat[500][500];

int main()
{
	while(scanf("%i%i",&n,&m) != EOF)
	{
		for (int i = 0; i < n; i++)
			scanf("%i",&a[i]);

		memset(adjmat, 0, sizeof adjmat);
		for (int i = 0; i < m; i++)
		{
			scanf("%i%i",&u,&v);
			u--;v--;
			adjmat[u][v] = adjmat[v][u] = 1;
		}

		int ans = 0;
		for (int i = 0; i < n; i++)
			ans = max(ans, a[i]);

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (adjmat[i][j])
					ans = max(ans, a[i] + a[j]);

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
			{
				if (!adjmat[i][j]) continue;
				for (int k = 0; k < n; k++)
					if (adjmat[i][k] && adjmat[j][k])
						ans = max(ans, a[i] + a[j] + a[k]);
			}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
			{
				if (!adjmat[i][j]) continue;
				for (int k = 0; k < n; k++)
				{
					if (!adjmat[i][k] || !adjmat[j][k]) continue;
					for (int r = 0; r < n; r++)
						if (adjmat[i][r] && adjmat[j][r] && adjmat[k][r])
							ans = max(ans, a[i] + a[j] + a[k] + a[r]);
				}
			}

		printf("%d\n", ans);
	}
}