#include <bits/stdc++.h>
#define parseInt(x) atoi(x.c_str())
#define toString( x ) dynamic_cast< std::ostringstream & >( \
( std::ostringstream() << std::dec << x ) ).str()

using namespace std;

int mod(int a, int m);
int main()
{
	string s, t;
	cin >> s;
	cin >> t;

	string Shours = "";
	Shours += s[0];
	Shours += s[1];
	string Smins = "";
	Smins += s[3];
	Smins += s[4];

	string Thours = "";
	Thours += t[0];
	Thours += t[1];
	string Tmins = "";
	Tmins += t[3];
	Tmins += t[4];

	int sh = parseInt(Shours);
	int sm = parseInt(Smins);
	int th = parseInt(Thours);
	int tm = parseInt(Tmins);

	int ah = mod(sh-th, 24);
	int am = mod(sm-tm, 60);
	if (sm-tm < 0)
		ah = mod(ah-1, 24);

	string outH = toString(ah);
	string outM = toString(am);
	if (outH.length() == 1)
		outH = "0" + outH;
	if (outM.length() == 1)
		outM = "0" + outM;


	cout << outH << ":" << outM << endl;
}

int mod(int a, int m)
{
	return (a%m + m)%m;
}
