#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, k;
	scanf("%i %i",&n, &k);
	k--;
	int num = n*n;

	int arr[n][n];
	memset(arr, 0, sizeof arr);
	for (int i = n-1; i >= 0; i--)
		for (int j = n-1; j >= k; j--)
			arr[i][j] = num--;

	num = 1;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < k; j++)
			arr[i][j] = num++;

	int ans = 0;
	for (int i = 0; i < n; i++)
		ans += arr[i][k];

	printf("%i\n",ans);
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
			printf("%i ", arr[i][j]);
		puts("");
	}
}
