#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	map<int, int> m;
	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		map<int, int>::iterator it = m.find(a);
		
		if (it == m.end())
			m[a] = 1;
		else
			it->second++;
	}

	int me;
	scanf("%i",&me);

	int audio[me];
	int subtitle[me];
	for (int i = 0; i < me; i++)
		scanf("%i",&audio[i]);

	for (int i = 0; i < me; i++)
		scanf("%i",&subtitle[i]);

	int max1 = 0;
	int max2 = 0;
	int ans = -1;

	for (int i = 0; i < me; i++)
	{
		map<int, int>::iterator it = m.find(audio[i]);
		map<int, int>::iterator it2 = m.find(subtitle[i]);

		if (it != m.end())
		{
			if (it->second > max1)
			{
				max1 = it->second;
				max2 = it2 != m.end() ? it2->second : 0;
				ans = i;
			}
			else if (it->second == max1)
			{
				if (it2 != m.end())
				{
					if (it2->second > max2)
					{
						max1 = it->second;
						max2 = it2->second;
						ans = i;
					}
				}
			}
		}
		else if (max1 == 0)
		{
			if (it2 != m.end())
			{
				if (it2->second > max2)
				{
					max2 = it2 != m.end() ? it2->second : 0;
					ans = i;
				}
			}
			else if (ans = -1)
				ans = i;
		}

	}

	cout << ans+1 << endl;
}	
