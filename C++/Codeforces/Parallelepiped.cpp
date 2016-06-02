#include <bits/stdc++.h>

using namespace std;

int main()
{
	long long a, b, c;
	cin >> a >> b >> c;

	long long h = sqrt((a*b)/c);
	long long l = b/h;
	long long w = a/h;

	cout << h*4 + l*4 + w*4 << endl;
}


