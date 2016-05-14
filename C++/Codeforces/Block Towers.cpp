#include <bits/stdc++.h>

using namespace std;

int n, m;

bool valid(int num);
int main()
{
	scanf("%i %i",&n, &m);

	int low = 0;
	int high = (m+n)*6;
	int ans = -1;

	while(low <= high)
	{
		int mid = low + (high - low)/2;

		if (valid(mid))
		{
			ans = mid;
			high = mid-1;
		}
		else
			low = mid+1;
	}

	printf("%i\n", ans);
}

bool valid(int num)
{	
	int remN = n - (num/2 - num/6);
	int remM = m - (num/3 - num/6);

	if (remN < 0)
		remN = 0;
	if (remM < 0)
		remM = 0;
	return (remM + remN) <= (num/6);
}

