#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, a, b, c, d;
	scanf("%i%i%i%i%i",&n,&a,&b,&c,&d);

	long long ans = 0; 
	for (int x = 1; x <= n; x++)
	{
		int y = x-c+b;
		int g = x-d+a;
		int m = x-c-d+a+b;

		if (y <= n && y > 0 && g <= n && g > 0 && m <= n && m > 0)
			ans++;
	}

	cout << ans*n << endl;
}