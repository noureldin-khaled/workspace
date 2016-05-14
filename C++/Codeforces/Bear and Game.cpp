#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int prev = 0;
	int ans = 0;
	for (int i = 0; i < n; i++)
	{
		int t;
		scanf("%i",&t);

		if (t - prev > 15)
		{
			cout << ans + 15 << endl;
			return 0;
		}

		ans = prev = t;
	}

	cout << min(90, ans+15) << endl;
}

