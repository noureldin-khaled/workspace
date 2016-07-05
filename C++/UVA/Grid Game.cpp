#include <bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	scanf("%i",&t);

	while(t--)
	{
		int n;
		scanf("%i",&n);

		int grid[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				scanf("%i",&grid[i][j]);

		int arr[n];
		for (int i = 0; i < n; i++)
			arr[i] = i;

		int ans = 10005;
		do {
			int cur = 0;
			for (int i = 0; i < n; i++)
				cur += grid[arr[i]][i];

			ans = min(ans, cur);
		}while(next_permutation(arr, arr+n));

		printf("%i\n", ans);
	}
}
