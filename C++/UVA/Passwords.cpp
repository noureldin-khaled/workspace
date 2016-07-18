#include <bits/stdc++.h>
#define toString( x ) dynamic_cast< std::ostringstream & >( \
( std::ostringstream() << std::dec << x ) ).str()

using namespace std;

int n, m;
string dictionary[101];
string ans[256];

void rec(int ruleIndex, int idx, string rule, int len);
int main()
{
	while(scanf("%i",&n) != EOF)
	{
		puts("--");
		for (int i = 0; i < n; i++)
		{
			string s;
			cin >> s;
			dictionary[i] = s;
		}

		scanf("%i",&m);
		for (int i = 0; i < m; i++)
		{
			string s;
			cin >> s;
			rec(0, 0, s, s.length());
		}
	}
}

void rec(int ruleIndex, int idx, string rule, int len)
{
	if (ruleIndex == len)
	{
		for (int i = 0; i < len; i++)
			cout << ans[i];
		cout << endl;
		return;
	}

	if (rule[ruleIndex] == '#')
	{
		for (int i = 0; i < n; i++)
		{
			ans[idx] = dictionary[i];
			rec(ruleIndex+1, idx+1, rule, len);
		}
	}
	else
	{
		for (int i = 0; i <= 9; i++)
		{
			ans[idx] = toString(i);
			rec(ruleIndex+1, idx+1, rule, len);
		}
	}
}
