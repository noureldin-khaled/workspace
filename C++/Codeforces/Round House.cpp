#include <bits/stdc++.h>

using namespace std;

int MOD(int a,int b);
int main()
{
	int n, a, b;
	scanf("%i%i%i", &n, &a, &b);

	int ans = MOD((a + b), n);

	if (ans == 0)
		ans = n;
	printf("%i", ans);
}

int MOD(int a,int b)
{
	return (a%b + b)%b;
}