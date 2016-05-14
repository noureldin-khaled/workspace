#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, d, h;
	scanf("%i%i%i", &n, &d, &h);

	if (2*h < d || (h == 1 && d == 1 && n > 2)) 
	{
		printf("%i\n", -1);
		return 0;
	}

	int base = d == h ? 2 : 1;
	int prev = 1;
	int i = 2;
	for (; i <= h+1; i++)
	{
		printf("%i %i\n", prev, i);
		prev = i;
		n--;
	}

	d -= h;
	prev = 1;
	while(d-->0)
	{
		printf("%i %i\n", prev, i);
		prev = i;
		i++;
		n--;
	}

	n--;
	prev = i;
	while(n-->0)
	{
		printf("%i %i\n", base, prev);
		prev++;
	}
}
