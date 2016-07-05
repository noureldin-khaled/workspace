#include <bits/stdc++.h>
#define INF 1000000000

using namespace std;

int n, m;
int price[101];
int favor[101];
int dp[101][10001][4];

int rec(int index, int money, int added);
int main()
{
	while(scanf("%i%i",&m,&n) != EOF)
	{
		for (int i = 0; i < n; i++)
		{
			int p, f;
			scanf("%i%i",&p,&f);

			price[i] = p;
			favor[i] = f;
		}

		memset(dp, -1, sizeof dp);
		printf("%i\n", rec(0, 0, 0));
	}
}

int rec(int index, int money, int added)
{
	if (money > 2000 && !added)
	{
		money -= 200;
		added = 1;
	}

	if (added)
	{
		if (money == m)
			return 0;
		if (money > m)
			return -INF;
	}
	if (index == n)
	{
		if (money > m)
			return -INF;
		return 0;
	}

	if (dp[index][money][added] != -1)
		return dp[index][money][added];

	int take = rec(index+1, money + price[index], added) + favor[index];
	int leave = rec(index+1, money, added);

	return dp[index][money][added] = max(take, leave);
}
