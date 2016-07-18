#include <bits/stdc++.h>

using namespace std;

int main()
{
	string m[12] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
	string d[7] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	int monthDays[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	map<string, int> month;
	map<string, int> day;
	for (int i = 0; i < 12; i++)
		month[m[i]] = i;
	for (int i = 0; i < 7; i++)
		day[d[i]] = i;

	int t;
	scanf("%i",&t);

	while(t--)
	{
		string mth, dy;
		cin >> mth >> dy;

		int days = monthDays[month.find(mth)->second];
		int curDay = day.find(dy)->second;
		int i = 0;
		int ans = 0;
		while(i < days)
		{
			if (curDay == 5 || curDay == 6)
				ans++;
			curDay = (curDay+1)%7;
			i++;
		}

		printf("%i\n", ans);
	}
}