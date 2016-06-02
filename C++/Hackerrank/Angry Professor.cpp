#include <bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	scanf("%i",&t);

	while(t--)
	{
		int n, k;
		scanf("%i%i",&n,&k);

		int a = 0;
		for (int i = 0; i < n; i++)
		{
			int time;
			scanf("%i",&time);

			if (time <= 0)
				a++;
		}

		if (a < k)
			puts("YES");
		else
			puts("NO");
	}
}
