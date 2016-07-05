#include <bits/stdc++.h>

using namespace std;

int main()
{
	long long n, m;
	cin >> n >> m;
	long long ans = n * (m/5) + (m%5)*(n/5);
	vector<int> a1;
	while(n%5 != 0 && n > 0)
	{
		a1.push_back(n);
		n--;
	}

	vector<int> a2;
	while(m%5 != 0 && m > 0)
	{
		a2.push_back(m);
		m--;
	}

	for (int i = 0; i < a1.size(); i++)
		for (int j = 0; j < a2.size(); j++)
			if ((a1[i]+a2[j])%5 == 0)
				ans++;
	cout << ans << endl;
}
