#include <bits/stdc++.h>

using namespace std;

int main()
{
	string s1, s2;
	cin >> s1;
	cin >> s2;

	int n = s1.length();

	int fp = 0;
	int fm = 0;
	int sp = 0;
	int sm = 0;

	for (int i = 0; i < n; i++)
		s1[i] == '+' ? fp++ : fm++;

	for (int i = 0; i < n; i++)
	{
		if (s2[i] == '+')
			sp++;
		else if (s2[i] == '-')
			sm++;
	}

	int qs = n - (sp+sm);

	int v = 0;
	for (int i = 0; i < (1 << qs); i++)
	{
		int tp = 0;
		int tm = 0;

		for (int j = 0; j < qs; j++)
			if (((1 << j) & i) == 0)
				tm++;
			else
				tp++;

		if (tp + sp == fp && tm + sm == fm)
			v++;
	}

	printf("%.13f\n", (double)v/(1 << qs));
}

