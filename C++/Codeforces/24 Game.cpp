#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

int main()
{
	fast

	int n;
	cin >> n;

	if (n <= 3)
		puts("NO");
	else
	{
		puts("YES");
		if (n%2 == 0)
			printf("4 * 3 = 12\n12 * 2 = 24\n24 * 1 = 24\n");
		else
			printf("5 - 3 = 2\n1 + 2 = 3\n4 * 3 = 12\n12 * 2 = 24\n");

		while(n > 5)
		{
			printf("%i - %i = 1\n24 * 1 = 24\n", n, n-1);
			n -= 2;
		}
	}
}