#include <bits/stdc++.h>
#define SSTR( x ) dynamic_cast< std::ostringstream & >( \
       ( std::ostringstream() << std::dec << x ) ).str()

using namespace std;

int main()
{
	string s = "";
	for (int i = 1; i <= 370; i++)
		s += SSTR(i);

	int n;
	scanf("%i",&n);

	cout << s[n-1] << endl;
}

