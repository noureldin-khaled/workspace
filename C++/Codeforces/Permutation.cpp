#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, k;
	scanf("%i%i",&n,&k);

	int arr[2*n];
	for (int i = 1; i <= 2*n; i++)
		arr[i-1] = i;

	int total = 0;
	for (int i = 0; i < n; i+=2)
	{
		if (total == 2*k) break;
		int temp = arr[i];
		arr[i] = arr[i+1];
		arr[i+1] = temp;

		total += 2;
	}

	for (int i = 0; i < 2*n; i++)
		printf("%i ", arr[i]);
}
