#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

int MOD(int a, int m);
int main()
{
	int n, k;
	scanf("%i%i",&n,&k);

	int c[n];
	long long sum = 0;
	for (int i = 0; i < n; i++)
	{
		scanf("%i",&c[i]);
		sum += c[i];
	}

	long long ans = 0;
	for (int i = 0; i < n; i++)
		ans += (long long)c[i]*c[(i+1)%n];

	long long acc = 0;
	bool found[n];
	memset(found, 0, sizeof found);
	for (int i = 0; i < k; i++)
	{
		int id;
		scanf("%i",&id);
		id--;

		long long tmp = sum - ((long long)c[MOD(id-1, n)] + c[MOD(id+1, n)] + c[id] + acc);
		if (found[MOD(id-1, n)])
			tmp += c[MOD(id-1, n)];
		if (found[MOD(id+1, n)])
			tmp += c[MOD(id+1, n)];
		if (tmp < 0)
			tmp = 0;

		ans += tmp*c[id];
		acc += c[id];
		found[id] = true;
	}

	cout << ans << endl;
}

int MOD(int a, int m)
{
	return (a%m + m)%m;
}