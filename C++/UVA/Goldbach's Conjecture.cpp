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

	vector<int> primes;
	for(int i = 0; i < 1000000+1; i++)
		if (prime[i])
			primes.push_back(i);

	int len = primes.size();
	int n;
	while(true)
	{
		scanf("%i",&n);
		if (n == 0) break;
		int f = -1;
		int s = -1;
		for (int i = 0; i < len; i++)
		{
			int curPrime = primes[i];
			if (curPrime > n) break;

			if (prime[n-curPrime])
			{
				f = curPrime;
				s = n-curPrime;
				break;
			}
		}

		if (f == -1 && s == -1)
			puts("Goldbach's conjecture is wrong.");
		else
			printf("%i = %i + %i\n", n, f, s);
	}
}
