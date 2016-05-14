#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int fives = 0;
	int zeros = 0;

	for (int i = 0; i < n; i++)
	{
		int a;
		scanf("%i",&a);

		if (a == 5) fives++;
		else zeros++;
	}

	if (zeros == 0)
	{
		printf("%i",-1);
		return 0;
	}

	fives -= fives%9;

	for (int i = 0; i < fives; i++)
		printf("%i",5);

	
	if (fives == 0)
		printf("%i",0);
	else
		for (int i = 0; i < zeros; i++)
			printf("%i",0);
}
