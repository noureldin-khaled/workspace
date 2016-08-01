#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

int main()
{
	fast

	int n;
	cin >> n;

	int ans = 0;
	int prev = 0;
	int cur = 0;
	for (int i = 0; i < n; i++)
	{
		int a;
		cin >> a;
		if (a > prev)
			cur++;
		else
			cur = 1;
		prev = a;
		ans = max(ans, cur);
	}

	cout << ans << endl;
}