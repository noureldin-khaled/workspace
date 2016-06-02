#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	string s;
	cin >> s;

	int first[n];
	int second[n];
	int i = 0;
	for (; i < n; i++)
		first[i] = s[i] - '0';

	for (int j = 0; j < n; j++, i++)
		second[j] = s[i] - '0';

	bool taken[n];
	memset(taken, false, sizeof taken);
	bool valid = true;
	for (int i = 0; i < n && valid; i++)
	{
		int index = -1;
		for (int j = 0; j < n; j++)
		{
			if (!taken[j] && second[j] < first[i])
			{
				if (index == -1 || second[j] > second[index])
					index = j;
			}
		}

		if (index == -1)
			valid = false;
		else
			taken[index] = true;
	}

	if (valid)
		puts("YES");
	else
	{
		valid = true;
		memset(taken, false, sizeof taken);
		for (int i = 0; i < n && valid; i++)
		{
			int index = -1;
			for (int j = 0; j < n; j++)
			{
				if (!taken[j] && second[j] > first[i])
				{
					if (index == -1 || second[j] < second[index])
						index = j;
				}
			}

			if (index == -1)
				valid = false;
			else
				taken[index] = true;
		}

		if (valid)
			puts("YES");
		else
			puts("NO");
	}
}
