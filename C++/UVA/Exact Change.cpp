#include <bits/stdc++.h>
#define INF 1000000000

using namespace std;

int n, m;
int arr[101];
pair<int, int> dp[101][10001];

pair<int, int> rec(int index, int money);
int main()
{
	int t;
	scanf("%i",&t);

	while(t--)
	{
		scanf("%i%i",&m,&n);
		for (int i = 0; i < n; i++)
			scanf("%i",&arr[i]);

		for (int i = 0; i < 101; i++)
			for (int j = 0; j < 10001; j++)
				dp[i][j] = make_pair(-INF, -INF);

		pair<int, int> ans = rec(0, 0);
		printf("%i %i\n", ans.first, ans.second);
	}
}

pair<int, int> rec(int index, int money)
{
	if (money >= m)
		return make_pair(money, 0);
	if (index == n)
		return make_pair(INF, INF);

	if (dp[index][money].first != -INF && dp[index][money].second != -INF)
		return dp[index][money];

	pair<int, int> take = rec(index+1, money + arr[index]);
	take.second++;
	pair<int, int> leave = rec(index+1, money);

	if (take.first < leave.first)
		return dp[index][money] = take;
	if (take.first > leave.first)
		return dp[index][money] = leave;

	if (take.second < leave.second)
		return dp[index][money] = take;
	return dp[index][money] = leave;
}
