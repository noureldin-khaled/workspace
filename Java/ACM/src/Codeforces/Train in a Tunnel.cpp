#include <bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	scanf("%i",&t);

	while(t--)
	{
		int n, l;
		scanf("%i%i",&n,&l);

		int lengths[n];
		int arr[n];

		for (int i = 0; i < n; i++)
			scanf("%i",&lengths[i]);

		for (int i = 0; i < n; i++)
			scanf("%i",&arr[i]);

		int ans = 0;
		if (arr[0] == 0)
		{
			arr[0] = 1;
			ans++;
		}
		if (arr[n-1] == 0)
		{
			arr[n-1] = 1;
			ans++;
		}


		for (int i = 0; i < n; i++)
		{
			if (arr[i] == 1) continue;

			int sum = lengths[i];
			int j = i+1;
			while(j < n)
			{
				if (sum >= l)
				{
					arr[j-1] = 1;
					ans++;
					i = j-1;
					break;
				}

				if (arr[j] == 1) 
				{
					i = j;
					break;
				}

				sum += lengths[j];
				j++;
			}
		}

		// for (int i = 0; i < n; i++)
		// 	cout << arr[i] << " ";
		// cout << endl;

		printf("%i\n",ans);
	}
}
