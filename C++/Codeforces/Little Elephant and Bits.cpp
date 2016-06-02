#include <bits/stdc++.h>

using namespace std;

int main()
{
	string s;
	cin >> s;

	int len = s.length();
	int index = -1;
	for (int i = 0; i < len; i++)
		if (s[i] == '0' && index == -1) index = i;

	index = index == -1 ? 0 : index;
	string res = "";
	for (int i = 0; i < len; i++)
	{
		if (i == index) continue;
		res += s[i];
	}

	cout << res << endl;
}

