#include <bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	scanf("%i",&t);

	int n;
	for (int c = 1; c <= t; c++)
	{
		scanf("%i",&n);

		char arr[n];
		for (int j = 0; j < n; j++)
			scanf(" %c", &arr[j]);

		int ans = 0;
		for (int i = 0; i < n;)
			if (arr[i] == '.')
			{
				ans++;
				i += 3;
			}
			else
				i++;

		printf("Case %i: %i\n", c, ans);
	}
}