#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	if (n <= 2)
		printf("%i\n", -1);
	else
	{
		for (int i = n; i >= 1; i--)
			printf("%i ", i);
	}
}
