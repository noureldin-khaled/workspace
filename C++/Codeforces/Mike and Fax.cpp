#include <bits/stdc++.h>

using namespace std;

string s;

bool isPalindrome(int start, int end);
int main()
{
	cin >> s;
	int k;
	scanf("%i", &k);

	int len = s.length();
	if (len%k != 0)
	{
		puts("NO");
		return 0;
	}

	int each = len/k;

	bool valid = true;
	for (int i = 0; i < len && valid; i += each)
	{
		if (!isPalindrome(i, i+each-1))
			valid = false;
	}

	valid ? cout << "YES" << endl: cout << "NO" << endl;
}

bool isPalindrome(int start, int end)
{
	for (int i = start, j = end; i < j; i++, j--)
	{
		if (s[i] != s[j])
			return false;
	}
	return true;
}
