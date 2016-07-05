#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, s;
	scanf("%i%i",&n,&s);

	int sum = 0;
	int maximum = 0;
	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		sum += a;
		maximum = max(maximum, a);
	}

	sum -= maximum;
	if (sum > s)
		puts("NO");
	else
		puts("YES");
}
