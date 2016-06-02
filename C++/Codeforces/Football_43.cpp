#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	string name1 = "";
	string name2 = "";
	int one = 0;
	int two = 0;

	while(n--)
	{
		string s;
		cin >> s;

		if (name1.compare(s) == 0)
			one++;
		else if (name1.compare("") == 0)
		{
			name1 = s;
			one++;
		}
		else if (name2.compare(s) == 0)
			two++;
		else if (name2.compare("") == 0)
		{
			name2 = s;
			two++;
		}
	}

	if (one > two)
		cout << name1 << endl;
	else
		cout << name2 << endl;
}

