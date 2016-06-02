#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, m;
	scanf("%i%i",&n,&m);

	int ans = 1;
	int count = 0;
	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		if (count + a <= m)
			count += a;
		else
		{
			count = a;
			ans++;
		}
	}
	
	printf("%i",ans);
}

