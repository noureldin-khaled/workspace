#include <bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	scanf("%i",&t);

	while(t--)
	{
		int n;
		scanf("%i",&n);

		bool done = false;
		for (int i = n; i >= 0 && !done; i--)
		{
			int j = n-i;

			if (i%3 == 0 && j%5 == 0)
			{
				for (int k = 0; k < i; k++)
					printf("%i",5);
				for (int k = 0; k < j; k++)
					printf("%i",3);

				puts("");
				done = true;
			}
		}

		if (!done)
			printf("%i\n",-1);
	}
}
