#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int arr[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);

	sort(arr, arr+n);

	int com = 0;
	int ans = 0;
	for (int i = 0; i < n; i++)
	{
		if (com <= arr[i])
		{
			ans++;
			com += arr[i];
		}
	}

	printf("%i\n",ans);
}

