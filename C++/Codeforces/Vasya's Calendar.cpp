#include <bits/stdc++.h>

using namespace std;

int main()
{
	int d, n;
	scanf("%i%i",&d,&n);

	int ans = 0;
	int day = 1;
	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		if (day > 1)
		{
			ans += (d-day+1);
			day = 1;
		}

		day += a;
	}

	printf("%i\n",ans);

}


