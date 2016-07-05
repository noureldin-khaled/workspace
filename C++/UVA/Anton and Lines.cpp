#include <bits/stdc++.h>

using namespace std;

bool cmp(pair< pair<long long, long long> , int> p1, pair< pair<long long, long long> , int> p2)
{
	if (p1.first.first != p2.first.first)
		return p1.first.first < p2.first.first;
	if (p1.first.second != p2.first.second)
		return p1.first.second < p2.first.second;
	return p1.second < p2.second;
}

int main()
{
	int n;
	scanf("%i",&n);

	int x1, x2;
	scanf("%i%i",&x1,&x2);

	pair< pair<long long, long long> , int> arr1[n];
	pair< pair<long long, long long> , int> arr2[n];

	for (int i = 0; i < n; i++)
	{
		int k, b;
		scanf("%i%i",&k,&b);

		long long y1 = (long long)k*x1 + b;
		long long y2 = (long long)k*x2 + b;

		arr1[i] = make_pair(make_pair(y1, y2), i);
		arr2[i] = make_pair(make_pair(y2, y1), i);
	}

	sort(arr1, arr1 + n, cmp);
	sort(arr2, arr2 + n, cmp);

	for (int i = 0; i < n; i++)
	{
		pair< pair<long long, long long> , int> p1 = arr1[i];
		pair< pair<long long, long long> , int> p2 = arr2[i];

		if (p1.second != p2.second)
		{
			puts("YES");
			return 0;
		}
	}

	puts("NO");
}
