#include <bits/stdc++.h>

using namespace std;

int MOD(int a, int mod);
int main()
{
	int p, n;
	scanf("%i%i",&p,&n);

	int arr[p];
	memset(arr, -1, sizeof arr);
	for (int i = 0; i < n; i++)
	{
		int num;
		scanf("%i",&num);

		int m = MOD(num, p);
		if (arr[m] != -1)
		{
			printf("%i\n",i+1);
			return 0;
		}

		arr[m] = num;
	}

	printf("%i\n", -1);
}

int MOD(int a, int mod)
{
	return (a%mod + mod)%mod;
}
