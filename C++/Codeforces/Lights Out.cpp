#include <bits/stdc++.h>

using namespace std;

int lights[3][3];

void toggle(int i, int j);
bool valid(int i, int j);
int main()
{
	for (int i = 0; i < 3; i++)
		for (int j = 0; j < 3; j++)
			lights[i][j] = 1;
	int grid[3][3];
	for (int i = 0; i < 3; i++)
		for (int j = 0; j < 3; j++)
			scanf("%i",&grid[i][j]);

	for (int i = 0; i < 3; i++)
		for (int j = 0; j < 3; j++)
			if (grid[i][j]%2 != 0)
				toggle(i, j);

	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 3; j++)
			printf("%i",lights[i][j]);
		puts("");
	}
}

void toggle(int i, int j)
{
	lights[i][j] = 1 - lights[i][j];
	if (valid(i, j+1))
		lights[i][j+1] = 1 - lights[i][j+1];

	if (valid(i+1, j))
		lights[i+1][j] = 1 - lights[i+1][j];

	if (valid(i, j-1))
		lights[i][j-1] = 1 - lights[i][j-1];

	if (valid(i-1, j))
		lights[i-1][j] = 1 - lights[i-1][j];
}

bool valid(int i, int j)
{
	return i >= 0 && i < 3 && j >= 0 && j < 3;
}