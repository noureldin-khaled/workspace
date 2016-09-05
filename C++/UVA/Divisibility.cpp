#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

int n, k;
int a[10001];
int dp[10001][101];

bool rec(int idx, int mod);
int MOD(int a, int m);
int main()
{
	int t;
	scanf("%i",&t);

	while(t--)
	{
		scanf("%i%i",&n,&k);
		for (int i = 0; i < n; i++)
			scanf("%i",&a[i]);

		memset(dp, -1, sizeof dp);
		if (rec(0, 0))
			puts("Divisible");
		else
			puts("Not divisible");
	}
}

bool rec(int idx, int mod)
{
	if (idx == n)
		if (mod == 0)
			return true;
		else
			return false;

	if (dp[idx][mod] != -1)
		return 	dp[idx][mod];
	return dp[idx][mod] = rec(idx+1, MOD(mod + MOD(a[idx], k), k)) || rec(idx+1, MOD(mod - MOD(a[idx], k), k));
}

int MOD(int a, int m)
{
	return (a%m + m) %m;
}