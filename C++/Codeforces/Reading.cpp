#include <bits/stdc++.h>

using namespace std;

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
	int n, k;
	scanf("%i%i",&n,&k);

	pair<int, int> arr[n];
	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		arr[i] = make_pair(a, i+1);
	}

	sort(arr, arr+n, greater<pair<int, int> >());
	int res[k];
	for (int i = 0; i < k; i++)
		res[i] = arr[i].second;

	printf("%i\n", arr[k-1].first);
	sort(res, res+k);
	for (int i = 0; i < k; i++)
		printf("%i ",res[i]);
}

