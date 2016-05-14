#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, s;
	scanf("%i%i",&n, &s);

	int ans = -1;
	for (int i = 0; i < n; i++)
	{
		int x, y;
		scanf("%i%i",&x, &y);

		if (y == 0)
		{
			if (x <= s)
				ans = max(ans, 0);
			continue;
		}
		if (x+1 > s) continue;

		ans = max(ans, 100 - y);

	}
	printf("%i", ans);
}
