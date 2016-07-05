#include <bits/stdc++.h>

using namespace std;

string rev(string n);
int main()
{
	string n;
	cin >> n;

	cout << n << rev(n) << endl;
}

string rev(string n)
{
	string res = "";
	for (int i = n.length()-1; i >= 0; i--)
		res += n[i];
	return res;
}