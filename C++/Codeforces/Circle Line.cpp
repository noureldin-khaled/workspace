#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int arr[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&arr[i]);
	
	int s, t;
	scanf("%i%i",&s, &t);
	s--;t--;

	int ans1 = 0;
	int i = s;
	while(true)
	{
		if (i == t)
			break;

		ans1 += arr[i];
		i = (i+1)%n;
	}

	int ans2 = 0;
	i = ((s-1)%n + n)%n;
	while(true)
	{
		ans2 += arr[i];
		if (i == t)
			break;

		i = ((i-1)%n + n)%n;
	}

	cout << min(ans1, ans2) << endl;
}
