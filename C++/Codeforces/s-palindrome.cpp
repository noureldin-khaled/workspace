#include <bits/stdc++.h>

using namespace std;

bool isSPalindrome();
bool isReflection(char c1, char c2);

string s;
int n;
int main()
{
	cin >> s;
	n = s.length();

	if (isSPalindrome())
		puts("TAK");
	else
		puts("NIE");
}

bool isSPalindrome()
{
	int lmt = n%2 == 0 ? n/2 : n/2+1;
	for (int i = 0; i < lmt; i++)
	{
		if (!isReflection(s[i], s[n-1-i]))
			return false;
	}

	return true;
}

bool isReflection(char c1, char c2)
{
	switch(c1)
	{
		case 'A': return c2 == 'A';
		case 'b': return c2 == 'd';
		case 'd': return c2 == 'b';
		case 'H': return c2 == 'H';
		case 'I': return c2 == 'I';
		case 'M': return c2 == 'M';
		case 'O': return c2 == 'O';
		case 'o': return c2 == 'o';
		case 'p': return c2 == 'q';
		case 'q': return c2 == 'p';
		case 'T': return c2 == 'T';
		case 'U': return c2 == 'U';
		case 'V': return c2 == 'V';
		case 'v': return c2 == 'v';
		case 'W': return c2 == 'W';
		case 'w': return c2 == 'w';
		case 'X': return c2 == 'X';
		case 'x': return c2 == 'x';
		case 'Y': return c2 == 'Y';
		default: return false;
	}
}