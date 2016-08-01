#include <bits/stdc++.h>
#define toString( x ) dynamic_cast< std::ostringstream & >( \
( std::ostringstream() << std::dec << x ) ).str()

using namespace std;

int main()
{
	string s;
	cin >> s;

	int n = s.length();
	int ans = 0;
	while(n > 1)
	{
		int tmp = 0;
		for (int i = 0; i < n; i++)
			tmp += (s[i] - '0');

		ans++;
		s = toString(tmp);
		n = s.length();
	}

	printf("%i\n", ans);
}
