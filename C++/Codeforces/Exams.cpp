#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	pair<int, int> arr[n];

	for (int i = 0; i < n; i++)
	{
		int a, b;
		scanf("%i%i",&a,&b);

		arr[i] = make_pair(a, b);
	}

	sort(arr, arr + n);

	int prev = arr[0].second;
	int i = 1;
	bool flag = true;
	while(i < n)
	{
		if (flag)
		{
			if (arr[i].second >= prev)
				prev = arr[i].second;
			else
			{
				prev = arr[i].first;
				flag = false;
			}
		}
		else
		{
			if (arr[i].second >= prev)
			{
				prev = arr[i].second;
				flag = true;
			}
			else
				prev = arr[i].first;
		}

		i++;
	}

	printf("%i\n",prev);

}
