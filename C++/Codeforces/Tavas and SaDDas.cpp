#include <bits/stdc++.h>
#define toString( x ) dynamic_cast< std::ostringstream & >( \
       ( std::ostringstream() << std::dec << x ) ).str()

using namespace std;

map<string, int> m;
int c = 1;

void go(string s, int index, int len);
int main()
{
	go("4", 0, 1);
	go("44", 0, 2);
	go("444", 0, 3);
	go("4444", 0, 4);
	go("44444", 0, 5);
	go("444444", 0, 6);
	go("4444444", 0, 7);
	go("44444444", 0, 8);
	go("444444444", 0, 9);
	go("4444444444", 0, 10);

	int n;
	scanf("%i",&n);

	map<string, int>::iterator it = m.find(toString(n));
	cout << it->second << endl;
}

void go(string s, int index, int len)
{
	if (index == len)
	{
		m[s] = c;
		c++;
		return;
	}

	go(s, index+1, len);
	s[index] = '7';
	go(s, index+1, len);
}
