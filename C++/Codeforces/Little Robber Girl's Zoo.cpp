#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int arr[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);


	while(true)
	{
		int i = 0;
		bool done = true;
		while(i < n-1 && done)
		{
			if (arr[i+1] < arr[i])
			{
				done = false;
				int l = i;
				int r = i+1;
				for (; i < n-1; i+=2)
				{
					if (arr[i+1] < arr[i])
					{
						r = i+1;
						int tmp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = tmp;
					}
					else
						break;
				}

				printf("%i %i\n", l+1, r+1);
			}
			else
				i++;
		}

		if (done)
			break;
	}
}
