#include <bits/stdc++.h>
#define EPS 1e-9

using namespace std;

int main()
{
	int V, V0;
	while(true)
	{
		scanf("%i%i",&V,&V0);

		if (V+V0 == 0) break;

		double maximum = 0;
		int ans = 0;
		for (int i = 1; i <= 500000; i++)
		{
			double each = (double)V/i;
			double cur = 0.0;
			if (each > V0)
				cur = 0.3*sqrt(each-V0);

			cur *= i;
			if (cur > maximum + EPS)
			{
				maximum = cur;
				ans = i;
			}
			else if (abs(cur-maximum) < EPS)
			{
				ans = 0;
				break;
			}
		}

		printf("%i\n", ans);
	}
}
