#include <bits/stdc++.h>

using namespace std;

int main()
{
	string home, away;
	cin >> home >> away;
	int n;
	scanf("%i",&n);

	int occ[2][100];
	memset(occ, 0, sizeof occ);
	for (int i = 0; i < n; i++)
	{
		int minutes, number;
		char team, type;
		scanf("%i %c %i %c",&minutes,&team,&number,&type);

		int idx = 0;
		if (team == 'a')
			idx = 1;

		if (type == 'y')
			occ[idx][number]++;
		else
		{
			if (occ[idx][number] >= 2)
				occ[idx][number]++;
			else
				occ[idx][number] = 2;
		}

		if (occ[idx][number] == 2)
		{
			string name = home;
			if (team == 'a')
				name = away;
			cout << name << " " << number << " " << minutes << endl;
		}
	}
}
