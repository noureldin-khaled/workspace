#include <bits/stdc++.h>

using namespace std;

int main()
{
	bool prime[2000000+1];
    for(int k = 0; k <= 2000000; k++)
        prime[k] = true;

    for(int i = 2; i*i <= 2000000; i++)
    {
        if (prime[i])
        {
            for(int j = i*i; j <= 2000000; j += i)
                prime[j] = false;
        }
    }

    prime[0] = prime[1] = false;

	int n;
	scanf("%i",&n);

	int arr[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);

	int f = -1;
	int s = -1;
	for (int i = 0; i < n; i++)
		for (int j = i+1; j < n; j++)
			if (prime[arr[i] + arr[j]])
			{
				f = arr[i];
				s = arr[j];
			}

	int ones = 0;
	for (int i = 0; i < n; i++)
		if (arr[i] == 1)
			ones++;

	int off = 0;
	if (ones > 0)
		off = 1;

	int extra = -1;
	for (int i = 0; i < n; i++)
		if (arr[i] > 1 && prime[off + arr[i]])
			extra = arr[i];

	int ans1 = 0;
	if (f != -1 && s != -1)
		ans1 = 2;
	int ans2 = ones;
	if (extra != -1)
		ans2++;

	if (ans1 > ans2)
		printf("%i\n%i %i\n", ans1, f, s);
	else if (ans2 > 0)
	{
		printf("%i\n", ans2);
		if (extra != -1)
			printf("%i ", extra);
		for (int i = 0; i < ones; i++)
			printf("%i ", 1);
		puts("");
	}
	else
		printf("%i\n%i\n", 1, arr[0]);
}
