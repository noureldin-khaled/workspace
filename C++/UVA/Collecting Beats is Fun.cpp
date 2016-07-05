#include <bits/stdc++.h>

using namespace std;

int main()
{
	int k;
	scanf("%i",&k);

	int occ[10];
	memset(occ, 0, sizeof occ);
	for (int i = 0; i < 4; i++)
	{
		string s;
		cin >> s;
		for (int j = 0; j < 4; j++)
		{
			if (s[j] >= '0' && s[j] <= '9')
				occ[s[j]-'0']++;
		}
	}

	for (int i = 0; i < 10; i++)
		if (occ[i] > (k << 1))
		{
			puts("NO");
			return 0;
		}

	puts("YES");
}
