#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	while(true)
	{
		scanf("%i",&n);
		if (n == 0) break;

		int a[n];
		for (int i = 0; i < n; i++)
			scanf("%i",&a[i]);

		long long res = 0;
		long long acc = a[0];

		for (int i = 1; i < n; i++)
		{
			res += abs(acc);
			acc += a[i];
		}

		cout << res << endl;
	}
}
