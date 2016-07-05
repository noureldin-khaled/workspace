#include <bits/stdc++.h>

using namespace std;

int main()
{
	long long f[14];
	f[0] = 1;
	for (int i = 1; i < 14; i++)
		f[i] = i*f[i-1];

	int n, k;
	while(scanf("%i%i",&n,&k) != EOF)
	{
		long long ans = f[n];
		long long tmp = 1;
		for (int i = 0; i < k; i++)
		{
			long long a;
			cin >> a;
			tmp *= f[a];
		}

		cout << ans/tmp << endl;
	}
}
