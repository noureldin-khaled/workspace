#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int arr[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);

	int m;
	scanf("%i",&m);
	while(m--)
	{
		int x, y;
		scanf("%i%i",&x,&y);
		x--;
		if (x > 0)
			arr[x-1] += y-1;
		if (x < n-1)
			arr[x+1] += arr[x]-y;
		arr[x] = 0;
	}

	for (int i = 0; i < n; i++)
		printf("%i\n", arr[i]);
}
