#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, k;
	scanf("%i%i",&n,&k);

	int arr[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);

	int comm[n];
	comm[0] = arr[0];
	for (int i = 1; i < n; i++)
		comm[i] = arr[i] + comm[i-1];

	int sum = 200000000;
	int ans = -1;
	for (int i = 0; i <= n-k; i++)
	{
		int temp = comm[i+k-1] - comm[i] + arr[i];
		if (temp < sum)
		{
			sum = temp;
			ans = i;
		}
	}

	printf("%i\n",ans+1);
}


