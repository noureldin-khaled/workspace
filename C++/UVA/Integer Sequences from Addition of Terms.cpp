#include <bits/stdc++.h>

using namespace std;

int c[25];
int n;

long long f(long long i);
long long power(long long base,long long p);
int main()
{
	int t;
	scanf("%i",&t);

	while(t--)
	{
		int d, k;
		scanf("%i",&n);

		for (int i = 0; i <= n; i++)
			scanf("%i", &c[i]);

		scanf("%i\n%i",&d,&k);

		long long i = 1;
		while(true)
		{
			bool done = false;
			long long e = f(i);
			long long limit = i*d;
			for (long long j = 0; j < limit && !done; j++, k--)
			{
				if (k == 1)
				{
					cout << e << endl;
					done = true;
				}
			}

			if (done)
				break;
			i++;
		}
	}
}

long long f(long long i)
{
	long long res = 0;
	for (int j = 0; j <= n; j++)
		res += power(i, (long long)j) * c[j];

	return res;
}

long long power(long long base,long long p)
{
   if (p == 0)
       return 1;
   return base*power(base,p-1);
}