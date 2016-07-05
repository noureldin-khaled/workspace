#include <bits/stdc++.h>

using namespace std;

int main()
{
	string s, t;
	cin >> s >> t;

	int len = s.length();
	for (int i = len-1; i >= 0; i--)
	{
		if (s[i] != 'z')
		{
			s[i]++;
			if (s.compare(t) < 0)
				cout << s << endl;
			else
				puts("No such string");
			return 0;
		}

		s[i] = 'a';
	}

	puts("No such string");
}
