#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, h;
	scanf("%i%i",&n,&h);

	int ans = 0;
	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		if (a > h)
			ans += 2;
		else
			ans++;
	}

	printf("%i\n",ans);
}
