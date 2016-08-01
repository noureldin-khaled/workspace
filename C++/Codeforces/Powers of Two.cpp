#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

int main()
{
	fast

	vector<int> v;
	long long cur = 1;
	while(cur <= 2000000000)
	{
		v.push_back(cur);
		cur *= 2;
	}

	int s = v.size();

	int n;
	cin >> n;

	long long ans = 0;
	map<int, int> m;
	for (int i = 0; i < n; i++)
	{
		int a;
		cin >> a;

		for (int i = 0; i < s; i++)
		{
			int x = v[i] - a;
			if (x < 1) continue;

			map<int, int>::iterator it = m.find(x);
			if (it != m.end() && it->second > 0)
				ans+=it->second;
		}

		map<int, int>::iterator it = m.find(a);
		if (it != m.end())
			it->second++;
		else
			m[a] = 1;
	}

	cout << ans << endl;
}