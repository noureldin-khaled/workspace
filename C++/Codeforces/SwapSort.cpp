#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int arr[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);

	vector<pair<int, int> > res;
	for (int i = 0; i < n; i++)
	{
		int index = i;
		for (int j = i+1; j < n; j++)
		{
			if (arr[j] < arr[index])
				index = j;
		}

		if (index == i) continue;
		res.push_back(make_pair(i, index));
		int temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
	}

	int s = res.size();
	printf("%i\n", s);
	for (int i = 0; i < s; i++)
		printf("%i %i\n", res[i].first, res[i].second);

}
