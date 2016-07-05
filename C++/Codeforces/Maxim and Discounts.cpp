#include <bits/stdc++.h>

using namespace std;

int main()
{
	int m, n;
	scanf("%i",&m);

	int discount = 100030;
	for (int i = 0; i < m; i++)
	{
		int a;
		scanf("%i",&a);

		discount = min(discount, a);
	}

	scanf("%i",&n);

	int arr[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);

	sort(arr, arr+n, greater<int>());

	long long ans = 0;
	int i = 0;
	int count = 0;
	while(i < n)
	{
		ans += arr[i];
		count++;
		if (count == discount)
		{
			count = 0;
			i+=2;
		}

		i++;
	}

	cout << ans << endl;
}
