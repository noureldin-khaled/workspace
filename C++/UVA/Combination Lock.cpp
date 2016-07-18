#include <bits/stdc++.h>

using namespace std;

int MOD(int a, int m);
int main()
{
	int s, a, b, c;
	while(true)
	{
		scanf("%i%i%i%i",&s,&a,&b,&c);
		if (s+a+b+c == 0) break;

		int ans = 360*2;
		ans += MOD(s-a, 40)*9;
		ans += 360;
		ans += MOD(b-a, 40)*9;
		ans += MOD(b-c, 40)*9;

		printf("%i\n", ans);
	}
}

int MOD(int a, int m)
{
	return (a%m + m)%m;
}