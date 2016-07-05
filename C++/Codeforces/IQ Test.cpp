#include <bits/stdc++.h>

using namespace std;

char grid[4][4];

char switchh(char c);
bool valid(int i, int j);
bool has(int i, int j);
bool equal(char c1, char c2, char c3, char c4);
int main()
{
	for (int i = 0; i < 4; i++)
		for (int j = 0; j < 4; j++)
			scanf(" %c",&grid[i][j]);

	for (int i = 0; i < 4; i++)
		for (int j = 0; j < 4; j++)
		{
			if (has(i, j))
			{
				puts("YES");
				return 0;
			}

			grid[i][j] = switchh(grid[i][j]);

			if (has(i, j))
			{
				puts("YES");
				return 0;
			}

			grid[i][j] = switchh(grid[i][j]);
		}

	puts("NO");
}

bool has(int i, int j)
{
	if (valid(i-1, j-1) && valid(i-1, j) && valid(i, j-1) && equal(grid[i][j], grid[i-1][j], grid[i-1][j-1], grid[i][j-1]))
		return true;

	if (valid(i-1, j+1) && valid(i-1, j) && valid(i, j+1) && equal(grid[i][j], grid[i-1][j], grid[i-1][j+1], grid[i][j+1]))
		return true;
	
	if (valid(i+1, j-1) && valid(i+1, j) && valid(i, j-1) && equal(grid[i][j], grid[i+1][j], grid[i+1][j-1], grid[i][j-1]))
		return true;
	
	if (valid(i+1, j+1) && valid(i+1, j) && valid(i, j+1) && equal(grid[i][j], grid[i+1][j], grid[i+1][j+1], grid[i][j+1]))
		return true;
	
	return false;
}

bool valid(int i, int j)
{
	return i >= 0 && i < 4 && j >= 0 && j < 4;
}

char switchh(char c)
{
	return c == '.' ? '#' : '.';
}

bool equal(char c1, char c2, char c3, char c4)
{
	return c1 == c2 && c1 == c3 && c1 == c4;
}
