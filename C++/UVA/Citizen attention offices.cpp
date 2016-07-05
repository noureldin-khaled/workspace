#include <bits/stdc++.h>

using namespace std;

int dist(int i, int j, int x, int y);
int main()
{
	pair<int, int> p[25];
	int row = 0;
	int col = 0;
	for (int i = 0; i < 25; i++)
	{
		p[i] = make_pair(row, col);
		col++;
		if (col == 5)
		{
			row++;
			col = 0;
		}
	}

	int t;
	scanf("%i",&t);

	while(t--)
	{
		int n;
		scanf("%i",&n);

		pair<int, pair<int, int> > arr[n];
		for (int i = 0; i < n; i++)
		{
			int x, y, q;
			scanf("%i%i%i",&x,&y,&q);

			arr[i] = make_pair(q, make_pair(x, y));
		}

		int minimum = -1;
		int a = -1, b = -1, x = -1, y = -1, z = -1;
		for (int i = 0; i < 25; i++)
			for (int j = i+1; j < 25; j++)
				for (int k = j+1; k < 25; k++)
					for (int r = k+1; r < 25; r++)
						for (int c = r+1; c < 25; c++)
						{
							int cur = 0;
							for (int u = 0; u < n; u++)
							{
								int first = arr[u].first * dist(p[i].first, p[i].second, arr[u].second.first, arr[u].second.second);
								int second = arr[u].first * dist(p[j].first, p[j].second, arr[u].second.first, arr[u].second.second);
								int third = arr[u].first * dist(p[k].first, p[k].second, arr[u].second.first, arr[u].second.second);
								int fourth = arr[u].first * dist(p[r].first, p[r].second, arr[u].second.first, arr[u].second.second);
								int fifth = arr[u].first * dist(p[c].first, p[c].second, arr[u].second.first, arr[u].second.second);

								cur += min(min(first, second), min(min(third, fourth), fifth));
							}

							if (minimum == -1 || cur < minimum)
							{
								a = i;
								b = j;
								x = k;
								y = r;
								z = c;
								minimum = cur;
							}
						}

		printf("%i %i %i %i %i\n", a, b, x, y, z);
	}
}

int dist(int i, int j, int x, int y)
{
	return abs(x-i) + abs(y-j);
}
