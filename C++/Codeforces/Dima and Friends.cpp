#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int sum = 0;
	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);
		sum += a;
	}

	int ans = 0;
	for (int i = 1; i <= 5; i++)
		if ((sum+i)%(n+1) != 1)
			ans++;

	printf("%i\n", ans);
}
