#include <bits/stdc++.h>

using namespace std;

int main()
{
	int occ[101];
	memset(occ, 0, sizeof occ);

	int sum = 0;
	for (int i = 0; i < 5; i++)
	{
		int a;
		scanf("%i",&a);

		sum += a;
		occ[a]++;
	}

	int ans = sum;
	for (int i = 0; i < 101; i++)
	{
		if (occ[i] > 3) occ[i] = 3;
		if (occ[i] > 1)
			ans = min(ans, sum - i*occ[i]);
	}

	printf("%i\n",ans);
}
