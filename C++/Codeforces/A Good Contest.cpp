#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	for (int i = 0; i < n; i++)
	{
		string name;
		int b, a;
		cin >> name;
		scanf("%i%i",&b,&a);

		if (b >= 2400 && a-b > 0)
		{
			puts("YES");
			return 0;
		}
	}

	puts("NO");
}
