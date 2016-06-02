#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	for (int i = 1; i <= n; i++)
	{
		for (int j = 0; j < n-i; j++)
			printf(" ");
		for (int j = 0; j < i; j++)
			printf("#");
		puts("");
	}
}
