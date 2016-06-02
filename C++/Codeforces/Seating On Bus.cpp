#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, m;
	scanf("%i%i",&n,&m);

	int arr[n][4];
	memset(arr, 0, sizeof arr);

	int row = n-1;
	int col = 0;
	for (int i = 1; i <= m; i++)
	{
		arr[row][col] = i;

		if (col > 1)
		{
			row--;
			if (row < 0)
			{
				row = n-1;
				col = 1;
			}
			else
				col = 3-col;
		}
		else
			col = 3-col;
	}

	for (int i = n-1; i >= 0; i--)
	{
		if (arr[i][1] != 0)
			printf("%i ", arr[i][1]);

		if (arr[i][0] != 0)
			printf("%i ", arr[i][0]);

		if (arr[i][2] != 0)
			printf("%i ", arr[i][2]);

		if (arr[i][3] != 0)
			printf("%i ", arr[i][3]);
	}

	// for (int i = 0; i < n; i++)
	// {
	// 	for (int j = 0; j < 4; j++)
	// 		cout << arr[i][j] << " ";
	// 	cout << endl;
	// }
}