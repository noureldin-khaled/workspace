#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

long long f[21];

string rec(string s, long long k, int len);
int main()
{
	fast

	f[0] = 1;
	for (int i = 1; i < 21; i++)
		f[i] = f[i-1]*i;

	int t;
	cin >> t;
	while(t--)
	{
		string s;
		long long n;

		cin >> s >> n;

		cout << rec(s, n, s.length()) << endl;
	}
}

string rec(string s, long long k, int len)
{
	if (len == 1)
		return s;

	sort(s.begin(), s.end());
	int occ[26];
	memset(occ, 0, sizeof occ);
	for (int i = 0; i < len; i++)
		occ[s[i]-'a']++;

	long long term = k;
	for (int i = 0; i < 26; i++)
		term *= f[occ[i]];

	int idx = term / f[len-1];
	char c = s[idx];

	string t = "";
	for (int i = 0; i < len; i++)
	{
		if (i != idx)
			t += s[i];
	}

	bool used[26];
	memset(used, false, sizeof used);
	long long cur = 0;
	for (int i = 0; i < len; i++)
	{
		if (s[i] == c)
			break;

		int ch = s[i] - 'a';
		if (used[ch]) continue;

		long long grp = f[len-1];
		for (int j = 0; j < 26; j++)
		{
			int l = occ[j];
			if (ch == j)
				l--;
			grp /= f[l];
		}

		cur += grp;
		used[ch] = true;
	}

	string rest = rec(t, k-cur, len-1);
	return c + rest;
}
