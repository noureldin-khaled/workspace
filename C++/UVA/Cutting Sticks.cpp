#include <bits/stdc++.h>
#define MAX 60
#define INF 2000000000

using namespace std;

int arr[MAX];
int dp[MAX][MAX];

int rec(int left, int right);
int main()
{
	while(true) 
	{
		int l, n;
		scanf("%i",&l);

		if (l == 0) break;
		scanf("%i",&n);

		arr[0] = 0;
		for (int i = 1; i <= n; i++)
			scanf("%i",&arr[i]);
		arr[n+1] = l;

		memset(dp, -1, sizeof dp);
		printf("The minimum cutting is %i.\n", rec(0, n+1));
	}
}

int rec(int left, int right)
{
	if (left == right-1)
		return 0;
	if (dp[left][right] != -1)
		return dp[left][right];

	int ans = INF;
	for (int i = left+1; i < right; i++)
		ans = min(ans, (arr[right]-arr[left]) + rec(left, i) + rec(i, right));

	return dp[left][right] = ans;
}
