#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, k;
	scanf("%i%i",&n,&k);
	
	long long low = 1;
	long long high = 2147483647;
	long long ans = -1;
	while(low <= high)
	{
		long long mid = low + (high-low)/2;
		if (mid*k > n)
		{
			ans = mid*k;
			high = mid-1;
		}
		else
			low = mid+1;
	}

	cout << ans << endl;
}
