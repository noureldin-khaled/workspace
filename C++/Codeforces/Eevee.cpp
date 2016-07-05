#include <bits/stdc++.h>

using namespace std;

string s[] = {"vaporeon", "jolteon", "flareon", "espeon", "umbreon", "leafeon", "glaceon", "sylveon"};
int n;

void go(string line);
int main()
{
	scanf("%i",&n);
	string line;
	cin >> line;

	go(line);
}

void go(string line)
{
	for (int i = 0; i < 8; i++)
	{
		string cur = s[i];
		if (cur.length() != n) continue;
		bool valid = true;
		for (int j = 0; j < n && valid; j++)
		{
			if (line[j] == '.') continue;
			if (line[j] != cur[j])
				valid = false;	
		}

		if (valid)
		{
			cout << cur << endl;
			return;
		}
	}
}
