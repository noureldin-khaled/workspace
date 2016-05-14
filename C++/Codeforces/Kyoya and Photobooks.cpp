#include <bits/stdc++.h>

using namespace std;

int main()
{
	string s;
	cin >> s;

	int x = s.length();

	cout << 26 * (x+1) - x;
}
