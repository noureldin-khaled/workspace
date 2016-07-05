#include <bits/stdc++.h>

bool valid(int ans);
using namespace std;

int n, m;
int arr[1001];
int main()
{
	while(scanf("%i%i",&n,&m) != EOF)
	{
		int high = 0;
		for (int i = 0; i < n; i++)
		{
			int a;
			scanf("%i",&a);

			arr[i] = a;
			high += a;
		}

		int low = 0;
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

		printf("%i\n", ans);
	}
}

bool valid(int ans)
{
	for (int i = 0; i < n; i++)
		if (arr[i] > ans)
			return false;

	int c = 0;
	int cur = 0;
	for (int i = 0; i < n; i++)
	{
		if (cur + arr[i] > ans)
		{
			cur = 0;
			c++;
		}
		
		cur += arr[i];
	}
	if (cur > 0)
		c++;

	return c <= m;
}
