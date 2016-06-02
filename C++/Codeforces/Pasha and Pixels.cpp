#include <bits/stdc++.h>
#define MAX 1000

using namespace std;

int arr[MAX][MAX];
int n, m;

bool isValid(int i, int j);
bool inBounds(int i, int j);
int main()
{
	int k;
	scanf("%i%i%i",&n,&m,&k);

	memset(arr, 0, sizeof arr);
	for (int i = 0; i < k; i++)
	{
		int x, y;
		scanf("%i%i",&x,&y);
		x--;y--;

		arr[x][y] = 1;
		if (!isValid(x, y))
		{
			printf("%i\n", i+1);
			return 0;
		}
	}

	printf("%i\n", 0);
}

bool isValid(int i, int j)
{
	if (inBounds(i-1, j) && inBounds(i-1, j-1) && inBounds(i, j-1) && arr[i][j] == 1 && arr[i-1][j] == 1 && arr[i][j-1] == 1 && arr[i-1][j-1] == 1)
		return false;
	
	if (inBounds(i-1, j) && inBounds(i-1, j+1) && inBounds(i, j+1) && arr[i][j] == 1 && arr[i-1][j] == 1 && arr[i][j+1] == 1 && arr[i-1][j+1] == 1)
		return false;
	
	if (inBounds(i+1, j) && inBounds(i+1, j-1) && inBounds(i, j-1) && arr[i][j] == 1 && arr[i+1][j] == 1 && arr[i][j-1] == 1 && arr[i+1][j-1] == 1)
		return false;
	
	if (inBounds(i+1, j) && inBounds(i+1, j+1) && inBounds(i, j+1) && arr[i][j] == 1 && arr[i+1][j] == 1 && arr[i][j+1] == 1 && arr[i+1][j+1] == 1)
		return false;


	return true;
}

bool inBounds(int i, int j)
{
	return i >= 0 && i < n && j >= 0 && j < m;
}