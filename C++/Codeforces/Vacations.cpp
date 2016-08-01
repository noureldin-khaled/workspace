#include <bits/stdc++.h>
#define CONTEST 0
#define GYM 1
#define REST 2
#define INF 1000000000

using namespace std;

int n;
int a[105];
int dp[105][5];

int rec(int idx, int prev);
int main()
{
	scanf("%i",&n);

	for (int i = 0; i < n; i++)
		scanf("%i",&a[i]);

	memset(dp, -1, sizeof dp);
	printf("%i\n", rec(0, REST));
}

int rec(int idx, int prev)
{
	if (idx == n)
		return 0;
	if (dp[idx][prev] != -1)
		return dp[idx][prev];

	int rest = rec(idx+1, REST) + 1;
	int contest = INF;
	if ((a[idx] == 1 || a[idx] == 3) && prev != CONTEST)
		contest = rec(idx+1, CONTEST);
	int gym = INF;
	if ((a[idx] == 2 || a[idx] == 3) && prev != GYM)
		gym = rec(idx+1, GYM);

	return dp[idx][prev] = min(rest, min(contest, gym));
}