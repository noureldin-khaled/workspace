#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, k;
	scanf("%i%i",&n,&k);
	string s;
	cin >> s;

	long long occ[26];
	memset(occ, 0, sizeof occ);
	for (int i = 0; i < n; i++)
		occ[s[i] - 'A']++;

	long long ans = 0;
	sort(occ, occ+26, greater<int>());

	for (int i = 0; i < 26; i++)
	{
		if (k > occ[i])
		{
			ans += occ[i] * occ[i];
			k -= occ[i];
		}
		else
		{
			ans += (long long)k*k;
			break;
		}
	}

	cout << ans << endl;
}
