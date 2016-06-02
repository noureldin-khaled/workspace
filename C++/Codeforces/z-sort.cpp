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

	for (int i = 2; i < n; i++)
	{
		if ((i+1)%2 != 0)
		{
			int temp = arr[i];
			arr[i] = arr[i-1];
			arr[i-1] = temp;
		}
	}

	for (int i = 0; i < n; i++)
		printf("%i ",arr[i]);	
}
