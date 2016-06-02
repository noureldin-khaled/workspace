#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	vector<int> v;
	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		if (a == 1)
			v.push_back(i);
	}
	int s = v.size() == 0 ? 0 : v.size();

	int ans = s == 0 ? 0 : 1;
	for (int i = 0; i < s-1; i++)
		ans += min(2, v[i+1]-v[i]);

	cout << ans << endl;
}