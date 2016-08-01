#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

int grid[4][4];
int tmp[4][4];

bool valid();
int main()
{
	fast

	int t;
	cin >> t;
	for (int c = 1; c <= t; c++)
	{
		cout << "Case " << c << ":" << endl;

		bool found[17];
		memset(found, false, sizeof found);
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
			{
				cin >> grid[i][j];
				if (grid[i][j] != -1)
					found[grid[i][j]] = true;
			}

		int a[9];
		int k = 0;
		for (int i = 1; i <= 16; i++)
		{
			if (!found[i])
				a[k++] = i;
		}

		sort(a, a+9);

		int ans[4][4];
		do {
			int idx = 0;

			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++)
					if (grid[i][j] == -1)
						tmp[i][j] = a[idx++];
					else
						tmp[i][j] = grid[i][j];


			if (valid())
			{
				for (int i = 0; i < 4; i++)
					for (int j = 0; j < 4; j++)
						ans[i][j] = tmp[i][j];
				break;
			}

		}while(next_permutation(a, a+9));

		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				if (j > 0)
					cout << " ";
				cout << ans[i][j];
			}
			cout << endl;
		}
	}
}

bool valid()
{
	int sum = 0;
	for (int i = 0; i < 4; i++)
		sum += tmp[0][i];

	for (int i = 0; i < 4; i++)
	{
		int cur = 0;
		for (int j = 0; j < 4; j++)
				cur += tmp[i][j];
			if (cur != sum)
				return false;
	}

	for (int j = 0; j < 4; j++) 
	{
		int cur = 0;
		for (int i = 0; i < 4; i++)
			cur += tmp[i][j];
		if (cur != sum)
			return false;
	}

	return true;
}