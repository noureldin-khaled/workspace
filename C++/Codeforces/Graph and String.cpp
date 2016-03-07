#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, m;
	scanf("%i %i",&n, &m);

	bool adjmat[n][n];
	int edges[n];
	char res[n];

	memset(adjmat, false, sizeof adjmat);
	memset(edges, 0, sizeof edges);
	memset(res, '?', sizeof res);

	for (int i = 0; i < m; i++)
	{
		int u, v;
		scanf("%i %i",&u, &v);
		u--;v--;

		adjmat[u][v] = adjmat[v][u] = true;
		edges[u]++;
		edges[v]++;
	}

	for (int i = 0; i < n; i++)
		if (edges[i] == n-1)
			res[i] = 'b';

	for (int i = 0; i < n; i++)
		if (res[i] == '?')
		{
			res[i] = 'a';
			for (int j = 0; j < n; j++)
				if (res[j] == '?')
					if (adjmat[i][j])
						res[j] = 'a';
					else
						res[j] = 'c';
		}

	bool valid = true;
	for (int i = 0; i < n && valid; i++)
		for (int j = 0; j < n && valid; j++)
		{
			if (i == j) continue;

			if (adjmat[i][j])
			{
				if (abs(res[i] - res[j]) > 1)
					valid = false;
			}
			else
			{
				if (abs(res[i] - res[j]) <= 1)
					valid = false;
			}
		}

	if (valid)
	{
		cout << "Yes" << endl;
		for (int i = 0; i < n; i++)
			cout << res[i];
	}
	else
		cout << "No" << endl;

}
