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

		int arr[n];
		for (int i = 0; i < n; i++)
			scanf("%i",&arr[i]);

		int ans = 0;
		for (int i = 1; i < n; i++)
			for (int j = 0; j < i; j++)
				if (arr[j] <= arr[i])
					ans++;

		printf("%i\n", ans);
	}
}
