#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;
typedef long long ll;

int n;
ll count(int cur);
int a[100001];
int main()
{
	ll k;
	scanf("%i",&n);
	cin >> k;

	for (int i = 0; i < n; i++)
		scanf("%i",&a[i]);

	sort(a, a+n);

	int low = 0;
	int high = 2000000001;
	int ans = -1;

	while(low <= high)
	{
		int mid = low + (high-low)/2;

		if (count(mid) >= k)
		{
			ans = mid;
			high = mid-1;
		}
		else
			low = mid+1;
	}

	printf("%d\n", ans);
}

ll count(int cur)
{
	ll res = 0;
	for (int i = 0; i < n; i++)
	{
		int low = 0;
		int high = i-1;
		int ans = -1;

		while(low <= high)
		{
			int mid = low + (high-low)/2;

			if (a[mid] + a[i] <= cur)
			{
				ans = mid;
				low = mid+1;
			}
			else
				high = mid-1;
		}

		if (ans != -1)
			res += (ans+1);
	}

	return res;
}