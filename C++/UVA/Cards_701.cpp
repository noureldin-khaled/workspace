#include <bits/stdc++.h>
#define toString( x ) dynamic_cast< std::ostringstream & >( \
( std::ostringstream() << std::dec << x ) ).str()

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int a[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&a[i]);

	for (int k = 1; k <= 200; k++)
	{
		bool taken[n];
		memset(taken, false, sizeof taken);
		string ans = "";
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (i == j) continue;
				if (a[i] + a[j] == k && !taken[i] && !taken[j])
				{
					ans += toString(i+1);
					ans += " ";
					ans += toString(j+1);
					ans += "\n"; 
					taken[i] = taken[j] = true;
				}
			}
		}

		bool valid = true;
		for (int i = 0; i < n && valid; i++)
			if (!taken[i])
				valid = false;

		if (valid)
		{
			cout << ans;
			return 0;
		}
	}
}