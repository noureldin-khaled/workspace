#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

int f(int i, int mod);
int main()
{
	fast

	int t;
	cin >> t;

	for (int tc = 1; tc <= t; tc++)
	{

		int m, n, c;
		cin >> m >> n >> c;

		int occ[n];
		memset(occ, 0, sizeof occ);
		for (int i = 0; i < m; i++)
		{
			int a;
			cin >> a;
			occ[a-1]++;
		}

		pair<int, int> b[n];
		for (int i = 0; i < n; i++)
			b[i] = make_pair(occ[i], i);

		sort(b, b+n, greater<pair<int, int> >());

		int com[n];
		memset(com, 0, sizeof com);
		if (occ[b[0].second] > 0)
			com[0] = f(b[0].second+1,c);
		for (int i = 1; i < n; i++)
		{
			com[i] = com[i-1];
			com[i] += f(b[i].second+1, c);
		}

		int ans = 0;
		for (int i = 0; i < n; i++) 
			ans = max(ans, b[i].first*com[i]);
		

		cout << "Case " << tc << ": " << ans << endl;
	}
}

int f(int i, int mod)
{
	return (i*i)%mod;
}