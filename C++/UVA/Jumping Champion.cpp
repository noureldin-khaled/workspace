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

    int n = primes.size();
	int t;
	scanf("%i",&t);

	int occ[1000001];
	while(t--)
	{
		int l, u;
		scanf("%i%i",&l,&u);
		memset(occ, 0, sizeof occ);

		for (int i = 0; i < n-1; i++)
		{
			if (primes[i] > u || primes[i+1] > u) break;
			if (primes[i] < l) continue;

			occ[primes[i+1]-primes[i]]++;
		}

		int champion = 0;
		int c = 0;

		for (int i = 0; i < 1000001; i++)
		{
			if (occ[i] == 0) continue;
			if (occ[i] > occ[champion])
			{
				champion = i;
				c = 1;
			}
			else if (occ[i] == occ[champion])
				c++;
		}

		if (champion > 0 && c == 1)
			printf("The jumping champion is %i\n", champion);
		else
			puts("No jumping champion");
	}
}
