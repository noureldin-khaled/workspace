#include <bits/stdc++.h>
#define parseInt(x) atoi(x.c_str())

using namespace std;

int main()
{
	string num;
	cin >> num;

	int s = 0;
	for (int i = 0; i < num.length(); i++)
	{
		int digit = num[i] - '0';
		s = max(s, digit);
	}

	string arr[s];
	for (int i = 0; i < s; i++)
		arr[i] = "";

	for (int i = 0; i<  num.length(); i++)
	{
		int digit = num[i] - '0';
		int j = 0;
		for (; j < digit; j++)
			arr[j] += "1";

		for (; j < s; j++)
			arr[j] += "0";
	}

	printf("%i\n", s);
	for (int i = 0; i < s; i++)
		printf("%i ", parseInt(arr[i]));
}

