#include <bits/stdc++.h>
#define toString( x ) dynamic_cast< std::ostringstream & >( \
       ( std::ostringstream() << std::dec << x ) ).str()

using namespace std;

long long power(long long base,long long p)
{
   if (p == 0)
       return 1;
   return base*power(base,p-1);
}

int getSum(int num);
int main()
{
	long long a, b, c;
	cin >> a >> b >> c;

	vector<int> v;
	for (int i = 1; i <= 81; i++)
	{
		long long term = b * power(i, a) + c;
		if (term > 0 && term < 1000000000 && getSum(term) == i)
			v.push_back(term);
	}

	int s = v.size();
	printf("%i\n", s);

	for (int i = 0; i < s; i++)
		printf("%i ",v[i]);
}

int getSum(int num)
{
	int res = 0;

	string n = toString(num);
	for (int i = 0; i < n.length(); i++)
		res += (n[i] - '0');

	return res;
}