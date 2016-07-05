#include <bits/stdc++.h>
#define EPS 1e-9

using namespace std;

int main()
{
	int t = 1;
	double a, b, c;
	while(true)
	{
		scanf("%lf",&a);
		if (a + EPS < 0)
			break;
		scanf("%lf%lf",&b,&c);
		printf("Set %i:\n", t++);
		if (abs(b) < EPS || abs(b*b - a*c) < EPS)
		{
			puts("Poor King!");
			continue;
		}

		double y = (a*b*c + a*a*c) / (b*b - a*c);
		double x = (a+y)*(c/b);
		double d = x+y;

		if (d + EPS < 0)
			puts("Poor King!");
		else
			printf("%.4f\n", d);
	}
}
