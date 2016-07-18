#include <bits/stdc++.h>

using namespace std;

int size;
bool bs[10000001];
vector<int> primes;

void sieve(int upperbound)
{
	size = upperbound+1;
	for (int i = 0; i < 10000001; i++)
		bs[i] = true;
	bs[0] = bs[1] = false;

	for (long long i = 2; i < size; i++) if (bs[i])
	{
		for (long long j = i*i; j < size; j += i) 
			bs[j] = false;
		primes.push_back((int) i);
	}
}

int main()
{
	sieve(10000000);
	int len = primes.size();
	int n;
	int t = 1;
	while(true)
	{
		scanf("%i",&n);
		if (n == 0) break;

		int low = 0;
		int high = len-1;
		int ans = -1;

		while(low <= high)
		{
			int mid = low + (high-low)/2;

			if (primes[mid] <= n)
			{
				ans = mid;
				low = mid+1;
			}
			else
				high = mid-1;
		}

		long long res = 0;
		for (int i = 0; i <= ans; i++)
		{
			low = i;
			high = ans;
			int idx = -1;

			while(low <= high)
			{
				int mid = low + (high-low)/2;

				if (primes[i]+primes[mid] <= n)
				{
					idx = mid;
					low = mid+1;
				}
				else
					high = mid-1;
			}

			if (idx != -1)
				res += (idx-i);
		}

		printf("Case %i: ", t++);
		cout << res << endl;
	}
}