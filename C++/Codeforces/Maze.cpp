#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define MAX 501

using namespace std;

char grid[MAX][MAX];
int n, m, s, counter, k;

int dx[4] = {-1,0,1, 0};
int dy[4] = { 0,1,0,-1};

void dfs(int i, int j);
bool valid(int i, int j);
int main()
{
	fast

	cin >> n >> m >> s;
	
	k = 0;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> grid[i][j];
			if (grid[i][j] == '.')
			{
				k++;
				grid[i][j] = 'X';
			}
		}
	}

	counter = 0;
	bool stop = false;
	for (int i = 0; i < n && !stop; i++)
	{
		for (int j = 0; j < m && !stop; j++)
			if (grid[i][j] == 'X')
			{
				dfs(i, j);
				stop = true;
			}
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
				cout << grid[i][j];
		cout << endl;
	}
}

void dfs(int i, int j)
{
	if (counter == (k-s)) return;

	grid[i][j] = '.';
	counter++;

	for (int k = 0; k < 4; k++)
	{
		int newI = i + dx[k];
		int newJ = j + dy[k];

		if (valid(newI, newJ) && grid[newI][newJ] == 'X')
			dfs(newI, newJ);
	}
}

bool valid(int i, int j)
{
	return i >= 0 && i < n && j >= 0 && j < m;
}