#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, k;
	scanf("%i%i",&n, &k);

	int arr[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);

	sort(arr, arr + n);
	int ans = 0;

	int idx = 0;
	if (n%k != 0)
	{
		idx += n%k - 1;
		ans += (arr[idx]-1)*2;
		idx++;
	}

	for (; idx < n; idx += k)
		ans += (arr[idx+k-1]-1)*2;

	printf("%i\n", ans);

}
