#include <bits/stdc++.h>
#define parseInt(x) atoi(x.c_str())


using namespace std;

char getType(string s);
int power(int base, int e);
int getColNum(string col);
string getColName(int col);
string getBase(int col);

int arr[6];
int main()
{
	arr[1] = 1;
	arr[2] = 27;
	arr[3] = 703;
	arr[4] = 18279;
	arr[5] = 475255;

	int n;
	scanf("%i",&n);

	for (int i = 0; i < n; i++)
	{
		string s;
		cin >> s;

		char type = getType(s);
		if (type == 'F')
		{
			int i = 0;
			string col = "";
			for (; i < s.length(); i++)
				if (s[i] >= 'A' && s[i] <= 'Z')
					col += s[i];
				else
					break;

			string row = "";
			for (; i < s.length(); i++)
				row += s[i];

			cout << "R" << row << "C" << getColNum(col) << endl;
		}
		else
		{
			int i = 1;
			string row = "";
			string col = "";

			for (; i < s.length(); i++)
			{
				if (s[i] == 'C') break;
				row += s[i];
			}
			
			i++;
			for (; i < s.length(); i++)
				col += s[i];

			cout << getColName(parseInt(col)) << row << endl;
		}
	}
}

string getBase(int col)
{
	if (col < 27)
		return "A";
	else if (col < 703)
		return "AA";
	else if (col < 18279)
		return "AAA";
	else if (col < 475255)
		return "AAAA";
	else
		return "AAAAA";
}

string getColName(int col)
{
	string base = getBase(col);
	int len = base.length();

	int rem = col - arr[len];
	for (int i = 0; i < len && rem > 0; i++)
	{
		int p = power(26, len - i - 1);
		base[i] += (rem / p);
		rem %= p;
	}

	return base;
}

int getColNum(string col)
{
	int len = col.length();
	int base = arr[len];

	int res = 0;
	for (int i = 0; i < len; i++)
	{
		int diff = col[len-i-1] - 'A';
		res += diff * power(26, i);
	}

	return res + base;
}

char getType(string s)
{
	if (s[0] != 'R')
		return 'F';
	else
	{
		if (s[1] >= 'A' && s[1] <= 'Z')
			return 'F';

		for (int i = 1; i < s.length(); i++)
			if (s[i] == 'C')
				return 'S';

		return 'F';
	}
}

int power(int base, int e) 
{
	if (e == 0)
		return 1;
	if (e%2 == 0) {
		int ans = power(base, e/2);
		return ans * ans;
	}
	else 
		return power(base, e-1)*base;
}
