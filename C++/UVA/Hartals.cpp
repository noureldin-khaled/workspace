#include <bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	scanf("%i",&t);


	while(t--)
	{
		int n, p;
		scanf("%i\n%i",&n,&p);

		int arr[p];
		for (int i = 0; i < p; i++)
			scanf("%i",&arr[i]);

		int ans = 0;
		for (int i = 1, j = 1; i <= n; i++)
		{
			if (j != 6 && j != 7)
			{
				bool has = false;
				for (int k = 0; k < p && !has; k++)
				{
					if (i%arr[k] == 0)
						has = true;
				}

				if (has)
					ans++;
			}

			j++;
			if (j == 8)
				j = 1;
		}

		printf("%i\n",ans);
	}
	
}
