#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, m;
	scanf("%i%i",&n,&m);

	int total = 0;
	char grid[n][m];
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
		{
			char c;
			scanf(" %c",&c);
			grid[i][j] = c;
			if (c == '*') total++;
		}

	int maximumInRow = -1;
	int rowIndex = -1;
	for (int i = 0; i < n; i++)
	{
		int cur = 0;
		for (int j = 0; j < m; j++)
		{
			if (grid[i][j] == '*')
				cur++;
		}

		if (cur > maximumInRow)
		{
			maximumInRow = cur;
			rowIndex = i;
		}
	}

	for (int j = 0; j < m; j++)
	{
		int cur = 0;
		for (int i = 0; i < n; i++)
		{
			if (grid[i][j] == '*')
				cur++;
		}
		pair<int, int> intersection = make_pair(rowIndex, j);
		int walls = maximumInRow+cur;

		if (grid[intersection.first][intersection.second] == '*')
			walls--;

		if (walls == total)
		{
			puts("YES");
			printf("%i %i\n", intersection.first+1, intersection.second+1);
			return 0;
		}
	}

	int maximumInCol = -1;
	int colIndex = -1;
	for (int j = 0; j < m; j++)
	{
		int cur = 0;
		for (int i = 0; i < n; i++)
		{
			if (grid[i][j] == '*')
				cur++;
		}
		if (cur > maximumInCol)
		{
			maximumInCol = cur;
			colIndex = j;
		}
	}

	for (int i = 0; i < n; i++)
	{
		int cur = 0;
		for (int j = 0; j < m; j++)
		{
			if (grid[i][j] == '*')
				cur++;
		}

		pair<int, int> intersection = make_pair(i, colIndex);
		int walls = maximumInCol+cur;

		if (grid[intersection.first][intersection.second] == '*')
			walls--;

		if (walls == total)
		{
			puts("YES");
			printf("%i %i\n", intersection.first+1, intersection.second+1);
			return 0;
		}
	}

	puts("NO");
}
