#include <bits/stdc++.h>
#define parseInt(x) atoi(x.c_str())
#define toString( x ) dynamic_cast< std::ostringstream & >( \
       ( std::ostringstream() << std::dec << x ) ).str()

using namespace std;

int trans(int num);
int main()
{
	int n, m;
	scanf("%i\n%i",&n,&m);

	int c = n+m;
	int n2 = trans(n);
	int m2 = trans(m);
	int c2 = trans(c);

	if (n2 + m2 == c2)
		puts("YES");
	else
		puts("NO");
}

int trans(int num)
{
	string s = toString(num);
	string r = "";

	for (int i = 0; i < s.length(); i++)
		if (s[i] != '0')
			r += s[i];

	return parseInt(r);
}

