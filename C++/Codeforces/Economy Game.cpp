#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	for (int a = 0; a < 1000; a++)
	{
		long long f = (long long)a * 1234567;
		if (f > n) continue;
		for (int b = 0; b < 10000; b++)
		{
			long long s = (long long)b * 123456;
			long long term = (long long)n - f - s;
			int c = term / 1234;
			if (c >= 0 && term%1234 == 0)
			{
				puts("YES");
				return 0;
			}
		}
	}

	puts("NO");
}
