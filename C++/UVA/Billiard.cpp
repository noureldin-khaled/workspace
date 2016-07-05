#include <bits/stdc++.h>
#define PI 3.14159265358979323846

using namespace std;

int main()
{
	int a, b, s, m, n;
	while(true)
	{
		scanf("%i%i%i%i%i",&a,&b,&s,&m,&n);
		if (a == 0 && b == 0 && s == 0 && m == 0 && n == 0) break;

		double x = a*m, y = b*n;
		double angle = atan(y/x) * 180/PI;
		double v = sqrt(x*x + y*y)/s;
		printf("%.2f %.2f\n", angle, v);
	}
}
