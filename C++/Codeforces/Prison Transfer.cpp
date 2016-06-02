#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, t, c;
	scanf("%i%i%i",&n,&t,&c);

	int cur = 0;
	int ans = 0;
	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		if (a > t)
			cur = 0;
		else
		{
			if (cur == c)
				ans++;
			else
			{
				cur++;
				if (cur == c)
					ans++;
			}
		}
	}

	printf("%i\n", ans);
}

