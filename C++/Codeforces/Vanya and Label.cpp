#include <bits/stdc++.h>
#define MOD 1000000007

using namespace std;

long long power(long long base,long long p)
{
   if (p == 0)
       return 1;
   return base*power(base,p-1);
}

int main()
{
	string s;
	cin >> s;

	string l = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_";
	map<char, int> m;

	for (int i = 0; i < l.length(); i++)
		m[l[i]] = i;

	long long acc = 1;
	for (int i = 0; i < s.length(); i++)
	{
		int num = m.find(s[i])->second;
		long long ones = __builtin_popcount(num);
		long long zeros = 6 - ones;

		acc = (acc * power(3, zeros))%MOD;
	}

	cout << acc%MOD << endl;
}
