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
		int arr[n];
		for (int i = 0; i < n; i++)
			scanf("%i", &arr[i]);

		int ans = 1000000000;
		for (int i = 0; i < n; i++)
		{
			int cur = 0;
			for (int j = 0; j < n; j++)
				cur += abs(arr[i]-arr[j]);

			ans = min(ans, cur);
		}

		printf("%i\n", ans);
	}
}
