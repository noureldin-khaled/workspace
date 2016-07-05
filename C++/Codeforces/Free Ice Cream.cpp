#include <bits/stdc++.h>

using namespace std;

int main()
{
	long long n, x;
	cin >> n >> x;

	long long cones = 0;
	int dis = 0;
	for (int i = 0; i < n; i++)
	{
		char c;
		int d;
		scanf(" %c%i",&c,&d);

		if (c == '+')
			x += d;
		else
		{
			if (x - d >= 0)
				x -= d;
			else
				dis++;
		}
	}

	cout << x << " " << dis << endl;
}
