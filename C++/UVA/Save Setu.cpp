#include <bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	scanf("%i", &t);

	int c = 0;
	while(t--)
	{
		string s;
		cin >> s;
		if (s.compare("donate") == 0)
		{
			int a;
			scanf("%i",&a);
			c += a;
		}
		else
			printf("%i\n", c);
	}
}
