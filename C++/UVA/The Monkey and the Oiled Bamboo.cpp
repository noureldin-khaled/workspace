#include <bits/stdc++.h>

using namespace std;

int n;
int arr[100001];

bool valid(int ans);
int main()
{
	int t;
	scanf("%i",&t);

	for (int c = 1; c <= t; c++)
	{
		scanf("%i",&n);
		for (int i = 0; i < n; i++)
			scanf("%i",&arr[i]);

		int low = 0;
		int high = 10000000;
		int ans = -1;
		while(low <= high)
		{
			int mid = low + (high-low)/2;

			if (valid(mid))
			{
				ans = mid;
				high = mid-1;
			}
			else
				low = mid+1;
		}

		printf("Case %i: %i\n", c, ans);
	}
}

bool valid(int ans)
{
	int prev = 0;
	for (int i = 0; i < n; i++)
	{
		if (arr[i]-prev > ans)
			return false;
		if (arr[i]-prev == ans)
			ans--;
		prev = arr[i];
	}

	return true;
}
