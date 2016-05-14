#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int occ[30000];
	memset(occ, 0, sizeof occ);

	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		occ[a]++;
	}
	

	int ans = 0;
	for (int i = 1; i < 30000; i++)
	{
		if (occ[i] == 0 || occ[i] == 1) continue;

		for (int j = i+1; j < 30000; j++)
		{
			if (occ[j] == 0)
			{
				ans += (j-i) * (occ[i] - 1);
				occ[j] = occ[i] - 1;
				occ[i] = 1;
				break;
			}
		}
	}


	printf("%i",ans);
}