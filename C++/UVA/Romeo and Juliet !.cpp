#include <bits/stdc++.h>
#define PI acos(-1)
#define DEG_TO_RAD(x) x*PI/180.0 

using namespace std;

int main()
{
	double x1, x2, y1, y2, CMD, ENF;

	while(scanf("%lf%lf%lf%lf%lf%lf", &x1, &y1, &x2, &y2, &CMD, &ENF) != EOF)
	{
		double AB = sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		double AM = AB / tan(DEG_TO_RAD(CMD));
		double AN = AB / tan(DEG_TO_RAD(ENF));

		printf("%.3f\n", AM+AN);
	}
}
