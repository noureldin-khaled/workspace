#include <bits/stdc++.h>
#define parseInt(x) atoi(x.c_str())
#define toString( x ) dynamic_cast< std::ostringstream & >( \
       ( std::ostringstream() << std::dec << x ) ).str()

using namespace std;

int main()
{
	string line;
	cin >> line;

	string format = "";
	format += line[8];
	format += line[9];

	if (format.compare("AM") == 0)
	{
		string ans = "";
		ans += line[0];
		ans += line[1];

		if (ans.compare("12") == 0)
			ans = "00";

		ans += line[2];
		ans += line[3];
		ans += line[4];
		ans += line[5];
		ans += line[6];
		ans += line[7];

		cout << ans << endl;
	}
	else
	{
		string hours = "";
		hours += line[0];
		hours += line[1];
		int h = parseInt(hours);
		if (h != 12)
			h += 12;

		string ans = "";
		string ha = toString(h);

		ans += ha;
		ans += ":";
		ans += line[3];
		ans += line[4];
		ans += line[5];
		ans += line[6];
		ans += line[7];
		if (ha.length() == 1)
			ans = "0" + ans;

		cout << ans << endl;
	}
}
