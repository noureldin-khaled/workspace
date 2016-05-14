#include <bits/stdc++.h>

using namespace std;

int main()
{
	string num;
	cin >> num;

	if (num[0] != '1')
	{
		puts("NO");
		return 0;
	}


	for (int i = 1; i < num.length(); i++)
	{
		if (num[i] != '4' && num[i] != '1')
		{
			puts("NO");
			return 0;
		}
	}

	int limit = num.length() < 2 ? 0 : num.length()-2;
	for (int i = 1; i < limit; i++)
	{
		if (num[i] == '4' && num[i+1] == '4' && num[i+2] == '4')
		{
			puts("NO");
			return 0;
		}
	}

	puts("YES");
}

