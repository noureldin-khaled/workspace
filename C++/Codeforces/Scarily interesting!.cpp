#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	pair<int, int> a[n];
	pair<int, int> b[n];

	int sum1 = 0;
	int sum2 = 0;
	for (int i = 0; i < n; i++)
	{
		int e;
		scanf("%i",&e);
		a[i] = make_pair(e, i);
		sum1 += e;
	}
	
	for (int i = 0; i < n; i++)
	{
		int e;
		scanf("%i",&e);
		b[i] = make_pair(e, i);
		sum2 += e;
	}

	sort(a, a+n);
	sort(b, b+n);

	if (sum1 >= sum2)
	{
		for (int i = 0, j = n-1; i < n; i++, j--)
			printf("%i %i\n", a[i].second+1, b[j].second+1);
	}
	else
	{
		for (int i = 0, j = n-1; i < n; i++, j--)
			printf("%i %i\n", a[j].second+1, b[i].second+1);
	}
}