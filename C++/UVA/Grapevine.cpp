#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, m;
	while(true)
	{
		scanf("%i%i",&n,&m);
		if (n == 0 && m == 0) break;

		int grid[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
			{
				int a;
				scanf("%i", &a);

				grid[i][j] = a;
			}

		int q;
		scanf("%i",&q);

		while(q--)
		{
			int l, u;
			scanf("%i%i",&l,&u);

			int maximum = -1;
			for (int i = 0; i < n; i++)
			{
				int low = 0;
				int high = m-1;
				int ans = -1;

				while(low <= high)
				{
					int mid = low + (high-low)/2;
					if (grid[i][mid] >= l)
					{
						ans = mid;
						high = mid-1;
					}
					else
						low = mid+1;
				}

				if (ans == -1 || grid[i][ans] > u)
					continue;

				int startX = i;
				int startY = ans;
				low = 0;
				high = min(n-startX-1, m-startY-1);
				ans = -1;
				
				while(low <= high)
				{
					int mid = low + (high-low)/2;
					int x = startX+mid;
					int y = startY+mid;

					if (grid[x][y] <= u)
					{
						ans = mid;
						low = mid+1;
					}
					else
						high = mid-1;
				}

				maximum = max(maximum, ans);
			}

			printf("%i\n", maximum+1);
		}

		puts("-");
	}
}
