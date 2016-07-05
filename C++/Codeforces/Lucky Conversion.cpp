#include <bits/stdc++.h>

using namespace std;

int main()
{
	string s1, s2;
	cin >> s1 >> s2;

	int len = s1.length();
	int mis4 = 0;
	int mis7 = 0;

	for (int i = 0; i < len; i++)
		if (s1[i] != s2[i])
			if (s1[i] == '4')
				mis4++;
			else
				mis7++;

	printf("%i\n", max(mis4, mis7));
}
