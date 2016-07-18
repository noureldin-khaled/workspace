#include <bits/stdc++.h>
#define toString( x ) dynamic_cast< std::ostringstream & >( \
( std::ostringstream() << std::dec << x ) ).str()

using namespace std;

int ans;
int arr[8][8];
int q[8];

void go(int c);
bool canPlace(int c, int r);
int main()
{
	int t;
	scanf("%i",&t);

	while(t--)
	{
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				scanf("%i",&arr[i][j]);

		ans = 0;
		go(0);
		string s = toString(ans);
		for (int i = s.length(); i < 5; i++)
			printf(" ");
		printf("%i\n", ans);
	}
}

void go(int c)
{
	if (c == 8)
	{
		int sum = 0;
		for (int i = 0; i < 8; i++)
			sum += arr[q[i]][i];
		ans = max(ans, sum);
		return;
	}

	for (int r = 0; r < 8; r++)
	{
		if (canPlace(c, r))
		{
			q[c] = r;
			go(c+1);
		}
	}
}

bool canPlace(int c, int r)
{
	for (int i = 0; i < c; i++)
		if (q[i] == r || (abs(i-c) == abs(q[i]-r)))
			return false;
	return true;
}
