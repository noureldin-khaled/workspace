#include <bits/stdc++.h>

using namespace std;

int main()
{
	string s;
	cin >> s;

	int len = s.length();
	int comm[len];
	comm[0] = 0;
	for (int i = 1; i < len; i++)
		comm[i] = comm[i-1] + (s[i] == s[i-1] ? 1 : 0);

	int q;
	scanf("%i",&q);

	while(q-->0)
	{
		int l, r;
		scanf("%i%i",&l, &r);
		l--;r--;

		printf("%i\n", comm[r] - comm[l]);
	}
}
