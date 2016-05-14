#include <bits/stdc++.h>
#define PI 3.14159265358979323846

using namespace std;

int main()
{
	double d,h,v,e;
	cin >> d >> h >> v >> e;
	double r = d/2.0;
	
	if (PI*r*r*e >= v)
		cout << "NO" << endl;
	else
		printf("YES\n%.12f\n", (PI*r*r*h)/(v-PI*r*r*e));
}

