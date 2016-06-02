#include <bits/stdc++.h>

using namespace std;

int main()
{
	string s;
	cin >> s;

	if (s[0] == '0')
	{
		printf("%i\n", 4);
		return 0;
	}

	int len = s.length();
	int num = s[len-1] - '0';
	if (len > 1)
		num = (s[len-2]-'0')*10 + num;

	num%=20;
	if (num == 0)
		num = 20;

	if (num == 1 || num == 5 || num == 9 || num == 13 || num == 17)
	{
		printf("%i\n", (2+3+4+1)%5);
		return 0;
	}

	if (num == 2 || num == 6 || num == 10 || num == 14 || num == 18)
	{
		printf("%i\n", (4+9+6+1)%5);
		return 0;
	}

	if (num == 3 || num == 7 || num == 11 || num == 15 || num == 19)
	{
		printf("%i\n", (8+7+4+1)%5);
		return 0;
	}

	if (num == 4 || num == 8 || num == 12 || num == 16 || num == 20)
	{
		printf("%i\n", (6+1+6+1)%5);
		return 0;
	}



}

