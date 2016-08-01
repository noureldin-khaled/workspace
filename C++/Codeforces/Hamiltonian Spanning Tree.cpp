#include <bits/stdc++.h>

using namespace std;

long long n, x, y;
vector<int> adjlist[200005];
long long edges;

long long rec(int u, int p);
bool isStar();
int main()
{
	cin >> n >> x >> y;

	for (int i = 0; i < n-1; i++)
	{
		int u, v;
		scanf("%i%i",&u,&v);
		u--;v--;

		adjlist[u].push_back(v);
		adjlist[v].push_back(u);
	}

	if (y < x)
	{
		long long ans = (n-2)*y;
		if (isStar())
			ans += x;
		else
			ans += y;

		cout << ans << endl;
	}
	else
	{
		edges = 0;
		rec(0, -1);

		cout << edges*x + ((n-1)-edges)*y << endl;
	}
}

long long rec(int u, int p)
{
	long long a = 0;
	for (int i = 0; i < adjlist[u].size(); i++)
	{
		int v = adjlist[u][i];
		if (v != p)
			a += rec(v, u);
	}

	if (a == 0)
		return 1;
	if (a == 1)
	{
		edges++;
		return 1;
	}
	edges+=2;
	return 0;
}

bool isStar()
{
	for (int i = 0; i < n; i++)
		if (adjlist[i].size() == n-1)
			return true;
	return false;
}