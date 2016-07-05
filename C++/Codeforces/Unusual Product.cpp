#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int cur = 0;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
		{
			int a;
			scanf("%i",&a);

			if (i == j)
				cur += a;
		}

	cur %= 2;
	int q;
	scanf("%i",&q);

	while(q--)
	{
		int t;
		scanf("%i",&t);

		if (t == 3)
			printf("%i", cur);
		else
		{
			int u;
			scanf("%i", &u);
			cur = 1 - cur;
		}
	}
}
