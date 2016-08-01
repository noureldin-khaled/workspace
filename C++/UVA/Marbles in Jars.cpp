#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);
#define MOD 1000000007

using namespace std;

int main()
{
	fast

	int t;
	cin >> t;
	for (int tc = 1; tc <= t; tc++)
	{
		int n;
		cin >> n;

		int a[n];
		for (int i = 0; i < n; i++)
			cin >> a[i];

		sort(a, a+n);

		int cur = 0;
		long long ways = 1;
		for (int i = 0; i < n; i++)
		{
			long long c = max(0, a[i]-cur);
			ways = (ways%MOD * c%MOD)%MOD;
			cur++;
		}

		cout << "Case " << tc << ": " << ways%MOD << endl;
	}
}