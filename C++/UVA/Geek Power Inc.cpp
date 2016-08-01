#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

int main()
{
	fast

	int t;
	cin >> t;

	for (int tc = 1; tc <= t; tc++)
	{
		cout << "Case " << tc << ": ";

		int n;
		cin >> n;
		pair<int, int> a[n];

		for (int i = 0; i < n; i++)
		{
			int k, p;
			cin >> k >> p;

			a[i] = make_pair(p, k);
		}

		sort(a, a+n);

		long long c[n];
		c[n-1] = a[n-1].second;
		for (int i = n-2; i >= 0; i--)
			c[i] = c[i+1] + a[i].second;

		long long ans = 0;
		for (int i = 0; i < n; i++)
		{
			long long cur = c[i] * a[i].first;
			ans = max(ans, cur);
		}

		cout << ans << endl;
	}
}