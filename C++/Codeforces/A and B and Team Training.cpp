#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, m;
	scanf("%i%i",&n,&m);

	long long ans = 0;

	while(n > 0 && m > 0)
	{
		if (n == 1 && m == 1)
			break;
		if (n > m)
		{
			n -= 2;
			m--;
			ans++;
		}
		else
		{
			n--;
			m -= 2;
			ans++;
		}
	}

	cout << ans << endl;
}