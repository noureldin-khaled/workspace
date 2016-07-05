#include <bits/stdc++.h>

using namespace std;

int n;
bool prime[33];
bool used[33];
int res[17];

void rec(int num, int k);
int main()
{
	memset(prime, false, sizeof prime);
	prime[2] = prime[3] = prime[5] = prime[7] = prime[11] = prime[13] = prime[17] = prime[19] = prime[23] = prime[29] = prime[31] = true;
	int t = 1;
	while(scanf("%i",&n) != EOF)
	{
		if (t > 1)
			puts("");
		memset(used, false, sizeof used);
		memset(res, 0, sizeof res);
		printf("Case %i:\n", t++);
		used[1] = true;
		res[0] = 1;
		rec(1, 1);
	}
}

void rec(int num, int k)
{
	if (k == n)
	{
		if (prime[res[k-1] + 1])
		{
			for (int i = 0; i < n; i++)
			{
				if (i > 0)
					printf(" ");
				printf("%i", res[i]);
			}
			puts("");
		}

		return;
	}

	for (int i = 1; i <= n; i++)
	{
		if (!used[i] && prime[num+i])
		{
			used[i] = true;
			res[k] = i;
			rec(i, k+1);
			res[k] = 0;
			used[i] = false;
		}
	}
}
