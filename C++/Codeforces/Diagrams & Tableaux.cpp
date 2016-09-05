#include <bits/stdc++.h>

using namespace std;

int k, n, r;
int a[7][7];
int b[7];
int dp[10][1000];

int rec(int idx, int msk);
int main()
{
	while(scanf("%i", &k) != EOF)
	{
		memset(a, 0, sizeof a);
		for (int i = 0; i < k; i++)
		{
			scanf("%i",&r);
			for (int j = 0; j < r; j++)
				a[i][j] = 1;
		}

		for (int j = 0; j < 7; j++)
		{
			int sum = 0;
			for (int i = 0; i < 7; i++)
				sum += a[i][j];
			b[j] = sum;
		}

		scanf("%i", &n);

		memset(dp, -1, sizeof dp);
		printf("%d\n" , rec(0, 0));
	}
}

int rec(int idx, int msk)
{
	if (idx == 7)
		return 1;

	if (dp[idx][msk] != -1)
		return dp[idx][msk];

	vector<int> q;
	int s = 0;
	for (int i = 0; i < 7; i++)
		if ((msk & (1 << i)) != 0)
		{
			q.push_back(i+1);
			s++;
		}

	while (s < 7)
	{
		q.push_back(0);
		s++;
	}

	int ans = 0;
	for (int i = 0; i < (1 << n); i++)
	{
		int sum = 0;
		for (int j = 0; j < n; j++)
			if ((i & (1 << j)) != 0)
				sum++;

		if (sum == b[idx])
		{
			int index = 0;
			bool valid = true;
			for (int j = 0; j < n && valid; j++)
				if ((i & (1 << j)) != 0)
				{
					int e = q[index++];
					if (j+1 < e)
						valid = false;
				}

			if (valid)
				ans += rec(idx+1, i);
		}
	}

	return dp[idx][msk] = ans;
}
