#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, k;
	scanf("%i%i",&n,&k);

	int need[n];
	int has[n];

	for (int i = 0; i < n; i++)
		scanf("%i",&need[i]);
	
	for (int i = 0; i < n; i++)
		scanf("%i",&has[i]);

	int low = 0;
	int high = 2147483647;
	int ans = -1;

	while(low <= high)
	{
		int mid = low + (high-low)/2;

		int soFar = k;
		bool valid = true;
		for (int i = 0; i < n && valid; i++)
		{
			if (has[i]/need[i] >= mid) continue;

			long long x = ((long long)mid*need[i]) - has[i];
			if (x > soFar)
				valid = false;
			else
				soFar -= x;
		}

		if (valid)
		{
			ans = mid;
			low = mid + 1;
		}
		else
			high = mid - 1;
	}

	cout << ans << endl;

}

