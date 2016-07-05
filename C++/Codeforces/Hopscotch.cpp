#include <bits/stdc++.h>

using namespace std;

int main()
{
	int a, x, y;
	scanf("%i%i%i",&a,&x,&y);

	if (abs(x) >= a || y <= 0 || y%a == 0)
	{
		printf("%i\n", -1);
		return 0;
	}

	if (a > y)
	{
		if (abs(x) >= a/2.0)
			printf("%i\n", -1);
		else
			printf("%i\n", 1);
		return 0;
	}

	int id = 2;
	int cur = a;
	while(true)
	{
		if (cur + a > y)
		{
			if (abs(x) >= a/2.0)
				printf("%i\n", -1);
			else
				printf("%i\n", id);
			return 0;
		}
		cur += a;
		id++;

		if (cur + a > y)
		{
			if (x > 0)
				printf("%i\n", id+1);
			else if (x < 0)
				printf("%i\n", id);
			else
				printf("%i\n", -1);
			return 0;
		}

		cur += a;
		id += 2;
	}
	
}
