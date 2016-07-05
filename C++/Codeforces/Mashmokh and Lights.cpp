#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, m;
	scanf("%i%i",&n,&m);

	int res[n];
	memset(res, -1, sizeof res);

	for (int i = 0; i < m; i++)
	{
		int a;
		scanf("%i",&a);

		for (int j = a-1; j < n; j++)
		{
			if (res[j] != -1) break;

			res[j] = a;
		}
	}

	for (int i = 0; i < n; i++)
		printf("%i ", res[i]);
}
