#include <bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	scanf("%i",&t);

	for (int c = 1; c <= t; c++)
	{
		string s;
		cin >> s;

		int occ[26];
		memset(occ, 0, sizeof occ);
		for (int i = 0; i < s.length(); i++)
			occ[s[i]- 'a']++;

		int ans = 100001;
		for (int i = 0; i < 26; i++)
			ans = min(ans, occ[i]);

		printf("Case %i: %i\n", c, ans);
	}
}