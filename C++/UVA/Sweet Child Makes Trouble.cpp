#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

int go(int n);
int main()
{
	fast

	long long a[801];
	a[1] = 0;
	a[2] = 1;
	long long c = 2;
	for (int i = 1; i < 801; i++)
		a[i] = (a[i-1] + a[i-2])*c++;

	for (int i = 1; i < 801; i++)
		cout << a[i] << endl;
}

int go(int n)
{
	int a[n];
	for (int i = 1; i <= n; i++)
		a[i-1] = i;

	int c = 0;
	do {
		bool valid = true;
		for (int i = 0; i < n && valid; i++)
		{
			if (a[i] == i+1)
				valid = false;
		}

		if (valid)
			c++;
	}
	while(next_permutation(a, a+n));

	return c;
}