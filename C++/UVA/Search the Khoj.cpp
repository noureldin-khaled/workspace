#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

int diff(string a, string b);
int main()
{
	fast

	int t;
	cin >> t;
	for (int c = 1; c <= t; c++)
	{
		cout << "Case " << c << ":" << endl;

		int n;
		cin >> n;
		string a[n];
		for (int i = 0; i < n; i++)
		{
			string s;
			cin >> s;
			a[i] = s;
		}

		string o;
		cin >> o;

		vector<string> v;
		for (int i = 0; i < n; i++)
		{
			if (diff(a[i], o) <= 1)
				v.push_back(a[i]);
		}

		for (int i = 0; i < v.size(); i++)
			cout << v[i] << endl;
	}
}

int diff(string a, string b)
{
	int res = 0;
	for (int i = 0; i < a.length(); i++)
		if (a[i] != b[i])
			res++;
	return res;
}