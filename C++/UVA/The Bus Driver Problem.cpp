#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, d, r;
	while(true)
	{
		scanf("%i%i%i",&n,&d,&r);
		if (n == 0 && d == 0 && r == 0) break;

		int arr1[n];
		int arr2[n];

		for (int i = 0; i < n; i++)
			scanf("%i",&arr1[i]);
		for (int i = 0; i < n; i++)
			scanf("%i",&arr2[i]);

		sort(arr1, arr1+n);
		sort(arr2, arr2+n);

		int h = 0;
		for (int i = 0; i < n; i++)
			h += max(0, (arr1[i]+arr2[n-1-i]) - d);
		printf("%i\n", h*r);
	}
}