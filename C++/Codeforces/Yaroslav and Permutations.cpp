#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int occ[1001];
	memset(occ, 0, sizeof occ);

	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		occ[a]++;
	}

	int half = n/2;
	if (n%2 != 0)
		half++;

	for (int i = 0; i < 1001; i++)
	{
		if (occ[i] > half)
		{
			puts("NO");
			return 0;
		}
	}

	puts("YES");
}


