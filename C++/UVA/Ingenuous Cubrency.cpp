#include <bits/stdc++.h>

using namespace std;

int a[24];
long long dp[24][10005];

long long rec(int idx, int rem);
int main()
{
	for (int i = 1; i < 24; i++)
		a[i] = i*i*i;

	memset(dp, -1, sizeof dp);
	int n;
	while(scanf("%i",&n) != EOF)
		cout << rec(1, n) << endl;
}

long long rec(int idx, int rem)
{
	if (rem == 0)
		return 1;
	if (rem < 0 || idx >= 22)
		return 0;
	if (dp[idx][rem] != -1)
		return dp[idx][rem];

	long long take = rec(idx, rem-a[idx]);
	long long leave = rec(idx+1, rem);

	return dp[idx][rem] = take+leave;
}
