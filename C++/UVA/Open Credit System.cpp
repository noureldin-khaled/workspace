#include <bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	scanf("%i",&t);

	while(t--)
	{
		int n;
		scanf("%i",&n);

		int ans = -300000;
		int p = -150001;
		for (int i = 0; i < n; i++)
		{
			int a;
			scanf("%i",&a);

			if (p == -150001)
				p = a;
			else
			{
				ans = max(ans, p-a);
				p = max(p, a);
			}
		}

		printf("%i\n", ans);
	}
}
