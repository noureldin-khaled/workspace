#include <bits/stdc++.h>

using namespace std;

long long SC[27];
long long C[27];

void pre();
long long nCr(int n, int k);
int main()
{
	pre();
	int n;
	while(scanf("%i",&n) != EOF)
		cout << SC[n] - C[n-1] << endl;
}

void pre()
{
	SC[1] = SC[2] = 1;
	for (int i = 3; i < 27; i++)
		SC[i] = (3*(2*i-3)*SC[i-1] - (i-3)*SC[i-2]) / i;

	for (int i = 0; i < 27; i++)
		C[i] = nCr(i << 1, i) / (i+1);
}

long long nCr(int n, int k)
{
	if (n < k)
		return 0;
	long long res = 1;
	for (int i = 1; i <= k; i++)
		res = (n - k + i) * res / i;

	return res;
}