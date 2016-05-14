#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, k;
	scanf("%i%i",&n,&k);

	int arr[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);

	int start = 1;
	for (int i = 0; i < n; i++)
	{
		int end = start + i;
		
		if (k >= start && k <= end)
		{
			int lo = start;
			int hi = end;

			while(lo <= hi)
			{
				int mid = lo + (hi-lo)/2;
				if (mid == k)
				{
					printf("%i\n", arr[mid-start]);
					return 0;
				}
				else if (mid > k)
					hi = mid - 1;
				else
					lo = mid + 1;
			}
		}
		start = end + 1;
	}
}	
