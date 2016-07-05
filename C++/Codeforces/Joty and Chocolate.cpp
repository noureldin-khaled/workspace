#include <bits/stdc++.h>

using namespace std;

long long gcd(long long a,  long long b);
long long lcm(long long a,long long b);
int main()
{
	long long n, a, b, p, q;
	cin >> n >> a >> b >> p >> q;
	long long l = lcm(a, b);
	cout << (n/l)*max(p, q) + (n/a)*p + (n/b)*q - (n/l)*p - (n/l)*q << endl;
}

long long gcd(long long a,  long long b)
{
    return b == 0 ? a : gcd(b, a % b);
}

long long lcm(long long a,long long b)
{
	return (a*b)/gcd(a,b);
}