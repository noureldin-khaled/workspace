#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int maximum = 0;
	int maxIndex = -1;
	int minimum = 105;
	int minIndex = -1;
	for (int i = 0; i < n; i++) 
	{
		int a;
		scanf("%i",&a);

		if (a > maximum)
		{
			maximum = a;
			maxIndex = i;
		}

		if (a < minimum)
		{
			minimum = a;
			minIndex = i;
		}
	}
	int ans1 = max(n-1 - maxIndex, maxIndex);
	int ans2 = max(n-1 - minIndex, minIndex);

	cout << max(ans1, ans2) << endl;
}
