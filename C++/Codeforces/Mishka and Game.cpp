#include <bits/stdc++.h>
#define fast ios_base::sync_with_stdio(0);cin.tie(0);

using namespace std;

int main()
{
	int n;
	scanf("%i",&n);

	int mishka = 0, chris = 0;
	for (int i = 0; i < n; i++)
	{
		int m, c;
		scanf("%i%i",&m,&c);
		if (m > c)
			mishka++;
		else if (c > m)
			chris++;
	}

	puts(mishka > chris ? "Mishka" : chris > mishka ? "Chris" : "Friendship is magic!^^");
}