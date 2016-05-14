#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, m;
	scanf("%i%i",&n,&m);

	int d1 = 1000000000;
	int d2 = -1;

	for (int i = 0; i < m; i++)
	{
		int x, y;
		scanf("%i%i",&x,&y);

		if (min(x, y) > d2)
			d2 = min(x, y);

		if (max(x, y) < d1)
			d1 = max(x, y);
	}

	printf("%i\n", d2 != -1 ? max(d1-d2, 0) : n-1);
}
