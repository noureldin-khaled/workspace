#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	bool prime[1299710+1];
    for(int k = 0; k <= 1299710; k++)
        prime[k] = true;

    for(int i = 2; i*i <= 1299710; i++)
    {
        if (prime[i])
        {
            for(int j = i*i; j <= 1299710; j += i)
                prime[j] = false;
        }
    }

    prime[0] = prime[1] = false;

    for (int i = 0; i < 1299710; i++)
    {
    	if (prime[i]) 
    	{
	    	printf("%i ", i);
	    	n--;
	    	if (n == 0) break;
    	}
    }
}
