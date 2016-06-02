#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, x;
	scanf("%i%i",&n,&x);

	int arr[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);

	sort(arr, arr+n);

	long long ans = 0;
	for (int i = 0; i < n; i++)
	{
		ans += (long long)arr[i]*x;
		x = max(1, x-1);
	}

	cout << ans << endl;
}