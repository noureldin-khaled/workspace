#include <bits/stdc++.h>

using namespace std;

int main()
{
	int a, b, c, l;
	scanf("%i %i %i %i",&a, &b, &c, &l);

	long long total = ((long long)(l+1) * (l+2) * (l+3))/6;

	for (int i = 0; i <= l; i++)
	{
		if (i + a < b + c) continue;

		long long x = min(l-i, i+a-b-c);
		total -= (x+1)*(x+2)/2;
	}

	for (int i = 0; i <= l; i++)
	{
		if (i + b < a + c) continue;

		long long x = min(l-i, i+b-a-c);
		total -= (x+1)*(x+2)/2;
	}

	for (int i = 0; i <= l; i++)
	{
		if (i + c < b + a) continue;

		long long x = min(l-i, i+c-b-a);
		total -= (x+1)*(x+2)/2;
	}

	cout << total << endl;
}
