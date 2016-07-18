#include <bits/stdc++.h>

using namespace std;

int t, n, m;
char grid[9][9];
int dx[3] = {-1,0,0};
int dy[3] = {0,1,-1};
string dir[3] = {"forth", "right", "left"};
char arr[7] = {'I','E','H','O','V','A','#'};
vector<string> res;

bool valid(int i, int j);
void rec(int i, int j, int idx);
int main()
{
	scanf("%i", &t);
	while(t--)
	{
		res.clear();
		scanf("%i%i",&m,&n);

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				scanf(" %c",&grid[i][j]);

		int stX = m-1;
		int stY = -1;
		for (int i = 0; i < n; i++)
			if (grid[m-1][i] == '@')
			{
				stY = i;
				break;
			}

		rec(stX, stY, 0);
		for (int i = 0; i < res.size(); i++)
		{
			if (i > 0)
				printf(" ");
			cout << res[i];
		}
		puts("");
	}
}

bool valid(int i, int j)
{
	return i >= 0 && i < m && j >= 0 && j < n;
}

void rec(int i, int j, int idx)
{
	if (grid[i][j] == '#')
		return;
	for (int k = 0; k < 3; k++)
	{
		int newI = i + dx[k];
		int newJ = j + dy[k];

		if (valid(newI, newJ) && grid[newI][newJ] == arr[idx])
		{
			res.push_back(dir[k]);
			rec(newI, newJ, idx+1);
		}
	}
}
