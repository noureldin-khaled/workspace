#include <bits/stdc++.h>

using namespace std;

bool rightt[10];
bool leftt[10];
bool up[10];
bool down[10];
int in[10];
int n;

bool valid(int i, int j);
bool isSure();
bool canRight();
bool canLeft();
bool canUp();
bool canDown();
int main()
{
	int arr[4][3];
	memset(arr, -1, sizeof arr);
	int k = 1;
	for (int i = 0; i < 3; i++)
		for (int j = 0; j < 3; j++)
			arr[i][j] = k++;

	arr[3][1] = 0;

	memset(rightt, false, sizeof rightt);
	memset(leftt, false, sizeof leftt);
	memset(up, false, sizeof up);
	memset(down, false, sizeof down);

	for (int i = 0; i < 4; i++)
		for (int j = 0; j < 3; j++)
		{
			if (arr[i][j] == -1) continue;

			if (valid(i, j+1) && arr[i][j+1] != -1)
				rightt[arr[i][j]] = true;
			if (valid(i, j-1) && arr[i][j-1] != -1)
				leftt[arr[i][j]] = true;
			if (valid(i-1, j) && arr[i-1][j] != -1)
				up[arr[i][j]] = true;
			if (valid(i+1, j) && arr[i+1][j] != -1)
				down[arr[i][j]] = true;
		}

	scanf("%i",&n);

	string s;
	cin >> s;
	for (int i = 0; i < n; i++)
		in[i] = s[i] - '0';

	if (isSure())
		puts("YES");
	else
		puts("NO");
}

bool isSure()
{
	if (canRight())
		return false;
	if (canLeft())
		return false;
	if (canUp())
		return false;
	if (canDown())
		return false;
	return true;
}

bool canRight()
{
	for (int i = 0; i < n; i++)
		if (!rightt[in[i]])
			return false;
	return true;
}

bool canLeft()
{
	for (int i = 0; i < n; i++)
		if (!leftt[in[i]])
			return false;
	return true;
}

bool canUp()
{
	for (int i = 0; i < n; i++)
		if (!up[in[i]])
			return false;
	return true;
}

bool canDown()
{
	for (int i = 0; i < n; i++)
		if (!down[in[i]])
			return false;
	return true;
}

bool valid(int i, int j)
{
	return i >= 0 && i < 4 && j >= 0 && j < 3;
}