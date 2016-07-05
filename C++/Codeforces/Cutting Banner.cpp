#include <bits/stdc++.h>

using namespace std;

int main()
{
	string s;
	cin >> s;
	int n = s.length();

	char c[10] = {'C', 'O', 'D', 'E', 'F', 'O', 'R', 'C', 'E', 'S'};

	int index = 0;
	for (int i = 0; i < n; i++)
	{
		if (s[i] == c[index])
		{
			index++;
			if (index == 10)
			{
				puts("YES");
				return 0;
			}
		}
		else
			break;
	}

	for (int i = n-(10-index); i < n; i++)
	{
		if (s[i] == c[index])
		{
			index++;
			if (index == 10)
			{
				puts("YES");
				return 0;
			}
		}
		else
			break;
	}

	puts("NO");
}
