#include <bits/stdc++.h>

using namespace std;

int main()
{
	bool prime[50+1];
    for(int k = 0; k <= 50; k++)
        prime[k] = true;

    for(int i = 2; i*i <= 50; i++)
    {
        if (prime[i])
        {
            for(int j = i*i; j <= 50; j += i)
                prime[j] = false;
        }
    }

    prime[0] = prime[1] = false;

    vector<int> v;
    for(int i = 0; i < 50+1; i++)
    	if (prime[i])
    		v.push_back(i);

    int k = 0;
	for (int i = 0; i < v.size(); i++)
	{
		printf("%i\n",v[i]);
		fflush(stdout);
		string res;
		cin >> res;
		if (res.compare("yes") == 0)
			k++;
	}

	if (k > 1)
	{
		puts("composite");
		return 0;
	}

	int arr[4] = {4, 9, 25, 49};

	for (int i = 0; i < 4; i++)
	{
		printf("%i\n",arr[i]);
		fflush(stdout);
		string res;
		cin >> res;
		if (res.compare("yes") == 0)
		{
			puts("composite");
			return 0;
		}
	}

	puts("prime");
}
