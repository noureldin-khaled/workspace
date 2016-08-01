#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	while(scanf("%i",&n) != EOF)
	{
		int ans = 0;
		for (int i = 0; i < 5; i++)
		{
			int a;
			scanf("%i",&a);
			if (a == n)
				ans++;
		}

		printf("%i\n", ans);
	}
}