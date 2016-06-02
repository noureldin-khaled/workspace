#include <bits/stdc++.h>

using namespace std;

int n, m;
char grid[105][105];

void place(int i, int j, char c);
bool valid(int i, int j);
int main()
{
	scanf("%i%i",&n,&m);

	for (int i = 0; i < n; i++)
	{
		string line;
		cin >> line;
		for (int j = 0; j < m; j++)
			grid[i][j] = line[j];
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (grid[i][j] == '.')
			{
				place(i, j, 'B');
			}
		}
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
			cout << grid[i][j];
		puts("");
	}

}

void place(int i, int j, char c)
{
	grid[i][j] = c;
	if (valid(i-1, j) && grid[i-1][j] == '.')
		place(i-1, j, c == 'B' ? 'W': 'B');
	
	if (valid(i, j-1) && grid[i][j-1] == '.')
		place(i, j-1, c == 'B' ? 'W': 'B');

	if (valid(i, j+1) && grid[i][j+1] == '.')
		place(i, j+1, c == 'B' ? 'W': 'B');

	if (valid(i+1, j) && grid[i+1][j] == '.')
		place(i+1, j, c == 'B' ? 'W': 'B');
}

bool valid(int i, int j)
{
	return i >= 0 && i < n && j >= 0 && j < m;
}
