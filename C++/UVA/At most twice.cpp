#include <bits/stdc++.h>
#define charToInt(x) x - '0'
#define intToChar(x) x + '0'
#define parseLong(x) atol(x.c_str())
#define toString( x ) dynamic_cast< std::ostringstream & >( \
( std::ostringstream() << std::dec << x ) ).str()

using namespace std;

int occ[10];

bool valid(string s);
int main()
{
	string s;
	while(cin >> s)
	{
		int n = s.length();

		memset(occ, 0, sizeof occ);
		int changeTo[n];
		memset(changeTo, -1, sizeof changeTo);
		for (int i = 0; i < n; i++)
		{
			int digit = charToInt(s[i]);
			int j = 0;
			if (i == 0)
				j++;
			for (; j < digit; j++)
			{
				if (occ[j] < 2)
					changeTo[i] = j;
			}

			occ[digit]++;
		}

		long long ans = -1;
		if (valid(s))
			ans = parseLong(s);

		string p = "99887766554433221100";
		for (int i = 0; i < n; i++)
		{
			int digit = charToInt(s[i]);
			if (changeTo[i] == -1) continue;

			string tmp = s;
			tmp[i] = intToChar(changeTo[i]);

			memset(occ, 0, sizeof occ);
			for (int j = 0; j <= i; j++)
				occ[charToInt(tmp[j])]++;

			for (int k = i+1; k < n; k++)
			{
				for (int j = 0; j < 20; j++)
				{
					int d = charToInt(p[j]);
					if (occ[d] < 2)
					{
						tmp[k] = p[j];
						occ[d]++;
						break;
					}
				}
			}

			if (valid(tmp))
			{
				long long cur = parseLong(tmp);
				ans = max(ans, cur);
			}
		}

		if (ans == -1)
		{
			string res = "";
			for (int i = 0; i < n-1; i++)
				res += p[i];
			ans = parseLong(res);
		}

		cout << ans << endl;
	}
}

bool valid(string s)
{
	for (int i = 0; i < 10; i++)
		if (occ[i] > 2)
			return false;
	return true;
}