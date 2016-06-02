#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int sum = 0;
	int arr[n];
	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		sum += a;
		arr[i] = a;
	}

	int ans = 0;
	for (int i = 0; i < n; i++)
	{
		int rem = sum - arr[i];
		if (rem%2 == 0)
			ans++;
	}

	printf("%i\n",ans);
}
