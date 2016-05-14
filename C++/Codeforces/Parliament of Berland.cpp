#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, a, b;
	scanf("%i%i%i",&n,&a,&b);

	if (n > a*b)
	{
		printf("%i",-1);
		return 0;
	}

	int ans[a][b];
	memset(ans, 0, sizeof ans);

	int c = 1;
	for (int i = 0; i < a; i++)
	{
		if (b%2 != 0 || i%2 == 0)
		{
			for (int j = 0; j < b; j++)
				if (c > n)
					ans[i][j] = 0;
				else
					ans[i][j] = c++;
		}
		else
		{
			for (int j = b-1; j >= 0; j--)
				if (c > n)
					ans[i][j] = 0;
				else
					ans[i][j] = c++;
		}
	}

	for (int i = 0; i < a; i++)
	{
		for (int j = 0; j < b; j++)
			printf("%i ", ans[i][j]);
		puts("");
	}

}
