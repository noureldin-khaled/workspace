#include <bits/stdc++.h>

using namespace std;

long long nCr(int n, int k);
int main()
{
	int n;
	while(true)
	{
		scanf("%i",&n);
		if (n < 0) break;

		if (n == 0)
			cout << 1 << endl;
		else
			cout << (n << 1) + nCr(n-1, 2) << endl;
	}
}

long long nCr(int n, int k) 
{
	if (n < k)
		return 0;
	long res = 1;
	for (int i = 1; i <= k; i++)
		res = (n - k + i) * res / i;

	return res;
}
