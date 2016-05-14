#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, m;
	scanf("%i%i",&n, &m);

	long long ans = 0;
	for (int a = 0; a <= 1000; a++)
	{
		int b = n - (a * a);

		if (b < 0) continue;

		if (a + (b * b) == m)
			ans++;
	}

	cout << ans << endl;
}