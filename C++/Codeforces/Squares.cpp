#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, k;
	scanf("%i%i",&n,&k);

	if (k > n)
	{
		printf("%i\n", -1);
		return 0;
	}

	int arr[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);

	sort(arr, arr+n, greater<int>());

	int ans = arr[k-1];
	printf("%i %i\n", ans, ans);
}
