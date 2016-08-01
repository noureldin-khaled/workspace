#include <bits/stdc++.h>

using namespace std;

int main()
{
	int b[5] = {1, 10, 100, 1000, 10000};
	int n, m;
	while(scanf("%i%i",&n,&m) != EOF)
	{
		pair<int, pair<int, int> > a[m];
		for (int i = 0; i < m; i++)
		{
			int b;
			scanf("%i", &b);

			int sum = 0;
			int d = -1;
			for (int j = 0; j < n; j++)
			{
				int a;
				scanf("%i",&a);
				sum += a;
				if (j == 0)
					d = a;
			}

			a[i] = make_pair(b, make_pair(d, sum));
		}

		int ans = 0;
		for (int i = 0; i < m; i++)
		{
			if (a[i].second.second <= a[i].first)
				ans += a[i].second.first;
		}

		int newScore = 0;
		for (int i = 0; i < m; i++)
		{
			int cur = 0;
			for (int j = 0; j < 5; j++)
			{
				int newSum = a[i].second.second - a[i].second.first + b[j];
				if (newSum <= a[i].first)
					cur = max(cur, b[j]);
			}

			newScore += cur;
		}

		printf("%i\n", newScore - ans);
	}
}