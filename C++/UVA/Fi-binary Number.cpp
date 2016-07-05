#include <bits/stdc++.h>

using namespace std;

int main()
{
	long long f[50];
	f[0] = 0;
	f[1] = 1;

	for (int i = 2; i < 50; i++)
		f[i] = f[i-1] + f[i-2];

	int t;
	scanf("%i",&t);

	while(t--)
	{
		int n;
		scanf("%i",&n);
		set<int> s;
		for (int i = 49; i >= 1; i--)
		{
			if (f[i] <= n)
			{
				s.insert(i);
				n -= f[i];
			}
		}

		// for (set<int>::iterator it = s.begin(); it != s.end(); ++it)
		// 	cout << *it << endl;

		int len = s.size();
		int i = 2;
		string res = "";
		while(true)
		{
			if (len == 0)
				break;

			set<int>::iterator it = s.find(i);
			if (it != s.end())
			{
				res = "1" + res;
				s.erase(it);
				len--;
			}
			else
				res = "0" + res;
			i++;
		}

		cout << res << endl;
	}
}
