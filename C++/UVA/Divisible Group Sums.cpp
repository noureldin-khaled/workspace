#include <bits/stdc++.h>

using namespace std;

int n, q, d;
long long arr[205];
long long dp[205][22][22];

long long rec(int index, int m, long long sumMod);
int mod(long long a, int m);
int main()
{
	int t = 1;
	while(true)
	{
		scanf("%i%i",&n,&q);
		if (n == 0 && q == 0) break;

		for (int i = 0; i < n; i++)
			cin >> arr[i];

		printf("SET %i:\n", t++);
		for (int i = 1; i <= q; i++)
		{
			int m;
			scanf("%i%i",&d,&m);

			memset(dp, -1, sizeof dp);
			printf("QUERY %i: ", i);
			cout << rec(0, m, 0) << endl;
		}
	}
}

long long rec(int index, int m, long long sumMod)
{
	if (m <= 0)
		return sumMod == 0 ? 1 : 0;
	if (index >= n)
		return 0;
	if (dp[index][m][sumMod] != -1)
		return dp[index][m][sumMod];

	long long take = rec(index+1, m-1, mod(sumMod+arr[index], d));
	long long leave = rec(index+1, m, sumMod);

	return dp[index][m][sumMod] = take+leave;
}

int mod(long long a, int m)
{
	return (a%m + m)%m;
}
