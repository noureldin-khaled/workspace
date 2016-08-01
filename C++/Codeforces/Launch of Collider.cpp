#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	string s;
	cin >> s;

	int a[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&a[i]);

	int ans = -1;
	for (int i = 0; i < n-1; i++)
	{
		if (s[i] == 'R' && s[i+1] == 'L')
		{
			int moment = (a[i]+a[i+1])/2;
			if (ans == -1 || abs(moment-a[i]) < ans)
				ans = abs(moment-a[i]);
		}
	}

	printf("%i\n", ans);
}

