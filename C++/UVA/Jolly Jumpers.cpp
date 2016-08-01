#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	while(scanf("%i", &n) != EOF)
	{
		int a[n];
		for (int i = 0; i < n; i++)
			scanf("%i",&a[i]);

		bool occ[n];
		memset(occ, false, sizeof occ);
		for (int i = 0; i < n-1; i++)
			occ[abs(a[i] - a[i+1])] = true;

		bool valid = true;
		for (int i = 1; i < n; i++)
			valid &= occ[i];

		if (valid)
			puts("Jolly");
		else
			puts("Not jolly");
	}
}
