#include <bits/stdc++.h>

using namespace std;

int gcd( int a,  int b);
int main()
{
	int y, w;
	scanf("%i%i",&y,&w);

	int d = 6-max(y, w) + 1;

	int g = gcd(d, 6);
	printf("%i/%i\n",d/g,6/g);
}

int gcd( int a,  int b) 
{
    return b == 0 ? a : gcd(b, a % b);
}


