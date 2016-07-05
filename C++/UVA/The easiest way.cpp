#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	
	while(true)
	{
		scanf("%i",&n);
		if (n == 0) break;

		int ans = -1;
		double maximum = 0;
		for (int i = 1; i <= n; i++)
		{
			int x, y;
			scanf("%i%i",&x,&y);
			double l = max(x, y);
			double s = min(x, y);

			if (max(s/2.0, min(l/4.0, s)) > maximum)
			{
				maximum = max(s/2.0, min(l/4.0, s));
				ans = i;
			}
		}

		printf("%i\n",ans);
	}
}
