#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, b;
	scanf("%i%i",&n, &b);

	long long res[n];
	long long curTime = 0;
	queue<pair<pair<long long, long long>, int> > q;
	int s = 0;

	for (int i = 0; i < n; i++)
	{
		int t, d;
		scanf("%i%i",&t,&d);

		if (curTime > t)
		{
			if (s == b)
				res[i] = -1;
			else
			{
				q.push(make_pair(make_pair(t, d), i));
				s++;
			}
		}
		else
		{
			if (s == 0)
			{
				res[i] = t + d;
				curTime = t + d;
			}
			else
			{
				long long term = curTime;
				if (q.front().first.first > term)
					term = q.front().first.first;

				res[q.front().second] = term + q.front().first.second;
				curTime = term + q.front().first.second;
				q.pop();
				q.push(make_pair(make_pair(t, d), i));
			}
		}
	}

	while(!q.empty())
	{
		long long term = curTime;
		if (q.front().first.first > term)
			term = q.front().first.first;

		res[q.front().second] = term + q.front().first.second;
		curTime = term + q.front().first.second;
		q.pop();
	}

	for (int i = 0; i < n; i++)
		cout << res[i] << " ";
}
