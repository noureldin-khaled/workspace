#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

int main()
{
	int f;
	scanf("%i",&f);

	int rem = 12-f;
	if (rem*45 <= 4*60)
		puts("YES");
	else
		puts("NO");
}