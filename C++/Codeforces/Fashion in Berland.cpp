#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);
	int s = 0;

	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);
		s += a;
	}

	if (n == 1)
	{
		if (s == n)
			puts("YES");
		else
			puts("NO");
	}
	else
	{
		if (s == n-1)
			puts("YES");
		else
			puts("NO");
	}
}

