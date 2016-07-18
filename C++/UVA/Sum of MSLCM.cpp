#include <bits/stdc++.h>

using namespace std;

long long sum[20000001];
int main()
{
	for (int i = 0; i < 20000001; i++)
		sum[i] = 1;
	sum[0] = 0;
	for (int i = 2; i < 20000001; i++)
	{
		for (int j = i; j < 20000001; j += i)
			sum[j] += i;
	}

	int n;
	while(true)
	{
		scanf("%i",&n);
		if (n == 0) break;

		long long ans = 0;
		for (int i = 2; i <= n; i++)
			ans += sum[i];

		cout << ans << endl;
	}
}
