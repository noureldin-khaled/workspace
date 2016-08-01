#include <bits/stdc++.h>

using namespace std;

char f(int i);
int main()
{
	string s1, s2, s3, s4;
	cin >> s1 >> s2 >> s3 >> s4;
	int a[4];
	a[0] = s1.length()-2;
	a[1] = s2.length()-2;
	a[2] = s3.length()-2;
	a[3] = s4.length()-2;

	int c = 0;
	int idx = -1;
	for (int i = 0; i < 4; i++)
	{
		bool valid = true;
		for (int j = 0; j < 4 && valid; j++)
		{
			if (i == j) continue;

			if (a[i]*2 > a[j])
				valid = false;
		}

		if (valid)
		{
			idx = i;
			c++;
		}
		else
		{
			valid = true;
			for (int j = 0; j < 4 && valid; j++)
			{
				if (i == j) continue;

				if (a[i] < 2*a[j])
					valid = false;
			}

			if (valid)
			{
				idx = i;
				c++;
			}
		}
	}

	if (c == 1)
		cout << f(idx) << endl;
	else
		cout << 'C' << endl;
}

char f(int i)
{
	switch(i)
	{
		case 0: return 'A';
		case 1: return 'B';
		case 2: return 'C';
		case 3: return 'D';
	}
}
