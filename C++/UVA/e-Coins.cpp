#include <bits/stdc++.h>
#define INF 1000000000
#define EPS 1e-9

using namespace std;

int n;
double s;
int convensional[45];
int infoTech[45];
int dp[42][301][301];

int rec(int index, int conv, int info);
double calc(int c, int i);
int main()
{
	int t;
	scanf("%i",&t);

	while(t--)
	{
		scanf("%i%lf",&n,&s);
		for (int i = 0; i < n; i++)
			scanf("%i%i",&convensional[i],&infoTech[i]);

		memset(dp, -1, sizeof dp);
		int ans = rec(0, 0, 0);
		if (ans >= INF)
			puts("not possible");
		else
			printf("%i\n", ans);
	}
}

int rec(int index, int conv, int info)
{
	double c = calc(conv, info);
	if (abs(c-s) < EPS)
		return 0;
	if (index == n || c > s + EPS)
		return INF;

	if (dp[index][conv][info] != -1)
		return dp[index][conv][info];

	int take = rec(index, conv+convensional[index], info+infoTech[index]) + 1;
	int leave = rec(index+1, conv, info);

	return dp[index][conv][info] = min(take, leave);
}

double calc(int c, int i)
{
	return sqrt((double)c*c + (double)i*i);
}