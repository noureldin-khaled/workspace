#include <bits/stdc++.h>
#define UP 0
#define DOWN 1
#define LEFT 2
#define RIGHT 3

using namespace std;

int dir(pair<int, int> p1, pair<int, int> p2);
int dang(int d1, int d2);
int main()
{
	int n;
	scanf("%i",&n);

	pair<int, int> arr[n+1];
	for (int i = 0; i<  n+1; i++)
	{
		int x, y;
		scanf("%i%i",&x,&y);

		arr[i] = make_pair(x, y);
	}

	int ans = 0;
	for (int i = 0; i < n-2; i++)
	{
		int dir1 = dir(arr[i], arr[i+1]);
		int dir2 = dir(arr[i+1], arr[i+2]);

		ans += dang(dir1, dir2);
	}

	printf("%i\n",ans);
}

int dir(pair<int, int> p1, pair<int, int> p2)
{
	if (p1.first == p2.first)
	{
		if (p2.second > p1.second)
			return UP;
		return DOWN;
	}
	
	if (p2.first > p1.first)
			return RIGHT;
		return LEFT;
}

int dang(int d1, int d2)
{
	if (d1 == RIGHT && d2 == UP || d1 == LEFT && d2 == DOWN || d1 == UP && d2 == LEFT || d1 == DOWN && d2 == RIGHT)	
		return true;
	return false;
}