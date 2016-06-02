#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	string s;
	cin >> s;
	int sum1 = 0;
	int sum2 = 0;
	for (int i = 0; i < n/2; i++)
	{
		if ((s[i] != '4' && s[i] != '7') || (s[n-i-1] != '4' && s[n-i-1] != '7'))
		{
			puts("NO");
			return 0;
		}

		sum1 += (s[i] - '0');
		sum2 += (s[n-i-1] - '0');
	}

	if (sum1 == sum2)
		puts("YES");
	else
		puts("NO");

}

