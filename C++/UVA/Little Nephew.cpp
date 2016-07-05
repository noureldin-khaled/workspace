#include <bits/stdc++.h>

using namespace std;

int main()
{
	int a, b, c, d, e;
	while(true)
	{
		scanf("%i%i%i%i%i",&a,&b,&c,&d,&e);
		if (a == 0 && b == 0 && c == 0 && d == 0 && e == 0) break;

		cout << (long long)a*b*c*d*d*e*e << endl;
	}
}
