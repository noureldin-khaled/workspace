#include <bits/stdc++.h>

using namespace std;

int sq(int n);
int main()
{
	double s[50001 + 50];
	for (int i = 0; i < 50051; i++)
		s[i] = sqrt((double) i);

	int t;
	scanf("%i",&t);

	int k;
	while(t--)
	{
		scanf("%i",&k);

		bool found = false;
		for (int i = 0; i*i <= k && !found; i++)
		{
			int first = sq(i);
			for (int j = 0; j*j <= k-first && !found; j++)
			{
				int second = sq(j);
				if (first+second > k) continue;

				int third = k - (first+second);
				int r = (int)s[third];

				if (sq(r) == third) 
				{
					printf("%i %i %i\n", i, j, r);
					found = true;
				}
			}
		}

		if (!found)
			printf("%i\n", -1);
	}
}

int sq(int n)
{
	return n * n;
}