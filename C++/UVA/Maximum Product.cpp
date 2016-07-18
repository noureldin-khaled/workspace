#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	int t = 1;
	while(scanf("%i",&n) != EOF)
	{
		int arr[n];
		for (int i = 0; i < n; i++)
			scanf("%i",&arr[i]);

		long long ans = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = i; j < n; j++)
			{
				long long cur = 1;
				for (int k = i; k <= j; k++)
					cur *= arr[k];
				ans = max(ans, cur);
			}
		}

		printf("Case #%i: The maximum product is ", t++);
		cout << ans << ".\n" << endl;
	}
}
