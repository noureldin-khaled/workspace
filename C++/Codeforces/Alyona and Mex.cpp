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

	for (int i = 0; i < n; i++)
	{
		if (i == 0)
			arr[i] = 1;
		else if (arr[i] - arr[i-1] > 1)
			arr[i] = arr[i-1]+1;
	}
	
	printf("%i\n", arr[n-1]+1);
}
