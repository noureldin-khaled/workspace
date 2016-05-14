#include <bits/stdc++.h>

using namespace std;

int main()
{
	int n, c;
	scanf("%i%i",&n,&c);

	int p[n];
	int t[n];
	for (int i = 0; i < n; i++)
		scanf("%i",&p[i]);
	
	for (int i = 0; i < n; i++)
		scanf("%i",&t[i]);

	int ans1 = 0;
	int time = 0;
	for (int i = 0; i < n; i++)
	{
		int acc = time + t[i];
		ans1 += max(0, p[i]-c*acc);
		time = acc;
	}


	int ans2 = 0;
	time = 0;
	for (int i = n-1; i >= 0; i--)
	{
		int acc = time + t[i];
		ans2 += max(0, p[i]-c*acc);
		time = acc;
	}

	if (ans1 > ans2)
		cout << "Limak" << endl;
	else if (ans1 < ans2)
		cout << "Radewoosh" << endl;
	else
		cout << "Tie" << endl;

}	
