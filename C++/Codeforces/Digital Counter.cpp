#include <bits/stdc++.h>

using namespace std;

int main()
{
	int arr[10] = {2, 7, 2, 3, 3, 4, 2, 5, 1, 2};
	string s;
	cin >> s;

	int first = s[0] - '0';
	int second = s[1] - '0';

	printf("%i\n", arr[first] * arr[second]);
}


