#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int sum = 0;
	pair<int, int> arr[3];
	for (int i = 0; i < 3; i++)
	{
		int min, max;
		scanf("%i%i",&min, &max);

		arr[i] = make_pair(min, max);
		sum += min;
	}


	if (sum < n)
	{
		int diff = n - sum;
		int i = 0;
		while(diff > 0)
		{
			if (arr[i].first + diff >= arr[i].second)
			{
				diff -= (arr[i].second - arr[i].first);
				arr[i].first = arr[i].second;
			}
			else
			{
				arr[i].first += diff;
				diff = 0;
			}
			i++;
		}
	}

	printf("%i %i %i\n", arr[0].first, arr[1].first, arr[2].first);
}
