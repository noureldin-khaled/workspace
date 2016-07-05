#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, a;
	scanf("%i%i",&n,&a);

	int arr[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);

	a--;
	int d = 0;
	int ans = 0;
	while(true)
	{
		int left = a - d;
		int right = a + d;
		if (left < 0 && right >= n) break;

		if (left < 0)
			ans += arr[right];
		else if (right >= n)
			ans += arr[left];
		else
		{
			if (arr[left] == arr[right])
				if (left != right)
					ans += 2*arr[left];
				else
					ans += arr[left];
		}
		d++;
	}

	printf("%i\n",ans);
}
