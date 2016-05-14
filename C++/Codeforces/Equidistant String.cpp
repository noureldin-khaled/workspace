#include <bits/stdc++.h>

using namespace std;

int main()
{
	string s, t;
	cin >> s >> t;

	string res = "";
	int count = 0;
	int c = 0;

	for (int i = 0; i < s.length(); i++)
	{
		if (s[i] == t[i])
			res += s[i];	
		else
		{
			if (c == 0)
				res += s[i];
			else
				res += t[i];

			c = 1-c;
			count++;
		}
	}

	if (count%2 == 0)
		cout << res << endl;
	else
		cout << "impossible" << endl;
}
