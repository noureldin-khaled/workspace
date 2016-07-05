#include <bits/stdc++.h>

using namespace std;

int main()
{
	bool prime[1000000+1];
	for(int k = 0; k <= 1000000; k++)
		prime[k] = true;

	for(int i = 2; i*i <= 1000000; i++)
	{
		if (prime[i])
		{
			for(int j = i*i; j <= 1000000; j += i)
				prime[j] = false;
		}
	}

	prime[0] = prime[1] = false;

	vector<int> v;
	for(int i = 0; i < 1000000+1; i++)
		if (prime[i])
			v.push_back(i);

		int len = v.size();
		int n;
		while(true)
		{
			scanf("%i",&n);
			if (n == 0) break;

			int f = -1;
			int s = -1;
			for (int i = 0; i < len; i++)
			{
				int curPrime = v[i];
				if (curPrime > n)
					break;
				if (prime[n-curPrime])
				{
					f = curPrime;
					s = n-curPrime;
					break;
				}
			}

			printf("%i:\n", n);
			if (f == -1 && s == -1)
				puts("NO WAY!");
			else
				printf("%i+%i\n",f,s);
		}
	}
