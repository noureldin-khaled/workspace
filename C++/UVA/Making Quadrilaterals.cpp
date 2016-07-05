#include <bits/stdc++.h>

using namespace std;

int main()
{
	int t= 1;
	while(true)
	{
		int n;
		scanf("%i",&n);

		if (n == 0) break;

		long long arr[3];
		arr[0] = arr[1] = arr[2] = 1;
		n -= 3;

		int i = 0;
		while(n--)
		{
			long long newR = arr[0] + arr[1] + arr[2];
			arr[i] = newR;
			i = (i+1)%3;
		}

		printf("Case %i: ", t++);
		cout << max(arr[0], max(arr[1], arr[2])) << endl;
	}
}
