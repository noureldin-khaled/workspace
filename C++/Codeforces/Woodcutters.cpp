#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	pair<int, int> arr[n];
	for (int i = 0; i < n; i++)
	{
		int x, h;
		scanf("%i%i",&x,&h);

		arr[i] = make_pair(x, h);
	}

	int ans = n == 1 ? 1 : 2;
	for (int i = 1; i < n-1; i++)
	{
		if (arr[i].first - arr[i].second > arr[i-1].first)
			ans++;
		else if (arr[i].first + arr[i].second < arr[i+1].first - arr[i+1].second)
		{
			ans++;
			arr[i].first += arr[i].second;
		}
		else if (arr[i].first + arr[i].second < arr[i+1].first && arr[i+1].first - arr[i+1].second <= arr[i].first)
		{
			ans++;
			arr[i].first += arr[i].second;
		}
		else if (arr[i].first + arr[i].second < arr[i+1].first && arr[i+1].first - arr[i+1].second > arr[i].first)
		{
			ans++;
			arr[i].first += arr[i].second;
		}
	}

	printf("%i\n", ans);
}
