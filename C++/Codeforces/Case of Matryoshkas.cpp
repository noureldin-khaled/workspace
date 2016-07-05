#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, k;
	scanf("%i%i",&n,&k);

	vector<int> arr[k];
	for (int i = 0; i < k; i++)
		arr[i].clear();

	for (int i = 0; i < k; i++)
	{
		int m;
		scanf("%i",&m);

		for (int j = 0; j < m; j++)
		{
			int a;
			scanf("%i",&a);

			arr[i].push_back(a);
		}
	}

	int splits = 0;
	int groups = 0;
	for (int i = 0; i < k; i++)
	{
		int s = arr[i][0];
		int e = 1;
		for (int j = 0; j < arr[i].size()-1; j++)
		{
			if (arr[i][j+1] - arr[i][j] > 1)
			{
				splits++;
				if (s > 1)
				{
					splits += (e-1);
					groups += e;
				}
				else
					groups++;
				s = arr[i][j+1];
				e = 1;
			}
			else
				e++;
		}
		if (s > 1)
		{
			splits += (e-1);
			groups += e;
		}
		else
			groups++;
	}


	printf("%i\n", splits + groups - 1);
}
