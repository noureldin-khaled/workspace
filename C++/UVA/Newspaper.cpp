#include <bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	scanf("%i",&t);

	while(t--)
	{
		int m;
		scanf("%i",&m);

		map<char, int> mp;
		while(m--)
		{
			char c;
			int v;
			scanf(" %c%i",&c,&v);
			mp[c] = v;
		}

		int l;
		scanf("%i\n",&l);

		double res = 0;
		while(l--)
		{
			string line;
			getline(cin, line);

			for (int i = 0; i < line.length(); i++)
			{
				if (mp.find(line[i]) != mp.end())
					res += mp.find(line[i])->second;
			}
		}

		printf("%.2f$\n", res/100.0);
	}
}
