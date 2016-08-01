#include <bits/stdc++.h>
#define M 1000000007

using namespace std;

long long MOD(long long a, long long b);
int main()
{
	int t, k;
	scanf("%i%i",&t,&k);

	long long a[100001];
	for (int i = 0; i < k; i++)
		a[i] = 1;

	for (int i = k; i < 100001; i++)
		a[i] = MOD(a[i-1] + a[i-k], M);

	long long b[100001];
	b[0] = a[0];
	for (int i = 1; i < 100001; i++)
		b[i] = MOD(a[i] + b[i-1], M);

	while(t--)
	{
		int l, r;
		scanf("%i%i",&l,&r);

		cout << MOD(b[r] - b[l-1], M) << endl;
	}
}

long long MOD(long long a, long long b)
{
	return (a%b + b)%b;
}
