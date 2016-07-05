#include <bits/stdc++.h>

using namespace std;

int lcm(int a,int b);
int gcd( int a,  int b);
int main()
{
	int x, y, a, b;
	scanf("%i%i%i%i",&x,&y,&a,&b);

	int l = lcm(x, y);

	int ans = b/l - a/l;
	if (a%x == 0 && a%y == 0)
		ans++;
	printf("%i\n", ans);
}

int gcd( int a,  int b)
{
    return b == 0 ? a : gcd(b, a % b);
}

int lcm(int a,int b) 
{
	return (a*b)/gcd(a,b);
}
