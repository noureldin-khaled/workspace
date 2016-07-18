#include <bits/stdc++.h>

using namespace std;

int n, h, t;

void rec(int idx, int ones, string soFar);
int main()
{
	scanf("%i",&t);
	while(t--)
	{
		scanf("%i%i",&n,&h);

		rec(0, 0, "");
		if (t > 0)
			puts("");
	}
}

void rec(int idx, int ones, string soFar)
{
	if (idx == n)
	{
		if (ones == h)
			cout << soFar << endl;
		return;
	}

	soFar += "0";
	rec(idx+1, ones, soFar);
	soFar[idx] = '1';
	rec(idx+1, ones+1, soFar);
}