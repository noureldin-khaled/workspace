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
	long long sum = 0;

	for (int i = n-3; i >= 0; i--)
		sum += arr[i];

	cout << arr[n-1]+1-sum-arr[n-2] << endl;
}	
