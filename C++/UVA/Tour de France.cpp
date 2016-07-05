#include <bits/stdc++.h>

using namespace std;

int main()
{
	while(true)
	{
		int f;
		scanf("%i",&f);
		if (f == 0) break;

		int r;
		scanf("%i",&r);

		int front[f];
		int rear[r];
		for (int i = 0; i < f; i++)
			scanf("%i",&front[i]);
		for (int i = 0; i < r; i++)
			scanf("%i",&rear[i]);

		int n = f*r;
		double ratios[n];
		int k = 0;
		for (int i = 0; i < r; i++)
			for (int j = 0; j < f; j++)
				ratios[k++] = (double)rear[i] / front[j];

		sort(ratios, ratios + n);
		double ans = 0;
		for (int i = 0; i < n-1; i++)
		{
			double d1 = ratios[i];
			double d2 = ratios[i+1];

			ans = max(ans, d2/d1);
		}

		printf("%.2f\n", ans);
	}
}
