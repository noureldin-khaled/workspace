#include <bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	scanf("%i",&t);

	while(t--)
	{
		int n;
		scanf("%i",&n);

		int arr[n];
		for (int i = 0; i < n; i++)
			scanf("%i",&arr[i]);

		int ii = 0;

		for (int i = 0; i < n; i++)
		{
			for (int j = i+1; j < n; j++)
				if (arr[i] > arr[j])
					ii++;
		}

		if (ii%2 == 0)
			puts("YES");
		else
			puts("NO");
	}	
}
