#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int ans = 0;
	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		ans = max(ans, a);
	}

	printf("%i\n", ans);
}
