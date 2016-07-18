#include <bits/stdc++.h>

using namespace std;

int main()
{
	int t, s, x;
	scanf("%i%i%i",&t,&s,&x);

	if (((x-t)%s == 0 && (x-t) >= 0) || ((x-t-1)%s == 0 && (x-t-1) > 0))
		puts("YES");
	else
		puts("NO");
}
