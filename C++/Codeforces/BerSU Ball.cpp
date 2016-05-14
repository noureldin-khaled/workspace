#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int boys[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&boys[i]);

	int m;
	scanf("%i",&m);

	int girls[m];
	for (int i = 0; i < m; i++)
		scanf("%i",&girls[i]);

	sort(boys, boys + n);
	sort(girls, girls + m);

	bool taken[m];
	memset(taken, false, sizeof taken);
	int ans = 0;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (taken[j] == false && abs(boys[i] - girls[j]) <= 1)
			{
				ans++;
				taken[j] = true;
				break;
			}
		}
	}

	printf("%i",ans);
}