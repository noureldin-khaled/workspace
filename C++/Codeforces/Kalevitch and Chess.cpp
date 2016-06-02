#include <bits/stdc++.h>

using namespace std;

int main()
{
	char grid[8][8];

	for (int i = 0; i < 8; i++)
	{
		string line;
		cin >> line;
		for (int j = 0; j < 8; j++)
			grid[i][j] = line[j];
	}

	int ans = 0;
	for (int i = 0; i < 8; i++)
	{
		bool allBlack = true;
		for (int j = 0; j < 8 && allBlack; j++)
		{
			if (grid[i][j] == 'W')
				allBlack = false;
		}

		if (allBlack)
		{
			for (int j = 0; j < 8; j++)
				grid[i][j] = 'T';
			ans++;
		}
	}

	for (int j = 0; j < 8; j++)
	{
		bool allBlack = true;
		for (int i = 0; i < 8 && allBlack; i++)
		{
			if (grid[i][j] == 'W')
				allBlack = false;
		}

		if (allBlack)
		{
			bool allTaken = true;
			for (int i = 0; i < 8 && allTaken; i++)
			{
				if (grid[i][j] != 'T')
					allTaken = false;
			}

			if (!allTaken)
			{
				for (int i = 0; i < 8; i++)
				{
					if (grid[i][j] == 'B')
						grid[i][j] = 'T';
				}
				ans++;
			}
		}
	}

	printf("%i\n", ans);
}
