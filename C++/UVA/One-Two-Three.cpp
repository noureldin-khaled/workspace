#include <bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	scanf("%i",&t);

	while(t--)
	{
		string s;
		cin >> s;
		if (s.length() == 5)
			printf("%i\n", 3);
		else
		{
			if ((s[0] == 'o' && s[1] == 'n') || (s[0] == 'o' && s[2] == 'e') || (s[1] == 'n' && s[2] == 'e'))
				printf("%i\n", 1);
			else
				printf("%i\n", 2);
		}
	}
}
