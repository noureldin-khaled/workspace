#include <bits/stdc++.h>
#define INF 2147483647

using namespace std;

int main()
{
	int t;
	scanf("%i",&t);
	while(t--)
	{
		int n;
		scanf("%i",&n);

		int arr[n];
		for (int i = 0; i < n; i++)
			scanf("%i",&arr[i]);

		int ans[n];
		memset(ans, 0, sizeof ans);

		for (int i = 0; i < n; i++)
		{
			int cur = arr[i];
			int nxt = INF;
			if (i < n-1)
				nxt = arr[i+1];
			int idx = -1;
			for (int j = 0; j < i; j++)
			{
				if (arr[j]+cur < nxt)
				{
					if (ans[j] > ans[idx])
						idx = j;
				}
				else
					break;
			}

			ans[i] += ans[idx]+1;
			arr[i] += idx == -1 ? 0 : arr[idx];
		}

		printf("%i\n", ans[n-1]);
	}
}
