#include <bits/stdc++.h>
#define PI 3.14159265358979323846

using namespace std;

int main()
{
	int t;
	scanf("%i",&t);

	while(t--)
	{
		int d, l;
		scanf("%i%i",&d,&l);

		double x = ((double)l-d)/2.0;
		double a = (double)l/2.0;

		double r1 = sqrt(a*a - (d*d)/4.0);
		double r2 = (double)d/2.0 + x;

		printf("%.3f\n",PI*r1*r2);
	}
}
