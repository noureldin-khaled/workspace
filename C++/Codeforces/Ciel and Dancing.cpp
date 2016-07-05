#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, m;
	scanf("%i%i",&n,&m);

	vector<pair<int, int> > v;
	for (int i = 1; i <= m; i++)
		v.push_back(make_pair(1, i));
	for (int i = 2; i <= n; i++)
		v.push_back(make_pair(i, 1));

	int s = v.size();
	printf("%i\n", s);

	for (int i = 0; i < s; i++)
		printf("%i %i\n", v[i].first, v[i].second);
}
