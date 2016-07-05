#include <bits/stdc++.h>

using namespace std;

int main()
{
	int t = 1;
	int n;
	while(true)
	{
		scanf("%i",&n);

		if (n == 0) break;
		int arr[n];
		for (int i = 0; i < n; i++)
			scanf("%i",&arr[i]);

		int m;
		scanf("%i",&m);
		printf("Case %i:\n", t++);
		while(m--)
		{
			int a;
			scanf("%i",&a);

			int ans = -1;
			for (int i = 0; i < n; i++)
				for (int j = i+1; j < n; j++)
					if (ans == -1 || abs(arr[i]+arr[j] - a) < abs(ans-a))
						ans = arr[i]+arr[j];

			printf("Closest sum to %i is %i.\n", a, ans);
		}
	}
}
