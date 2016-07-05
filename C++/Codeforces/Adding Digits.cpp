#include <bits/stdc++.h>
#define toString( x ) dynamic_cast< std::ostringstream & >( \
       ( std::ostringstream() << std::dec << x ) ).str()

using namespace std;

int main()
{
	int a, b, c;
	scanf("%i%i%i",&a,&b,&c);

	a *= 10;
	for (int i = 0; i <= 9; i++)
	{
		if ((a+i)%b == 0)
		{
			a += i;
			string res = toString(a);
			c--;
			while(c--)
				res += "0";
			cout << res << endl;
			return 0;
		}
	}

	cout << -1 << endl;
}
