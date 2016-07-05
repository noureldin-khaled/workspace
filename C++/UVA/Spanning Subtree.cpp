#include <bits/stdc++.h>

using namespace std;

int main()
{
	int t = 1;
	while(true)
	{
		int n;
		scanf("%i",&n);
		if (n == 0) break;

		int ans = 0;
		if (n > 1)
			ans = ((n*(n-1))/2)/(n-1);
		printf("Case %i: %i\n",t++,ans);
	}
}
