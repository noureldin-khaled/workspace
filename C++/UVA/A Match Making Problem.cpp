#include <bits/stdc++.h>

using namespace std;

int main()
{
	int t = 1;
	int b, s;
	while(true)
	{
		scanf("%i%i",&b,&s);
		if (b == 0 && s == 0) break;

		int low = 80;
		for (int i = 0; i < b; i++)
		{
			int a;
			scanf("%i",&a);

			low = min(low, a);
		}

		for (int i = 0; i < s; i++)
		{
			int a;
			scanf("%i",&a);
		}

		printf("Case %i: %i", t++, max(0, b-s));
		if (b > s)
			printf(" %i", low);
		puts("");
	}
}